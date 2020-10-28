### KAFKA+SPARK EXAMPLE APPLICATION

<img width="1122" alt="Alpha Vantage" src="https://user-images.githubusercontent.com/28993140/83018913-5dbb9f80-a026-11ea-97c0-a81b5575f4e9.png">

### PREREQUISITES : 

Récupérer une clé API : 

https://www.alphavantage.co/support/#api-key

### DIRECTIVES : 

- Bien penser à envoyer TOUT le message OHLC cette fois
- Utiliser pour ce faire le serializer Avro Adapté

[SERIALIZE YOUR KAFKA MESSAGE WITH AVRO](https://docs.confluent.io/current/schema-registry/serdes-develop/serdes-avro.html)

- Ajouter la dépendance suivante dans maven : 
````
<dependency>
    <groupId>io.confluent</groupId>
    <artifactId>kafka-avro-serializer</artifactId>
    <version>5.3.0</version>
</dependency>

<dependency>
    <groupId>org.apache.avro</groupId>
    <artifactId>avro</artifactId>
    <version>1.9.2</version>
</dependency>

<dependency>
    <groupId>io.confluent</groupId>
    <artifactId>common-config</artifactId>
    <version>5.2.2</version>
</dependency>
````

Et celle-ci plus haut (en dessous de  `<include>commons-beanutils:commons-beanutils</include>`)
````
 <include>org.apache.avro:avro</include>
 <include>io.confluent:kafka-avro-serializer</include>
 ````
 
 ### AVRO JAR
 
```
wget http://packages.confluent.io/maven/io/confluent/kafka-avro-serializer/5.5.0/kafka-avro-serializer-5.5.0.jar
```
 
 ### SPARK
 
- Lire via Spark les TOPICS créés depuis Kafka, dans des Dataframes 

- Convertir Depuis Avro dans Le Dataframe

[DESERIALIZE IN SPARK FROM AVRO](https://spark.apache.org/docs/latest/sql-data-sources-avro.html#to_avro-and-from_avro)

- Créer les tables temporaires de Stock associés (exemple de syntaxe ci-dessous)

````
# Register the DataFrame as a SQL temporary view
df.createOrReplaceTempView("people")

sqlDF = spark.sql("SELECT * FROM people")
sqlDF.show()
# +----+-------+
# | age|   name|
# +----+-------+
# |null|Michael|
# |  30|   Andy|
# |  19| Justin|
# +----+-------+
````

[CREATE A DATATABLE FROM A DATAFRAME (Python)](https://spark.apache.org/docs/2.4.5/sql-getting-started.html#running-sql-queries-programmatically)


### DATA ANALYSE

- Pour chaque Table, trouver le DAILY MAX, le DAILY MIN, L'AVERAGE, et le TOTAL VOLUME 
- [SPARK SQL REFERENCE API FUNCTIONS](https://spark.apache.org/docs/latest/api/sql)
- Stocker ces resultats dans un Dataframe commun, puis dans une Data TABLE finale : 



```
DAILY TABLE
# +-------+-------+-------+-------+---------------+
# | value |   open|   open|   avg |  total_volume |
# +-------+-------+-------+-------+---------------+
# | MSFT  |       |       |       |               |
# | AAPL  |       |       |       |               |
# |  FB   |       |       |       |               |
# +-------+-------+-------+-------+---------------+
```


