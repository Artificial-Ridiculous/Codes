import tensorflow as tf
import numpy as np
import matplotlib.pyplot as plt

if __name__ == '__main__':
    # matrix1 = tf.constant([[3, 3]])
    # matrix2 = tf.constant([[2],
    #                        [3]])
    # product = tf.matmul(matrix1, matrix2)
    #
    # sess = tf.Session()
    # result = sess.run(product)
    # print(result)
    # sess.close()

    # state = tf.Variable(0, name='counter')
    # one = tf.constant(1)
    # new_value = tf.add(state, one)
    # update = tf.assign(state, new_value)
    # init = tf.initialize_all_variables()
    # with tf.Session() as sess:
    #     sess.run(init)
    #     for _ in range(3):
    #         sess.run(update)
    #         print(sess.run(state))

    # input1 = tf.placeholder(tf.float32)
    # input2 = tf.placeholder(tf.float32)
    #
    # output = tf.multiply(input1, input2)
    #
    # with tf.Session() as sess:
    #     print(sess.run(output, feed_dict={input1: [7.0], input2: [2.0]}))

    def add_layer(input, in_size, out_size, activation_function=None):

        with tf.name_scope('layer'):
            with tf.name_scope('weights'):
                Weight = tf.Variable(tf.random_normal([in_size, out_size]),name='W')
            with tf.name_scope('biases'):
                biases = tf.Variable(tf.zeros([1, out_size]) + 0.1)
            with tf.name_scope('Wx_plus_b'):
                Wx_plus_b = tf.matmul(input, Weight) + biases
            if activation_function is None:
                outputs = Wx_plus_b
            else:
                outputs = activation_function(Wx_plus_b)
            return outputs


    x_data = np.linspace(-1, 1, 300)[:, np.newaxis]
    noisy = np.random.normal(0, 0.05, x_data.shape)
    y_data = np.square(x_data) - 0.5 + noisy  # y大致是x的二次函数

    with tf.name_scope('inputs'):

        xs = tf.placeholder(tf.float32, [None, 1], name='x_input')  # 输入；None 无论给多少个sample都ok；feature维度是1
        ys = tf.placeholder(tf.float32, [None, 1], name='y_input')  # 输出；None 无论给多少个sample都ok；feature维度是1

    l1 = add_layer(xs, 1, 10, activation_function=tf.nn.relu)
    prediction = add_layer(l1, 10, 1, activation_function=None)

    with tf.name_scope('Loss'):
        loss = tf.reduce_mean(tf.reduce_sum(tf.square(ys - prediction),
                                        reduction_indices=[1]))  # 对每个预测的误差二次方求和再求平均
    with tf.name_scope('Train'):
        train_step = tf.train.GradientDescentOptimizer(0.1).minimize(loss)
    init = tf.global_variables_initializer()



    with tf.compat.v1.Session() as sess:
        writer = tf.summary.FileWriter("logs/", sess.graph)
        sess.run(init)
        # print("初始误差=", end="")
        # print(sess.run(loss, feed_dict={xs: x_data, ys: y_data}))

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
                plt.pause(0.1)
            sess.run(train_step, feed_dict={xs: x_data, ys: y_data})  # xs不一定是全量sample。这样封装方便sgd
        plt.ioff()
        plt.show()
