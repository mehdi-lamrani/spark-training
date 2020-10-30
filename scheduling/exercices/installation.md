## Installing & Running Airflow

- Login as root  
  <sup>(never do this in front of your kids)</sup>

```
sudo su
cd
```

- Prereqs and pip install
```
yum install gcc-c++ python3-devel python-setuptools
pip install  apache-airflow==1.10.12  --constraint "https://raw.githubusercontent.com/apache/airflow/constraints-1.10.12/constraints-3.7.txt"
```

```
PATH=$PATH:/usr/local/bin
airflow initdb
```

```
cd ~/airflow
vi airflow.cfg
```
- Change line 136 to :

```
load_examples = False
```

- Reset the airflow db

```
airflow resetdb
```

- Install Spark dependencies

```
pip install 'apache-airflow[apache.spark]'
pip install apache-airflow-backport-providers-apache-spark
```

- Load your Spark Flow

```
cd ~/airflow
mkdir dags
cd dags
vi spark-flow.py
```
- copy the code in the [spark-flow.py](spark-flow.py) file 

- launch the airflow scheduler

```
airflow scheduler
```

- In another terminal : 
  Launch the Airflow UI

```  
PATH=$PATH:/usr/local/bin
airflow webserver -p 8080
```

- Update the Spark Connector Yarn Queue : 

Go to Admin Menu > Connections, select spark default and edit it :  
Change Extra {"queue": "root.default"} to {"queue": "default"} in the Airflow WebServer UI.  

(https://stackoverflow.com/questions/60329007/how-to-set-the-yarn-queue-when-submitting-a-spark-application-from-the-airflow-s)

Explanation :  
The default Queue in YARN is called "default".   
By default, Airflow Spark Connector puts "user.default" which does not match the existing default queue.  


You're all set ! 
You can proceed to http://YOUR.MAS.TER.IP:8080

For the next steps, refer to the steps below :)

- How to confirm it works ?  
  When you hit the final log step, in the logs you should see the output of the spark job, Namely the computed value of Pi

- When done with a basic SparkSubmitOperator, if you have time : 

Try using other spark operator as well (SQL, JDBC) :
https://airflow.readthedocs.io/en/latest/howto/operator/apache/spark.html


  
![o](/res/img/airflow-on.png)  


![o](/res/img/airflow-dag.png)  


![o](/res/img/airflow-trigger.png)   


![o](/res/img/airflow-trigger-confirm.png)  


![o](/res/img/airflow-graph.png)  


![o](/res/img/airflow-task-instance.png)  


![o](/res/img/airflow-task.png)  


![o](/res/img/airflow-log.png)  
