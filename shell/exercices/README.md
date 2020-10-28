## SPARK SHELLs introduction

The Spark consoles are two command line interfaces that are provided natively by Spark Core  
One is provided in scala (native spark)-spark-shell, the other is provided in Python (out-of-the-box) -pyspark. 
Although they may not be convenient for day to day in depth work, they do provide a robust interface for testing and exucuting spark commands in REPL mode.  

We will first play around with the scala version, and from then on we will switch to python for the rest of the training.  
There are many considerations as to when it is more convenient to use one language API over the other.  
If you are interested in this topic, feel free to ask the trainer, he'll be gland to provide you with some insights

### Caution !!!
As will be explained later, do NOT launch more than ONE shell per user. 
Always quit your sessions properly (:q in scalla or exit() in pyspark).
Being careless regarding this warning will result in freezing your shells,  
and needing to restart services and killing ghost jobs
