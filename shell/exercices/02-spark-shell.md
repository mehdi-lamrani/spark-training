## SPARK-SHELL Workshop

- Prereqs : <br>
  * You ssh'd into your master instance<br>
  * You dowloaded data<br>
  * Uploaded it to hdfs<br>
  * you are logged in as root (sudo)<br>

```
cd
spark-shell
```
![spark-shell](/res/img/spark-shell.png)

````
println('hello scala')
````
- Let's create an RDD from scratch and display its content :

````
val dataSeq = Seq(("Java", 20000), ("Python", 100000), ("Scala", 3000))
val rdd=spark.sparkContext.parallelize(dataSeq)
rdd.collect().foreach(println)
````

  * What did you notice ?
  * Which instructon took most time ?
  * Why in you opinion ?

- Let's play a bit with our rdd

````
rdd.take(2)
rdd.first()
rdd.count()
````

- Let's create a second rdd, and join both into a 3rd rdd 

````
val rdd2=spark.sparkContext.parallelize(dataSeq)
val rdd3 = rdd.join(rdd2)
rdd3.collect().foreach(println)
````
  * What do you notice in the output ?
  * what kind of join was done by default ?
  * Any considerations ?

- Try the following command : 
````  
  rdd3.toDebugString
````
  
  * What do you think about the output ?
  * What are your guesses ?

- Now let's create a dataframe from a CSV file and display its content 

````
val df = spark.read.format("csv").load("hdfs:///user/root/myname/data/zipcodes.csv")
df.show()
````

  * What did you notice ?
  * Which instructon took most time ?
  * Why in you opinion ?

- Gracefully shut down your spark-shell : type :q enter

### Caution !!!
As will be explained later, do NOT launch more than ONE shell per user. 
Always quit your sessions properly (:q in scalla or exit() in pyspark).
Being careless regarding this warning will result in freezing your shells,  
and needing to restart services and killing ghost jobs
