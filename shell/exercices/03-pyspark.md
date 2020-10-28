## SPARK-SHELL Workshop

- Prereqs : <br>
  * You ssh'd into your master instance<br>
  * You dowloaded data<br>
  * Uploaded it to hdfs<br>
  * you are logged in as root (sudo)<br>

```
cd
pyspark
```



````
print('hello pyspark')
````

You can repeat some of the previous steps performed in scala.   
In this case, simply removing val will suffice, as we did not push the scala syntax very far.

````
df = spark.read.format("csv").load("hdfs:///user/root/myname/data/zipcodes.csv")
df.show()
````
