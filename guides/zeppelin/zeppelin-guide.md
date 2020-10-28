### Downloading Notebook Exercices & Importing into Zeppelin

A list of notebook exercices will be provided [here]

You will need to 
 - download it using wget in the Zeppelin Folder 
 - Reload Notebooks in Zeppelin


Example Code : 

```
wget s3://provided-bucket-name/noteboooks/* -P /mnt/var/lib/zeppelin/notebook
```

Reload the list of Notebooks from Zeppelin :

<img src="/res/img/zeppelin-reload-notes.png" width="400">

The newly uploaded notebook will be available

### Downloading Solutions & Importing into Zeppelin

Solutions to Exercices will be pushed to the repo by the trainer after each workshop in the following [folder](/notebooks/solutions)
Copy the link to the newly added notebook, and download it into the zeppelin notebook directory in your cluster

Example Code : 

```
wget https://github.com/mehdi-lamrani/spark-workshop/blob/main/notebooks/exercices/TP_SPARK_SQL.zpl -P /mnt/var/lib/zeppelin/notebook
```

Reload the list of Notebooks from Zeppelin in the same way described above
