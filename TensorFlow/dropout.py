from __future__ import print_function

import tensorflow as tf
from sklearn.datasets import load_digits
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import LabelBinarizer

from tensorflow.examples.tutorials.mnist import input_data





def add_layer(inputs, in_size, out_size,layer_name, activation_function=None):
    # with tf.name_scope('layer'):
    #     with tf.name_scope('Weights'):
    Weight = tf.Variable(tf.random.normal([in_size, out_size]))
    # tf.summary.histogram(layer_name + '/weights', Weight)
        # with tf.name_scope('biases'):
    biases = tf.Variable(tf.zeros([1, out_size]) + 0.1)
    # tf.summary.histogram(layer_name + '/biases', biases)
        # with tf.name_scope('Wx_plus_b'):
    Wx_plus_b = tf.matmul(inputs, Weight) + biases
    Wx_plus_b = tf.nn.dropout(Wx_plus_b,rate = 1.-keep_prob)
    if activation_function is None:
        outputs = Wx_plus_b
    else:
        outputs = activation_function(Wx_plus_b)
    tf.compat.v1.summary.histogram(layer_name + '/outputs', outputs)
    return outputs


# def compute_accuracy(v_xs, v_ys):
#     global prediction
#     y_pre = sess.run(prediction, feed_dict={xs: v_xs})
#     correct_prediction = tf.equal(tf.argmax(y_pre, 1), tf.argmax(v_ys, 1))
#     accuracy = tf.reduce_mean(tf.cast(correct_prediction, tf.float32))
#     result = sess.run(accuracy, feed_dict={xs: v_xs, ys: v_ys})
#     return result




if __name__ == '__main__':

    digits = load_digits()
    X = digits.data
    y = LabelBinarizer().fit_transform(digits.target)

    X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.3)

    xs = tf.compat.v1.placeholder(tf.float32, [None, 64])
    ys = tf.compat.v1.placeholder(tf.float32, [None, 10])

    keep_prob = tf.compat.v1.placeholder(tf.float32)

    l1 = add_layer(xs,64,50,'l1',activation_function=tf.nn.tanh)
    prediction=add_layer(l1,50,10, 'l2',activation_function=tf.nn.softmax)

    cross_entropy = tf.reduce_mean(-tf.reduce_sum(ys * tf.math.log(prediction),
                                                  reduction_indices=[1]))  # loss
    tf.compat.v1.summary.scalar('loss',cross_entropy)

    train_step = tf.compat.v1.train.GradientDescentOptimizer(0.5).minimize(cross_entropy)

    with tf.compat.v1.Session() as sess:
        merged = tf.compat.v1.summary.merge_all()  #train和test的summary

        train_writer = tf.compat.v1.summary.FileWriter("logs/train",sess.graph)
        test_writer = tf.compat.v1.summary.FileWriter("logs/test", sess.graph)

        init = tf.compat.v1.global_variables_initializer()

        sess.run(init)

        for i in range(2000):
            sess.run(train_step,feed_dict={xs:X_train,ys:y_train,keep_prob:0.5})
            if i%50==0:
                train_result = sess.run(merged,feed_dict={xs:X_train,ys:y_train,keep_prob:1})
                test_result = sess.run(merged,feed_dict={xs:X_test,ys:y_test,keep_prob:1})
                train_writer.add_summary(train_result,i)
                test_writer.add_summary(test_result,i)



