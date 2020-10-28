val df = spark.readStream.format("socket").option("host", "127.0.0.1").option("port", YOUR_PORT_NUMBER_HERE).option("includeTimestamp","true").load()
val dfc = df.groupBy(window($"timestamp", "10 second")).count()
dfc.writeStream.format("console").option("checkpointLocation", "/user/root/data/check").outputMode("Complete").start()
