// Databricks notebook source exported at Tue, 28 Jun 2016 09:28:40 UTC
// MAGIC %md
// MAGIC 
// MAGIC # [Scalable Data Science](http://www.math.canterbury.ac.nz/~r.sainudiin/courses/ScalableDataScience/)
// MAGIC 
// MAGIC 
// MAGIC ### prepared by [Raazesh Sainudiin](https://nz.linkedin.com/in/raazesh-sainudiin-45955845) and [Sivanand Sivaram](https://www.linkedin.com/in/sivanand)
// MAGIC 
// MAGIC *supported by* [![](https://raw.githubusercontent.com/raazesh-sainudiin/scalable-data-science/master/images/databricks_logoTM_200px.png)](https://databricks.com/)
// MAGIC and 
// MAGIC [![](https://raw.githubusercontent.com/raazesh-sainudiin/scalable-data-science/master/images/AWS_logoTM_200px.png)](https://www.awseducate.com/microsite/CommunitiesEngageHome)

// COMMAND ----------

// MAGIC %md
// MAGIC The [html source url](https://raw.githubusercontent.com/raazesh-sainudiin/scalable-data-science/master/db/week9/16_Deep_learning/030_Deep_learning.html) of this databricks notebook and its recorded Uji ![Image of Uji, Dogen's Time-Being](https://raw.githubusercontent.com/raazesh-sainudiin/scalable-data-science/master/images/UjiTimeBeingDogen.png "uji"):
// MAGIC 
// MAGIC [![sds/uji/week9/16_Deep_learning/030_Deep_learning](http://img.youtube.com/vi/iDyeK3GvFpo/0.jpg)](https://www.youtube.com/v/iDyeK3GvFpo?rel=0&autoplay=1&modestbranding=1&end=3092)

// COMMAND ----------

// MAGIC %md
// MAGIC # Deep learning: A Crash Introduction
// MAGIC 
// MAGIC This notebook provides an introduction to Deep Learning. It is meant to help you descend more fully into these learning resources and references:
// MAGIC * Udacity's course on Deep Learning [https://www.udacity.com/course/deep-learning--ud730](https://www.udacity.com/course/deep-learning--ud730) by Arpan Chakraborty and Vincent Vanhoucke
// MAGIC * Neural networks and deep learning [http://neuralnetworksanddeeplearning.com/](http://neuralnetworksanddeeplearning.com/) by Michael Nielsen 
// MAGIC * Deep learning book [http://www.deeplearningbook.org/](http://www.deeplearningbook.org/) by Ian Goodfellow, Yoshua Bengio and Aaron Courville

// COMMAND ----------

// MAGIC %md
// MAGIC * Deep learning - buzzword for Artifical Neural Networks
// MAGIC * What is it?
// MAGIC   * Supervised learning model - Classifier
// MAGIC   * Unsupervised model - Anomaly detection
// MAGIC * Needs lots of data
// MAGIC * Online learning model - backpropogation
// MAGIC * Optimization - Stochastic gradient descent   
// MAGIC * Regularization - L1, L2, Dropout
// MAGIC ***
// MAGIC ***
// MAGIC * Supervised
// MAGIC   - Fully connected network
// MAGIC   - Convolutional neural network - Eg: For classifying images
// MAGIC   - Recurrent neural networks - Eg: For use on text, speech
// MAGIC * Unsupervised
// MAGIC   - Autoencoder

// COMMAND ----------

// MAGIC %md
// MAGIC ***
// MAGIC ***
// MAGIC 
// MAGIC ### A quick recap of logistic regression / linear models
// MAGIC 
// MAGIC **(watch now 46 seconds)**:
// MAGIC 
// MAGIC [![Udacity: Deep Learning by Vincent Vanhoucke - Training a logistic classifier](http://img.youtube.com/vi/G8eNWzxOgqE/0.jpg)](https://www.youtube.com/v/G8eNWzxOgqE?rel=0&autoplay=1&modestbranding=1&start=4&end=50)
// MAGIC 
// MAGIC ***
// MAGIC 
// MAGIC -- Video Credit: Udacity's deep learning by Arpan Chakraborthy and Vincent Vanhoucke
// MAGIC 
// MAGIC ***
// MAGIC #### Regression
// MAGIC ![Regression](https://upload.wikimedia.org/wikipedia/commons/3/3a/Linear_regression.svg)  
// MAGIC y = mx + c

// COMMAND ----------

// MAGIC %md
// MAGIC **Another way to look at a linear model**  
// MAGIC 
// MAGIC ![Another way to look at a linear model](http://neuralnetworksanddeeplearning.com/images/tikz0.png)
// MAGIC 
// MAGIC -- Image Credit: Michael Nielsen  

// COMMAND ----------

// MAGIC %md
// MAGIC ***
// MAGIC ***
// MAGIC 
// MAGIC ### Recap - Gradient descent
// MAGIC 
// MAGIC **(1:54 seconds)**:
// MAGIC 
// MAGIC [![Udacity: Deep Learning by Vincent Vanhoucke - Gradient descent](http://img.youtube.com/vi/x449QQDhMDE/0.jpg)](https://www.youtube.com/v/x449QQDhMDE?rel=0&autoplay=1&modestbranding=1)
// MAGIC 
// MAGIC ***
// MAGIC -- Video Credit: Udacity's deep learning by Arpan Chakraborthy and Vincent Vanhoucke

// COMMAND ----------

// MAGIC %md
// MAGIC ***
// MAGIC ***
// MAGIC 
// MAGIC ### Recap - Stochastic Gradient descent
// MAGIC 
// MAGIC **(2:25 seconds)**:
// MAGIC 
// MAGIC [![Udacity: Deep Learning by Vincent Vanhoucke - Stochastic Gradient descent](http://img.youtube.com/vi/hMLUgM6kTp8/0.jpg)](https://www.youtube.com/v/hMLUgM6kTp8?rel=0&autoplay=1&modestbranding=1)
// MAGIC 
// MAGIC ***
// MAGIC -- Video Credit: Udacity's deep learning by Arpan Chakraborthy and Vincent Vanhoucke

// COMMAND ----------

// MAGIC %md 
// MAGIC HOGWILD! Parallel SGD without locks [http://i.stanford.edu/hazy/papers/hogwild-nips.pdf](http://i.stanford.edu/hazy/papers/hogwild-nips.pdf)

// COMMAND ----------

// MAGIC %md
// MAGIC ***
// MAGIC ***
// MAGIC 
// MAGIC ### Why deep learning? - Linear model
// MAGIC 
// MAGIC **(24 seconds)**:
// MAGIC 
// MAGIC [![Udacity: Deep Learning by Vincent Vanhoucke - Linear model](http://img.youtube.com/vi/PfNfY1xmkLs/0.jpg)](https://www.youtube.com/v/PfNfY1xmkLs?rel=0&autoplay=1&modestbranding=1&start=15&end=39)
// MAGIC 
// MAGIC ***
// MAGIC -- Video Credit: Udacity's deep learning by Arpan Chakraborthy and Vincent Vanhoucke

// COMMAND ----------

// MAGIC %md
// MAGIC **ReLU - Rectified linear unit or Rectifier** - max(0, x)
// MAGIC 
// MAGIC ![ReLU](https://upload.wikimedia.org/wikipedia/en/6/6c/Rectifier_and_softplus_functions.svg)
// MAGIC 
// MAGIC -- Image Credit: Wikipedia

// COMMAND ----------

// MAGIC %md
// MAGIC ***
// MAGIC *** 
// MAGIC 
// MAGIC **Neural Network** 
// MAGIC  
// MAGIC Watch now (45 seconds) 
// MAGIC   
// MAGIC [![Udacity: Deep Learning by Vincent Vanhoucke - Neural network](http://img.youtube.com/vi/Opg63pan_YQ/0.jpg)](https://www.youtube.com/v/Opg63pan_YQ?rel=0&autoplay=1&modestbranding=1&start=0&end=45)
// MAGIC ***
// MAGIC -- Video Credit: Udacity's deep learning by Arpan Chakraborthy and Vincent Vanhoucke

// COMMAND ----------

// MAGIC %md
// MAGIC Is decision tree a linear model?  
// MAGIC [http://datascience.stackexchange.com/questions/6787/is-decision-tree-algorithm-a-linear-or-nonlinear-algorithm](http://datascience.stackexchange.com/questions/6787/is-decision-tree-algorithm-a-linear-or-nonlinear-algorithm)  

// COMMAND ----------

// MAGIC %md
// MAGIC ***
// MAGIC **Neural Network**
// MAGIC *** 
// MAGIC ![Neural network](https://upload.wikimedia.org/wikipedia/commons/thumb/4/46/Colored_neural_network.svg/500px-Colored_neural_network.svg.png)
// MAGIC ***
// MAGIC -- Image credit: Wikipedia

// COMMAND ----------

// MAGIC %md
// MAGIC **Multiple hidden layers**
// MAGIC   
// MAGIC ![Many hidden layers](http://neuralnetworksanddeeplearning.com/images/tikz36.png)
// MAGIC ***
// MAGIC -- Image credit: Michael Nielsen

// COMMAND ----------

// MAGIC %md
// MAGIC ***
// MAGIC *** 
// MAGIC 
// MAGIC **What does it mean to go deep? What do each of the hidden layers learn?**
// MAGIC  
// MAGIC Watch now (1:13 seconds) 
// MAGIC   
// MAGIC [![Udacity: Deep Learning by Vincent Vanhoucke - Neural network](http://img.youtube.com/vi/_TcMRoWFppo/0.jpg)](https://www.youtube.com/v/_TcMRoWFppo?rel=0&autoplay=1&modestbranding=1&start=0)
// MAGIC ***
// MAGIC -- Video Credit: Udacity's deep learning by Arpan Chakraborthy and Vincent Vanhoucke

// COMMAND ----------

// MAGIC %md
// MAGIC ### Chain rule
// MAGIC (f o g)' = (f' o g) . g'
// MAGIC 
// MAGIC ***
// MAGIC *** 
// MAGIC 
// MAGIC **Chain rule in neural networks**
// MAGIC  
// MAGIC Watch later (55 seconds) 
// MAGIC   
// MAGIC [![Udacity: Deep Learning by Vincent Vanhoucke - Neural network](http://img.youtube.com/vi/fDeAJspBEnM/0.jpg)](https://www.youtube.com/v/fDeAJspBEnM?rel=0&autoplay=1&modestbranding=1&start=0)
// MAGIC ***
// MAGIC -- Video Credit: Udacity's deep learning by Arpan Chakraborthy and Vincent Vanhoucke

// COMMAND ----------

// MAGIC %md
// MAGIC ### Backpropogation
// MAGIC 
// MAGIC ***
// MAGIC  
// MAGIC Watch later (9:55 seconds) 
// MAGIC   
// MAGIC [![Backpropogation](http://img.youtube.com/vi/mgceQli6ZKQ/0.jpg)](https://www.youtube.com/v/mgceQli6ZKQ?rel=0&autoplay=1&modestbranding=1&start=0)
// MAGIC ***
// MAGIC ***
// MAGIC   
// MAGIC Watch now (1: 54 seconds)  
// MAGIC [![Backpropogation](http://img.youtube.com/vi/83bMCcPmFvE/0.jpg)](https://www.youtube.com/v/83bMCcPmFvE?rel=0&autoplay=1&modestbranding=1&start=0)
// MAGIC ***

// COMMAND ----------

// MAGIC %md
// MAGIC ####How do you set the learning rate? - Step size in SGD?  
// MAGIC * [ADADELTA: Adaptive learning rate](http://arxiv.org/pdf/1212.5701v1.pdf)
// MAGIC * [ADAGRAD](http://www.jmlr.org/papers/volume12/duchi11a/duchi11a.pdf)

// COMMAND ----------

// MAGIC %md
// MAGIC #### Convolutional Neural Networks
// MAGIC <img src="http://colah.github.io/posts/2014-07-Conv-Nets-Modular/img/Conv2-9x5-Conv2Conv2.png" width=800>  
// MAGIC ***
// MAGIC Watch (3:55)  
// MAGIC [![Udacity: Deep Learning by Vincent Vanhoucke - Convolutional Neural network](http://img.youtube.com/vi/jajksuQW4mc/0.jpg)](https://www.youtube.com/v/jajksuQW4mc?rel=0&autoplay=1&modestbranding=1&start=0)  
// MAGIC ***
// MAGIC * Alex Krizhevsky,  Ilya Sutskever, Geoffrey E. Hinton - [https://papers.nips.cc/paper/4824-imagenet-classification-with-deep-convolutional-neural-networks.pdf](https://papers.nips.cc/paper/4824-imagenet-classification-with-deep-convolutional-neural-networks.pdf)  
// MAGIC * Convolutional Neural networks blog - [http://colah.github.io/posts/2014-07-Conv-Nets-Modular/](http://colah.github.io/posts/2014-07-Conv-Nets-Modular/)

// COMMAND ----------

// MAGIC %md
// MAGIC #### Recurrent neural network
// MAGIC ![Recurrent neural network](http://colah.github.io/posts/2015-08-Understanding-LSTMs/img/RNN-unrolled.png)  
// MAGIC [http://colah.github.io/posts/2015-08-Understanding-LSTMs/](http://colah.github.io/posts/2015-08-Understanding-LSTMs/)  
// MAGIC 
// MAGIC 
// MAGIC [http://karpathy.github.io/2015/05/21/rnn-effectiveness/](http://karpathy.github.io/2015/05/21/rnn-effectiveness/)  
// MAGIC ***
// MAGIC Watch (3:55)  
// MAGIC [![Udacity: Deep Learning by Vincent Vanhoucke - Recurrent Neural network](http://img.youtube.com/vi/H3ciJF2eCJI/0.jpg)](https://www.youtube.com/v/H3ciJF2eCJI?rel=0&autoplay=1&modestbranding=1&start=0)  
// MAGIC ***
// MAGIC ##### LSTM - Long short term memory
// MAGIC ![LSTM](http://colah.github.io/posts/2015-08-Understanding-LSTMs/img/LSTM3-chain.png)
// MAGIC 
// MAGIC ***
// MAGIC ##### GRU - Gated recurrent unit
// MAGIC ![Gated Recurrent unit](http://colah.github.io/posts/2015-08-Understanding-LSTMs/img/LSTM3-var-GRU.png)
// MAGIC [http://arxiv.org/pdf/1406.1078v3.pdf](http://arxiv.org/pdf/1406.1078v3.pdf)  

// COMMAND ----------

// MAGIC %md
// MAGIC ### Autoencoder
// MAGIC ![Autoencoder](http://deeplearning4j.org/img/deep_autoencoder.png)
// MAGIC ***
// MAGIC Watch (3:51)  
// MAGIC [![Autoencoder](http://img.youtube.com/vi/s96mYcicbpE/0.jpg)](https://www.youtube.com/v/s96mYcicbpE?rel=0&autoplay=1&modestbranding=1&start=0)  
// MAGIC ***

// COMMAND ----------

// MAGIC %md
// MAGIC 
// MAGIC # [Scalable Data Science](http://www.math.canterbury.ac.nz/~r.sainudiin/courses/ScalableDataScience/)
// MAGIC 
// MAGIC 
// MAGIC ### prepared by [Raazesh Sainudiin](https://nz.linkedin.com/in/raazesh-sainudiin-45955845) and [Sivanand Sivaram](https://www.linkedin.com/in/sivanand)
// MAGIC 
// MAGIC *supported by* [![](https://raw.githubusercontent.com/raazesh-sainudiin/scalable-data-science/master/images/databricks_logoTM_200px.png)](https://databricks.com/)
// MAGIC and 
// MAGIC [![](https://raw.githubusercontent.com/raazesh-sainudiin/scalable-data-science/master/images/AWS_logoTM_200px.png)](https://www.awseducate.com/microsite/CommunitiesEngageHome)