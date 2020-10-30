# Build & Deploy a Spark Program

```
sudo su
cd
```


```
Load the Data (again)

[zipcodes.csv](https://github.com/sylace-hub/spark-m-training/blob/master/shell/exercices/01.load-data.md)

```
curl https://bintray.com/sbt/rpm/rpm | sudo tee /etc/yum.repos.d/bintray-sbt-rpm.repo
sudo yum install sbt -y
```

- create a project folder /root/myname/scala-project
- cd to it
- copy the spark program in it 
- copy the build.sbt file 


- from the project folder : 

```
sbt package 
```

- locate the produced jar file using `tree`
- submit the jar file

```
spark-submit --class classnamehere /chemin/complet/thenameofmyjar.jar
```

- Check that your program ran as expected and produced the desired results

