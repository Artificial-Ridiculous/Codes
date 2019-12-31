import tensorflow as tf
import numpy as np
import matplotlib.pyplot as plt
from tensorflow.examples.tutorials.mnist import input_data


def add_layer(input, in_size, out_size, n_layer, activation_function=None):
    layer_name = 'layer%s' % n_layer
    with tf.name_scope('layer'):
        with tf.name_scope('weights'):
            Weight = tf.Variable(tf.random_normal([in_size, out_size]), name='W')
            tf.summary.histogram(layer_name + '/weights', Weight)
        with tf.name_scope('biases'):
            biases = tf.Variable(tf.zeros([1, out_size]) + 0.1)
            tf.summary.histogram(layer_name + '/biases', biases)
        with tf.name_scope('Wx_plus_b'):
            Wx_plus_b = tf.matmul(input, Weight) + biases
        if activation_function is None:
            outputs = Wx_plus_b
        else:
            outputs = activation_function(Wx_plus_b)
            tf.summary.histogram(layer_name + '/outputs', outputs)
        return outputs


if __name__ == '__main__':

    x_data = np.linspace(-1, 1, 300)[:, np.newaxis]
    noisy = np.random.normal(0, 0.05, x_data.shape)
    y_data = np.square(x_data) - 0.5 + noisy  # y大致是x的二次函数

    with tf.name_scope('inputs'):

        xs = tf.placeholder(tf.float32, [None, 1], name='x_input')  # 输入；None 无论给多少个sample都ok；feature维度是1
        ys = tf.placeholder(tf.float32, [None, 1], name='y_input')  # 输出；None 无论给多少个sample都ok；feature维度是1

    l1 = add_layer(xs, 1, 10, 1, activation_function=tf.nn.relu)
    prediction = add_layer(l1, 10, 1, 2, activation_function=None)

    with tf.name_scope('Loss'):
        loss = tf.reduce_mean(tf.reduce_sum(tf.square(ys - prediction),
                                            reduction_indices=[1]))  # 对每个预测的误差二次方求和再求平均
        tf.summary.scalar('loss',loss)
    with tf.name_scope('Train'):
        train_step = tf.train.AdamOptimizer(0.1).minimize(loss)
    init = tf.global_variables_initializer()

    with tf.compat.v1.Session() as sess:
        merged = tf.summary.merge_all()
        writer = tf.summary.FileWriter("logs/", sess.graph)
        sess.run(init)
        print("初始误差=", end="")
        print(sess.run(loss, feed_dict={xs: x_data, ys: y_data}))

        fig = plt.figure()
        ax = fig.add_subplot(1, 1, 1)
        ax.scatter(x_data, y_data)
        plt.ion()

        for i in range(1001):

            # if i == 0:
            #     print("第" + str(i+1) + "次迭代后误差=", end="")
            #     print(sess.run(loss, feed_dict={xs: x_data, ys: y_data}))  # 凡是通过placeholder进行运算的东西都要feed
            if i % 50 == 0:
                print("Iter[" + str(i) + "]\t\tloss = ", end="")
                print(sess.run(loss, feed_dict={xs: x_data, ys: y_data}))  # 凡是通过placeholder进行运算的东西都要feed

            try:
                ax.lines.remove(lines[0])
            except Exception:
                pass

            prediction_value = sess.run(prediction, feed_dict={xs: x_data})
            lines = ax.plot(x_data, prediction_value, 'r-', lw=5)
            # ax.lines.remove(lines[0])
            # plt.pause(0.1)
            result = sess.run(merged, feed_dict={xs: x_data, ys: y_data})
            writer.add_summary(result, i)
            sess.run(train_step, feed_dict={xs: x_data, ys: y_data})  # xs不一定是全量sample。这样封装方便sgd
        plt.ioff()
        plt.show()

