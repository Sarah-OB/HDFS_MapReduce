# TP 4 : Big data Frameworks II (MAPREDUCE2)
### OYONO BISSO Emmanuelle-Sarah & COULIBALY Massarata

# I. MapReduce JAVA

### 1.6 Send the JAR to the edge
#### 1.6.2 Mac OS X

```sh
(base) MacBook-Air-de-Sarah:target sarah$ scp hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar eoyono@hadoop-edge01.efrei.online:/home/eoyono
Welcome to EFREI Hadoop Cluster

Password: 
hadoop-examples-mapreduce-1.0- 100%   51MB   6.8MB/s   00:07
```

#### 1.6.3 Run the job

```sh
[eoyono@hadoop-edge01 ~]$ yarn jar hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar \wordcount /user/eoyono/gutenberg/ulysses.txt /user/eoyono/wordcount_ulysses
```

```sh
20/10/28 09:29:48 INFO client.AHSProxy: Connecting to Application History server at hadoop-master03.efrei.online/163.172.100.24:10200
20/10/28 09:29:48 INFO hdfs.DFSClient: Created token for eoyono: HDFS_DELEGATION_TOKEN owner=eoyono@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1603873788435, maxDate=1604478588435, sequenceNumber=2350, masterKeyId=32 on ha-hdfs:efrei
20/10/28 09:29:48 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for eoyono: HDFS_DELEGATION_TOKEN owner=eoyono@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1603873788435, maxDate=1604478588435, sequenceNumber=2350, masterKeyId=32)
20/10/28 09:29:48 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /user/eoyono/.staging/job_1603290159664_0428
20/10/28 09:29:49 INFO input.FileInputFormat: Total input files to process : 1
20/10/28 09:29:49 INFO mapreduce.JobSubmitter: number of splits:1
20/10/28 09:29:49 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1603290159664_0428
20/10/28 09:29:49 INFO mapreduce.JobSubmitter: Executing with tokens: [Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for eoyono: HDFS_DELEGATION_TOKEN owner=eoyono@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1603873788435, maxDate=1604478588435, sequenceNumber=2350, masterKeyId=32)]
20/10/28 09:29:49 INFO conf.Configuration: found resource resource-types.xml at file:/etc/hadoop/3.1.5.0-152/0/resource-types.xml
20/10/28 09:29:49 INFO impl.TimelineClientImpl: Timeline service address: hadoop-master03.efrei.online:8190
20/10/28 09:29:50 INFO impl.YarnClientImpl: Submitted application application_1603290159664_0428
20/10/28 09:29:50 INFO mapreduce.Job: The url to track the job: https://hadoop-master01.efrei.online:8090/proxy/application_1603290159664_0428/
20/10/28 09:29:50 INFO mapreduce.Job: Running job: job_1603290159664_0428
20/10/28 09:30:00 INFO mapreduce.Job: Job job_1603290159664_0428 running in uber mode : false
20/10/28 09:30:00 INFO mapreduce.Job:  map 0% reduce 0%
20/10/28 09:30:10 INFO mapreduce.Job:  map 100% reduce 0%
20/10/28 09:30:15 INFO mapreduce.Job:  map 100% reduce 100%
20/10/28 09:30:15 INFO mapreduce.Job: Job job_1603290159664_0428 completed successfully
20/10/28 09:30:15 INFO mapreduce.Job: Counters: 53
        File System Counters
                FILE: Number of bytes read=727563
                FILE: Number of bytes written=1948289
                FILE: Number of read operations=0
                FILE: Number of large read operations=0
                FILE: Number of write operations=0
                HDFS: Number of bytes read=1586599
                HDFS: Number of bytes written=530683
                HDFS: Number of read operations=8
                HDFS: Number of large read operations=0
                HDFS: Number of write operations=2
        Job Counters 
                Launched map tasks=1
                Launched reduce tasks=1
                Data-local map tasks=1
                Total time spent by all maps in occupied slots (ms)=22671
                Total time spent by all reduces in occupied slots (ms)=12436
                Total time spent by all map tasks (ms)=7557
                Total time spent by all reduce tasks (ms)=3109
                Total vcore-milliseconds taken by all map tasks=7557
                Total vcore-milliseconds taken by all reduce tasks=3109
                Total megabyte-milliseconds taken by all map tasks=11607552
                Total megabyte-milliseconds taken by all reduce tasks=6367232
        Map-Reduce Framework
                Map input records=33230
                Map output records=268131
                Map output bytes=2615311
                Map output materialized bytes=727563
                Input split bytes=111
                Combine input records=268131
                Combine output records=49937
                Reduce input groups=49937
                Reduce shuffle bytes=727563
                Reduce input records=49937
                Reduce output records=49937
                Spilled Records=99874
                Shuffled Maps =1
                Failed Shuffles=0
                Merged Map outputs=1
                GC time elapsed (ms)=223
                CPU time spent (ms)=8250
                Physical memory (bytes) snapshot=1491591168
                Virtual memory (bytes) snapshot=7280795648
                Total committed heap usage (bytes)=1569193984
                Peak Map Physical memory (bytes)=1175351296
                Peak Map Virtual memory (bytes)=3397214208
                Peak Reduce Physical memory (bytes)=316239872
                Peak Reduce Virtual memory (bytes)=3883581440
        Shuffle Errors
                BAD_ID=0
                CONNECTION=0
                IO_ERROR=0
                WRONG_LENGTH=0
                WRONG_MAP=0
                WRONG_REDUCE=0
        File Input Format Counters 
                Bytes Read=1586488
        File Output Format Counters 
                Bytes Written=530683
```

## 1.8 Remarkable trees of Paris

### Send my jar file to Hadoop

```sh
(base) MacBook-Air-de-Sarah:data sarah$ scp trees.csv eoyono@hadoop-edge01.efrei.online:/home/eoyono
Welcome to EFREI Hadoop Cluster

Password: 
trees.csv                    100%   16KB 480.9KB/s   00:00

[eoyono@hadoop-edge01 ~]$ hdfs dfs -put trees.csv /user/eoyono
```

```sh
(base) MacBook-Air-de-Sarah:target sarah$ scp hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar  eoyono@hadoop-edge01.efrei.online:/home/eoyono/    
Welcome to EFREI Hadoop Cluster

Password: 
hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar                          100%   51MB   3.4MB/s   00:15
```

#### 1.8.1 : Districts containing trees

```sh
[eoyono@hadoop-edge01 ~]$ yarn jar hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar \districtqTrees  /user/eoyono/trees.csv /user/eoyono/districtTrees
```

```sh
20/11/07 19:31:18 INFO client.AHSProxy: Connecting to Application History server at hadoop-master03.efrei.online/163.172.100.24:10200
20/11/07 19:31:18 INFO hdfs.DFSClient: Created token for eoyono: HDFS_DELEGATION_TOKEN owner=eoyono@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1604773878757, maxDate=1605378678757, sequenceNumber=4787, masterKeyId=43 on ha-hdfs:efrei
20/11/07 19:31:18 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for eoyono: HDFS_DELEGATION_TOKEN owner=eoyono@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1604773878757, maxDate=1605378678757, sequenceNumber=4787, masterKeyId=43)
20/11/07 19:31:18 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /user/eoyono/.staging/job_1603290159664_2591
20/11/07 19:31:19 INFO input.FileInputFormat: Total input files to process : 1
20/11/07 19:31:19 INFO mapreduce.JobSubmitter: number of splits:1
20/11/07 19:31:19 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1603290159664_2591
20/11/07 19:31:19 INFO mapreduce.JobSubmitter: Executing with tokens: [Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for eoyono: HDFS_DELEGATION_TOKEN owner=eoyono@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1604773878757, maxDate=1605378678757, sequenceNumber=4787, masterKeyId=43)]
20/11/07 19:31:20 INFO conf.Configuration: found resource resource-types.xml at file:/etc/hadoop/3.1.5.0-152/0/resource-types.xml
20/11/07 19:31:20 INFO impl.TimelineClientImpl: Timeline service address: hadoop-master03.efrei.online:8190
20/11/07 19:31:20 INFO impl.YarnClientImpl: Submitted application application_1603290159664_2591
20/11/07 19:31:20 INFO mapreduce.Job: The url to track the job: https://hadoop-master01.efrei.online:8090/proxy/application_1603290159664_2591/
20/11/07 19:31:20 INFO mapreduce.Job: Running job: job_1603290159664_2591
20/11/07 19:31:30 INFO mapreduce.Job: Job job_1603290159664_2591 running in uber mode : false
20/11/07 19:31:30 INFO mapreduce.Job:  map 0% reduce 0%
20/11/07 19:31:41 INFO mapreduce.Job:  map 100% reduce 0%
20/11/07 19:31:46 INFO mapreduce.Job:  map 100% reduce 100%
20/11/07 19:31:47 INFO mapreduce.Job: Job job_1603290159664_2591 completed successfully
20/11/07 19:31:47 INFO mapreduce.Job: Counters: 53
        File System Counters
                FILE: Number of bytes read=84
                FILE: Number of bytes written=493299
                FILE: Number of read operations=0
                FILE: Number of large read operations=0
                FILE: Number of write operations=0
                HDFS: Number of bytes read=16779
                HDFS: Number of bytes written=44
                HDFS: Number of read operations=8
                HDFS: Number of large read operations=0
                HDFS: Number of write operations=2
        Job Counters 
                Launched map tasks=1
                Launched reduce tasks=1
                Data-local map tasks=1
                Total time spent by all maps in occupied slots (ms)=22551
                Total time spent by all reduces in occupied slots (ms)=12832
                Total time spent by all map tasks (ms)=7517
                Total time spent by all reduce tasks (ms)=3208
                Total vcore-milliseconds taken by all map tasks=7517
                Total vcore-milliseconds taken by all reduce tasks=3208
                Total megabyte-milliseconds taken by all map tasks=11546112
                Total megabyte-milliseconds taken by all reduce tasks=6569984
        Map-Reduce Framework
                Map input records=98
                Map output records=97
                Map output bytes=277
                Map output materialized bytes=84
                Input split bytes=99
                Combine input records=97
                Combine output records=17
                Reduce input groups=17
                Reduce shuffle bytes=84
                Reduce input records=17
                Reduce output records=17
                Spilled Records=34
                Shuffled Maps =1
                Failed Shuffles=0
                Merged Map outputs=1
                GC time elapsed (ms)=174
                CPU time spent (ms)=3460
                Physical memory (bytes) snapshot=1451769856
                Virtual memory (bytes) snapshot=7267131392
                Total committed heap usage (bytes)=1559232512
                Peak Map Physical memory (bytes)=1156169728
                Peak Map Virtual memory (bytes)=3394072576
                Peak Reduce Physical memory (bytes)=295600128
                Peak Reduce Virtual memory (bytes)=3873058816
        Shuffle Errors
                BAD_ID=0
                CONNECTION=0
                IO_ERROR=0
                WRONG_LENGTH=0
                WRONG_MAP=0
                WRONG_REDUCE=0
        File Input Format Counters 
                Bytes Read=16680
        File Output Format Counters 
                Bytes Written=44
```

##### Resultat :

```sh
[eoyono@hadoop-edge01 ~]$ hdfs dfs -cat /user/eoyono/districtTrees/part-r-00000
11
12
13
14
15
16
17
18
19
20
3
4
5
6
7
8
9
```

#### 1.8.2 : Show all existing species

```sh
[eoyono@hadoop-edge01 ~]$ yarn jar hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar \existingSpecies /user/eoyono/trees.csv /user/eoyono/existingSpecies
```

```sh
20/11/07 19:58:06 INFO client.AHSProxy: Connecting to Application History server at hadoop-master03.efrei.online/163.172.100.24:10200
20/11/07 19:58:06 INFO hdfs.DFSClient: Created token for eoyono: HDFS_DELEGATION_TOKEN owner=eoyono@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1604775486876, maxDate=1605380286876, sequenceNumber=4793, masterKeyId=43 on ha-hdfs:efrei
20/11/07 19:58:06 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for eoyono: HDFS_DELEGATION_TOKEN owner=eoyono@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1604775486876, maxDate=1605380286876, sequenceNumber=4793, masterKeyId=43)
20/11/07 19:58:07 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /user/eoyono/.staging/job_1603290159664_2597
20/11/07 19:58:07 INFO input.FileInputFormat: Total input files to process : 1
20/11/07 19:58:08 INFO mapreduce.JobSubmitter: number of splits:1
20/11/07 19:58:08 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1603290159664_2597
20/11/07 19:58:08 INFO mapreduce.JobSubmitter: Executing with tokens: [Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for eoyono: HDFS_DELEGATION_TOKEN owner=eoyono@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1604775486876, maxDate=1605380286876, sequenceNumber=4793, masterKeyId=43)]
20/11/07 19:58:08 INFO conf.Configuration: found resource resource-types.xml at file:/etc/hadoop/3.1.5.0-152/0/resource-types.xml
20/11/07 19:58:08 INFO impl.TimelineClientImpl: Timeline service address: hadoop-master03.efrei.online:8190
20/11/07 19:58:08 INFO impl.YarnClientImpl: Submitted application application_1603290159664_2597
20/11/07 19:58:08 INFO mapreduce.Job: The url to track the job: https://hadoop-master01.efrei.online:8090/proxy/application_1603290159664_2597/
20/11/07 19:58:08 INFO mapreduce.Job: Running job: job_1603290159664_2597
20/11/07 19:58:19 INFO mapreduce.Job: Job job_1603290159664_2597 running in uber mode : false
20/11/07 19:58:19 INFO mapreduce.Job:  map 0% reduce 0%
20/11/07 19:58:28 INFO mapreduce.Job:  map 100% reduce 0%
20/11/07 19:58:37 INFO mapreduce.Job:  map 100% reduce 100%
20/11/07 19:58:38 INFO mapreduce.Job: Job job_1603290159664_2597 completed successfully
20/11/07 19:58:38 INFO mapreduce.Job: Counters: 53
        File System Counters
                FILE: Number of bytes read=547
                FILE: Number of bytes written=494227
                FILE: Number of read operations=0
                FILE: Number of large read operations=0
                FILE: Number of write operations=0
                HDFS: Number of bytes read=16779
                HDFS: Number of bytes written=451
                HDFS: Number of read operations=8
                HDFS: Number of large read operations=0
                HDFS: Number of write operations=2
        Job Counters 
                Launched map tasks=1
                Launched reduce tasks=1
                Data-local map tasks=1
                Total time spent by all maps in occupied slots (ms)=20694
                Total time spent by all reduces in occupied slots (ms)=25736
                Total time spent by all map tasks (ms)=6898
                Total time spent by all reduce tasks (ms)=6434
                Total vcore-milliseconds taken by all map tasks=6898
                Total vcore-milliseconds taken by all reduce tasks=6434
                Total megabyte-milliseconds taken by all map tasks=10595328
                Total megabyte-milliseconds taken by all reduce tasks=13176832
        Map-Reduce Framework
                Map input records=98
                Map output records=97
                Map output bytes=995
                Map output materialized bytes=547
                Input split bytes=99
                Combine input records=97
                Combine output records=45
                Reduce input groups=45
                Reduce shuffle bytes=547
                Reduce input records=45
                Reduce output records=45
                Spilled Records=90
                Shuffled Maps =1
                Failed Shuffles=0
                Merged Map outputs=1
                GC time elapsed (ms)=204
                CPU time spent (ms)=3040
                Physical memory (bytes) snapshot=1459290112
                Virtual memory (bytes) snapshot=7268409344
                Total committed heap usage (bytes)=1553989632
                Peak Map Physical memory (bytes)=1159639040
                Peak Map Virtual memory (bytes)=3391909888
                Peak Reduce Physical memory (bytes)=299651072
                Peak Reduce Virtual memory (bytes)=3876499456
        Shuffle Errors
                BAD_ID=0
                CONNECTION=0
                IO_ERROR=0
                WRONG_LENGTH=0
                WRONG_MAP=0
                WRONG_REDUCE=0
        File Input Format Counters 
                Bytes Read=16680
        File Output Format Counters 
                Bytes Written=451
```

##### Resultat :

```sh
[eoyono@hadoop-edge01 ~]$ hdfs dfs -cat /user/eoyono/existingSpecies/part-r-00000
Acer
Aesculus
Ailanthus
Alnus
Araucaria
Broussonetia
Calocedrus
Catalpa
Cedrus
Celtis
Corylus
Davidia
Diospyros
Eucommia
Fagus
Fraxinus
Ginkgo
Gymnocladus
Juglans
Liriodendron
Maclura
Magnolia
Paulownia
Pinus
Platanus
Pterocarya
Quercus
Robinia
Sequoia
Sequoiadendron
Styphnolobium
Taxodium
Taxus
Tilia
Ulmus
Zelkova
```

#### 1.8.3 : Number of trees by species

```sh
[eoyono@hadoop-edge01 ~]$ yarn jar hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar \treesBySpecies  /user/eoyono/trees.csv /user/eoyono/treesBySpecies
```

```sh
20/11/07 19:38:40 INFO client.AHSProxy: Connecting to Application History server at hadoop-master03.efrei.online/163.172.100.24:10200
20/11/07 19:38:40 INFO hdfs.DFSClient: Created token for eoyono: HDFS_DELEGATION_TOKEN owner=eoyono@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1604774320356, maxDate=1605379120356, sequenceNumber=4789, masterKeyId=43 on ha-hdfs:efrei
20/11/07 19:38:40 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for eoyono: HDFS_DELEGATION_TOKEN owner=eoyono@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1604774320356, maxDate=1605379120356, sequenceNumber=4789, masterKeyId=43)
20/11/07 19:38:40 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /user/eoyono/.staging/job_1603290159664_2593
20/11/07 19:38:41 INFO input.FileInputFormat: Total input files to process : 1
20/11/07 19:38:41 INFO mapreduce.JobSubmitter: number of splits:1
20/11/07 19:38:41 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1603290159664_2593
20/11/07 19:38:41 INFO mapreduce.JobSubmitter: Executing with tokens: [Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for eoyono: HDFS_DELEGATION_TOKEN owner=eoyono@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1604774320356, maxDate=1605379120356, sequenceNumber=4789, masterKeyId=43)]
20/11/07 19:38:41 INFO conf.Configuration: found resource resource-types.xml at file:/etc/hadoop/3.1.5.0-152/0/resource-types.xml
20/11/07 19:38:41 INFO impl.TimelineClientImpl: Timeline service address: hadoop-master03.efrei.online:8190
20/11/07 19:38:42 INFO impl.YarnClientImpl: Submitted application application_1603290159664_2593
20/11/07 19:38:42 INFO mapreduce.Job: The url to track the job: https://hadoop-master01.efrei.online:8090/proxy/application_1603290159664_2593/
20/11/07 19:38:42 INFO mapreduce.Job: Running job: job_1603290159664_2593
20/11/07 19:38:52 INFO mapreduce.Job: Job job_1603290159664_2593 running in uber mode : false
20/11/07 19:38:52 INFO mapreduce.Job:  map 0% reduce 0%
20/11/07 19:39:01 INFO mapreduce.Job:  map 100% reduce 0%
20/11/07 19:39:10 INFO mapreduce.Job:  map 100% reduce 100%
20/11/07 19:39:10 INFO mapreduce.Job: Job job_1603290159664_2593 completed successfully
20/11/07 19:39:10 INFO mapreduce.Job: Counters: 53
        File System Counters
                FILE: Number of bytes read=727
                FILE: Number of bytes written=494585
                FILE: Number of read operations=0
                FILE: Number of large read operations=0
                FILE: Number of write operations=0
                HDFS: Number of bytes read=16779
                HDFS: Number of bytes written=542
                HDFS: Number of read operations=8
                HDFS: Number of large read operations=0
                HDFS: Number of write operations=2
        Job Counters 
                Launched map tasks=1
                Launched reduce tasks=1
                Data-local map tasks=1
                Total time spent by all maps in occupied slots (ms)=20052
                Total time spent by all reduces in occupied slots (ms)=28172
                Total time spent by all map tasks (ms)=6684
                Total time spent by all reduce tasks (ms)=7043
                Total vcore-milliseconds taken by all map tasks=6684
                Total vcore-milliseconds taken by all reduce tasks=7043
                Total megabyte-milliseconds taken by all map tasks=10266624
                Total megabyte-milliseconds taken by all reduce tasks=14424064
        Map-Reduce Framework
                Map input records=98
                Map output records=97
                Map output bytes=1383
                Map output materialized bytes=727
                Input split bytes=99
                Combine input records=97
                Combine output records=45
                Reduce input groups=45
                Reduce shuffle bytes=727
                Reduce input records=45
                Reduce output records=45
                Spilled Records=90
                Shuffled Maps =1
                Failed Shuffles=0
                Merged Map outputs=1
                GC time elapsed (ms)=219
                CPU time spent (ms)=3480
                Physical memory (bytes) snapshot=1448144896
                Virtual memory (bytes) snapshot=7271227392
                Total committed heap usage (bytes)=1544028160
                Peak Map Physical memory (bytes)=1154592768
                Peak Map Virtual memory (bytes)=3396448256
                Peak Reduce Physical memory (bytes)=293552128
                Peak Reduce Virtual memory (bytes)=3874779136
        Shuffle Errors
                BAD_ID=0
                CONNECTION=0
                IO_ERROR=0
                WRONG_LENGTH=0
                WRONG_MAP=0
                WRONG_REDUCE=0
        File Input Format Counters 
                Bytes Read=16680
        File Output Format Counters 
                Bytes Written=542
```

##### Resultat :

```sh
[eoyono@hadoop-edge01 ~]$ hdfs dfs -cat /user/eoyono/treesBySpecies/part-r-00000
Acer    3
Aesculus        3
Ailanthus       1
Alnus   1
Araucaria       1
Broussonetia    1
Calocedrus      1
Catalpa 1
Cedrus  4
Celtis  1
Corylus 3
Davidia 1
Diospyros       4
Eucommia        1
Fagus   8
Fraxinus        1
Ginkgo  5
Gymnocladus     1
Juglans 1
Liriodendron    2
Maclura 1
Magnolia        1
Paulownia       1
Pinus   5
Platanus        19
Pterocarya      3
Quercus 4
Robinia 1
Sequoia 1
Sequoiadendron  5
Styphnolobium   1
Taxodium        3
Taxus   2
Tilia   1
Ulmus   1
Zelkova 4
```

#### 1.8.4 Maximum height per specie of tree

```sh
[eoyono@hadoop-edge01 ~]$ yarn jar hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar \maxHeight  /user/eoyono/trees.csv /user/eoyono/maxHeightTrees
```
```sh
20/11/07 19:44:05 INFO client.AHSProxy: Connecting to Application History server at hadoop-master03.efrei.online/163.172.100.24:10200
20/11/07 19:44:05 INFO hdfs.DFSClient: Created token for eoyono: HDFS_DELEGATION_TOKEN owner=eoyono@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1604774645252, maxDate=1605379445252, sequenceNumber=4790, masterKeyId=43 on ha-hdfs:efrei
20/11/07 19:44:05 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for eoyono: HDFS_DELEGATION_TOKEN owner=eoyono@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1604774645252, maxDate=1605379445252, sequenceNumber=4790, masterKeyId=43)
20/11/07 19:44:05 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /user/eoyono/.staging/job_1603290159664_2594
20/11/07 19:44:06 INFO input.FileInputFormat: Total input files to process : 1
20/11/07 19:44:06 INFO mapreduce.JobSubmitter: number of splits:1
20/11/07 19:44:06 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1603290159664_2594
20/11/07 19:44:06 INFO mapreduce.JobSubmitter: Executing with tokens: [Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for eoyono: HDFS_DELEGATION_TOKEN owner=eoyono@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1604774645252, maxDate=1605379445252, sequenceNumber=4790, masterKeyId=43)]
20/11/07 19:44:06 INFO conf.Configuration: found resource resource-types.xml at file:/etc/hadoop/3.1.5.0-152/0/resource-types.xml
20/11/07 19:44:06 INFO impl.TimelineClientImpl: Timeline service address: hadoop-master03.efrei.online:8190
20/11/07 19:44:07 INFO impl.YarnClientImpl: Submitted application application_1603290159664_2594
20/11/07 19:44:07 INFO mapreduce.Job: The url to track the job: https://hadoop-master01.efrei.online:8090/proxy/application_1603290159664_2594/
20/11/07 19:44:07 INFO mapreduce.Job: Running job: job_1603290159664_2594
20/11/07 19:44:17 INFO mapreduce.Job: Job job_1603290159664_2594 running in uber mode : false
20/11/07 19:44:17 INFO mapreduce.Job:  map 0% reduce 0%
20/11/07 19:44:26 INFO mapreduce.Job:  map 100% reduce 0%
20/11/07 19:44:32 INFO mapreduce.Job:  map 100% reduce 100%
20/11/07 19:44:32 INFO mapreduce.Job: Job job_1603290159664_2594 completed successfully
20/11/07 19:44:32 INFO mapreduce.Job: Counters: 53
        File System Counters
                FILE: Number of bytes read=574
                FILE: Number of bytes written=494269
                FILE: Number of read operations=0
                FILE: Number of large read operations=0
                FILE: Number of write operations=0
                HDFS: Number of bytes read=16779
                HDFS: Number of bytes written=496
                HDFS: Number of read operations=8
                HDFS: Number of large read operations=0
                HDFS: Number of write operations=2
        Job Counters 
                Launched map tasks=1
                Launched reduce tasks=1
                Data-local map tasks=1
                Total time spent by all maps in occupied slots (ms)=21648
                Total time spent by all reduces in occupied slots (ms)=12224
                Total time spent by all map tasks (ms)=7216
                Total time spent by all reduce tasks (ms)=3056
                Total vcore-milliseconds taken by all map tasks=7216
                Total vcore-milliseconds taken by all reduce tasks=3056
                Total megabyte-milliseconds taken by all map tasks=11083776
                Total megabyte-milliseconds taken by all reduce tasks=6258688
        Map-Reduce Framework
                Map input records=98
                Map output records=96
                Map output bytes=1296
                Map output materialized bytes=574
                Input split bytes=99
                Combine input records=96
                Combine output records=36
                Reduce input groups=36
                Reduce shuffle bytes=574
                Reduce input records=36
                Reduce output records=36
                Spilled Records=72
                Shuffled Maps =1
                Failed Shuffles=0
                Merged Map outputs=1
                GC time elapsed (ms)=198
                CPU time spent (ms)=3640
                Physical memory (bytes) snapshot=1458831360
                Virtual memory (bytes) snapshot=7275188224
                Total committed heap usage (bytes)=1552416768
                Peak Map Physical memory (bytes)=1160478720
                Peak Map Virtual memory (bytes)=3395952640
                Peak Reduce Physical memory (bytes)=298352640
                Peak Reduce Virtual memory (bytes)=3879235584
        Shuffle Errors
                BAD_ID=0
                CONNECTION=0
                IO_ERROR=0
                WRONG_LENGTH=0
                WRONG_MAP=0
                WRONG_REDUCE=0
        File Input Format Counters 
                Bytes Read=16680
        File Output Format Counters 
                Bytes Written=496
```

##### Resultat :

```sh
[eoyono@hadoop-edge01 ~]$ hdfs dfs -cat /user/eoyono/maxHeightTrees/part-r-00000
Acer    16.0
Aesculus        30.0
Ailanthus       35.0
Alnus   16.0
Araucaria       9.0
Broussonetia    12.0
Calocedrus      20.0
Catalpa 15.0
Cedrus  30.0
Celtis  16.0
Corylus 20.0
Davidia 12.0
Diospyros       14.0
Eucommia        12.0
Fagus   30.0
Fraxinus        30.0
Ginkgo  33.0
Gymnocladus     10.0
Juglans 28.0
Liriodendron    35.0
Maclura 13.0
Magnolia        12.0
Paulownia       20.0
Pinus   30.0
Platanus        45.0
Pterocarya      30.0
Quercus 31.0
Robinia 11.0
Sequoia 30.0
Sequoiadendron  35.0
Styphnolobium   10.0
Taxodium        35.0
Taxus   13.0
Tilia   20.0
Ulmus   15.0
Zelkova 30.0
```

#### 1.8.5 Sort the trees height from smallest to largest

```sh
[eoyono@hadoop-edge01 ~]$ yarn jar hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar \sortTrees  /user/eoyono/trees.csv /user/eoyono/sortTrees
```

```sh
20/11/07 19:46:39 INFO client.AHSProxy: Connecting to Application History server at hadoop-master03.efrei.online/163.172.100.24:10200
20/11/07 19:46:40 INFO hdfs.DFSClient: Created token for eoyono: HDFS_DELEGATION_TOKEN owner=eoyono@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1604774800144, maxDate=1605379600144, sequenceNumber=4791, masterKeyId=43 on ha-hdfs:efrei
20/11/07 19:46:40 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for eoyono: HDFS_DELEGATION_TOKEN owner=eoyono@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1604774800144, maxDate=1605379600144, sequenceNumber=4791, masterKeyId=43)
20/11/07 19:46:40 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /user/eoyono/.staging/job_1603290159664_2595
20/11/07 19:46:41 INFO input.FileInputFormat: Total input files to process : 1
20/11/07 19:46:41 INFO mapreduce.JobSubmitter: number of splits:1
20/11/07 19:46:41 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1603290159664_2595
20/11/07 19:46:41 INFO mapreduce.JobSubmitter: Executing with tokens: [Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for eoyono: HDFS_DELEGATION_TOKEN owner=eoyono@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1604774800144, maxDate=1605379600144, sequenceNumber=4791, masterKeyId=43)]
20/11/07 19:46:41 INFO conf.Configuration: found resource resource-types.xml at file:/etc/hadoop/3.1.5.0-152/0/resource-types.xml
20/11/07 19:46:41 INFO impl.TimelineClientImpl: Timeline service address: hadoop-master03.efrei.online:8190
20/11/07 19:46:42 INFO impl.YarnClientImpl: Submitted application application_1603290159664_2595
20/11/07 19:46:42 INFO mapreduce.Job: The url to track the job: https://hadoop-master01.efrei.online:8090/proxy/application_1603290159664_2595/
20/11/07 19:46:42 INFO mapreduce.Job: Running job: job_1603290159664_2595
20/11/07 19:46:52 INFO mapreduce.Job: Job job_1603290159664_2595 running in uber mode : false
20/11/07 19:46:52 INFO mapreduce.Job:  map 0% reduce 0%
20/11/07 19:47:01 INFO mapreduce.Job:  map 100% reduce 0%
20/11/07 19:47:10 INFO mapreduce.Job:  map 100% reduce 100%
20/11/07 19:47:10 INFO mapreduce.Job: Job job_1603290159664_2595 completed successfully
20/11/07 19:47:10 INFO mapreduce.Job: Counters: 53
        File System Counters
                FILE: Number of bytes read=198
                FILE: Number of bytes written=493909
                FILE: Number of read operations=0
                FILE: Number of large read operations=0
                FILE: Number of write operations=0
                HDFS: Number of bytes read=16779
                HDFS: Number of bytes written=136
                HDFS: Number of read operations=8
                HDFS: Number of large read operations=0
                HDFS: Number of write operations=2
        Job Counters 
                Launched map tasks=1
                Launched reduce tasks=1
                Data-local map tasks=1
                Total time spent by all maps in occupied slots (ms)=19566
                Total time spent by all reduces in occupied slots (ms)=26648
                Total time spent by all map tasks (ms)=6522
                Total time spent by all reduce tasks (ms)=6662
                Total vcore-milliseconds taken by all map tasks=6522
                Total vcore-milliseconds taken by all reduce tasks=6662
                Total megabyte-milliseconds taken by all map tasks=10017792
                Total megabyte-milliseconds taken by all reduce tasks=13643776
        Map-Reduce Framework
                Map input records=98
                Map output records=96
                Map output bytes=476
                Map output materialized bytes=198
                Input split bytes=99
                Combine input records=96
                Combine output records=28
                Reduce input groups=28
                Reduce shuffle bytes=198
                Reduce input records=28
                Reduce output records=28
                Spilled Records=56
                Shuffled Maps =1
                Failed Shuffles=0
                Merged Map outputs=1
                GC time elapsed (ms)=189
                CPU time spent (ms)=3060
                Physical memory (bytes) snapshot=1457799168
                Virtual memory (bytes) snapshot=7275196416
                Total committed heap usage (bytes)=1557659648
                Peak Map Physical memory (bytes)=1159770112
                Peak Map Virtual memory (bytes)=3394007040
                Peak Reduce Physical memory (bytes)=298029056
                Peak Reduce Virtual memory (bytes)=3881189376
        Shuffle Errors
                BAD_ID=0
                CONNECTION=0
                IO_ERROR=0
                WRONG_LENGTH=0
                WRONG_MAP=0
                WRONG_REDUCE=0
        File Input Format Counters 
                Bytes Read=16680
        File Output Format Counters 
                Bytes Written=136
```

##### Resultat :

```sh
[eoyono@hadoop-edge01 ~]$ hdfs dfs -cat /user/eoyono/sortTrees/part-r-00000
2.0
5.0
6.0
9.0
10.0
11.0
12.0
13.0
14.0
15.0
16.0
18.0
20.0
22.0
23.0
25.0
26.0
27.0
28.0
30.0
31.0
32.0
33.0
34.0
35.0
40.0
42.0
45.0
```

#### 1.8.6 : District containing the oldest tree

```sh
[eoyono@hadoop-edge01 ~]$ yarn jar hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar \oldestTree  /user/eoyono/trees.csv /user/eoyono/oldestTree
``` 

```sh
20/11/08 19:02:15 INFO client.AHSProxy: Connecting to Application History server at hadoop-master03.efrei.online/163.172.100.24:10200
20/11/08 19:02:15 INFO hdfs.DFSClient: Created token for eoyono: HDFS_DELEGATION_TOKEN owner=eoyono@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1604858535406, maxDate=1605463335406, sequenceNumber=5079, masterKeyId=44 on ha-hdfs:efrei
20/11/08 19:02:15 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for eoyono: HDFS_DELEGATION_TOKEN owner=eoyono@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1604858535406, maxDate=1605463335406, sequenceNumber=5079, masterKeyId=44)
20/11/08 19:02:15 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /user/eoyono/.staging/job_1603290159664_2867
20/11/08 19:02:16 INFO input.FileInputFormat: Total input files to process : 1
20/11/08 19:02:16 INFO mapreduce.JobSubmitter: number of splits:1
20/11/08 19:02:16 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1603290159664_2867
20/11/08 19:02:16 INFO mapreduce.JobSubmitter: Executing with tokens: [Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for eoyono: HDFS_DELEGATION_TOKEN owner=eoyono@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1604858535406, maxDate=1605463335406, sequenceNumber=5079, masterKeyId=44)]
20/11/08 19:02:16 INFO conf.Configuration: found resource resource-types.xml at file:/etc/hadoop/3.1.5.0-152/0/resource-types.xml
20/11/08 19:02:16 INFO impl.TimelineClientImpl: Timeline service address: hadoop-master03.efrei.online:8190
20/11/08 19:02:17 INFO impl.YarnClientImpl: Submitted application application_1603290159664_2867
20/11/08 19:02:17 INFO mapreduce.Job: The url to track the job: https://hadoop-master01.efrei.online:8090/proxy/application_1603290159664_2867/
20/11/08 19:02:17 INFO mapreduce.Job: Running job: job_1603290159664_2867
20/11/08 19:02:27 INFO mapreduce.Job: Job job_1603290159664_2867 running in uber mode : false
20/11/08 19:02:27 INFO mapreduce.Job:  map 0% reduce 0%
20/11/08 19:02:36 INFO mapreduce.Job:  map 100% reduce 0%
20/11/08 19:02:41 INFO mapreduce.Job:  map 100% reduce 100%
20/11/08 19:02:41 INFO mapreduce.Job: Job job_1603290159664_2867 completed successfully
20/11/08 19:02:41 INFO mapreduce.Job: Counters: 53
        File System Counters
                FILE: Number of bytes read=1161
                FILE: Number of bytes written=495855
                FILE: Number of read operations=0
                FILE: Number of large read operations=0
                FILE: Number of write operations=0
                HDFS: Number of bytes read=16779
                HDFS: Number of bytes written=2
                HDFS: Number of read operations=8
                HDFS: Number of large read operations=0
                HDFS: Number of write operations=2
        Job Counters 
                Launched map tasks=1
                Launched reduce tasks=1
                Data-local map tasks=1
                Total time spent by all maps in occupied slots (ms)=19923
                Total time spent by all reduces in occupied slots (ms)=11736
                Total time spent by all map tasks (ms)=6641
                Total time spent by all reduce tasks (ms)=2934
                Total vcore-milliseconds taken by all map tasks=6641
                Total vcore-milliseconds taken by all reduce tasks=2934
                Total megabyte-milliseconds taken by all map tasks=10200576
                Total megabyte-milliseconds taken by all reduce tasks=6008832
        Map-Reduce Framework
                Map input records=98
                Map output records=77
                Map output bytes=1001
                Map output materialized bytes=1161
                Input split bytes=99
                Combine input records=0
                Combine output records=0
                Reduce input groups=1
                Reduce shuffle bytes=1161
                Reduce input records=77
                Reduce output records=1
                Spilled Records=154
                Shuffled Maps =1
                Failed Shuffles=0
                Merged Map outputs=1
                GC time elapsed (ms)=182
                CPU time spent (ms)=3100
                Physical memory (bytes) snapshot=1445339136
                Virtual memory (bytes) snapshot=7270281216
                Total committed heap usage (bytes)=1553465344
                Peak Map Physical memory (bytes)=1156063232
                Peak Map Virtual memory (bytes)=3394973696
                Peak Reduce Physical memory (bytes)=289275904
                Peak Reduce Virtual memory (bytes)=3875307520
        Shuffle Errors
                BAD_ID=0
                CONNECTION=0
                IO_ERROR=0
                WRONG_LENGTH=0
                WRONG_MAP=0
                WRONG_REDUCE=0
        File Input Format Counters 
                Bytes Read=16680
        File Output Format Counters 
                Bytes Written=2
```

##### Resultat :

```sh
[eoyono@hadoop-edge01 ~]$ hdfs dfs -cat /user/eoyono/oldestTree/part-r-00000
5
```


#### 1.8.7 : District containing the most trees

```sh
[eoyono@hadoop-edge01 ~]$ yarn jar hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar \mostTrees  /user/eoyono/trees.csv /user/eoyono/mostTrees /user/eoyono/mostTrees/final
```

```sh
20/11/08 19:05:45 INFO client.AHSProxy: Connecting to Application History server at hadoop-master03.efrei.online/163.172.100.24:10200
20/11/08 19:05:45 INFO hdfs.DFSClient: Created token for eoyono: HDFS_DELEGATION_TOKEN owner=eoyono@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1604858745272, maxDate=1605463545272, sequenceNumber=5083, masterKeyId=44 on ha-hdfs:efrei
20/11/08 19:05:45 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for eoyono: HDFS_DELEGATION_TOKEN owner=eoyono@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1604858745272, maxDate=1605463545272, sequenceNumber=5083, masterKeyId=44)
20/11/08 19:05:45 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /user/eoyono/.staging/job_1603290159664_2870
20/11/08 19:05:46 INFO input.FileInputFormat: Total input files to process : 1
20/11/08 19:05:46 INFO mapreduce.JobSubmitter: number of splits:1
20/11/08 19:05:46 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1603290159664_2870
20/11/08 19:05:46 INFO mapreduce.JobSubmitter: Executing with tokens: [Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for eoyono: HDFS_DELEGATION_TOKEN owner=eoyono@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1604858745272, maxDate=1605463545272, sequenceNumber=5083, masterKeyId=44)]
20/11/08 19:05:46 INFO conf.Configuration: found resource resource-types.xml at file:/etc/hadoop/3.1.5.0-152/0/resource-types.xml
20/11/08 19:05:46 INFO impl.TimelineClientImpl: Timeline service address: hadoop-master03.efrei.online:8190
20/11/08 19:05:47 INFO impl.YarnClientImpl: Submitted application application_1603290159664_2870
20/11/08 19:05:47 INFO mapreduce.Job: The url to track the job: https://hadoop-master01.efrei.online:8090/proxy/application_1603290159664_2870/
20/11/08 19:05:47 INFO mapreduce.Job: Running job: job_1603290159664_2870
20/11/08 19:05:57 INFO mapreduce.Job: Job job_1603290159664_2870 running in uber mode : false
20/11/08 19:05:57 INFO mapreduce.Job:  map 0% reduce 0%
20/11/08 19:06:07 INFO mapreduce.Job:  map 100% reduce 0%
20/11/08 19:06:16 INFO mapreduce.Job:  map 100% reduce 100%
20/11/08 19:06:16 INFO mapreduce.Job: Job job_1603290159664_2870 completed successfully
20/11/08 19:06:16 INFO mapreduce.Job: Counters: 53
        File System Counters
                FILE: Number of bytes read=976
                FILE: Number of bytes written=495527
                FILE: Number of read operations=0
                FILE: Number of large read operations=0
                FILE: Number of write operations=0
                HDFS: Number of bytes read=16779
                HDFS: Number of bytes written=80
                HDFS: Number of read operations=8
                HDFS: Number of large read operations=0
                HDFS: Number of write operations=2
        Job Counters 
                Launched map tasks=1
                Launched reduce tasks=1
                Data-local map tasks=1
                Total time spent by all maps in occupied slots (ms)=21351
                Total time spent by all reduces in occupied slots (ms)=27312
                Total time spent by all map tasks (ms)=7117
                Total time spent by all reduce tasks (ms)=6828
                Total vcore-milliseconds taken by all map tasks=7117
                Total vcore-milliseconds taken by all reduce tasks=6828
                Total megabyte-milliseconds taken by all map tasks=10931712
                Total megabyte-milliseconds taken by all reduce tasks=13983744
        Map-Reduce Framework
                Map input records=98
                Map output records=97
                Map output bytes=776
                Map output materialized bytes=976
                Input split bytes=99
                Combine input records=0
                Combine output records=0
                Reduce input groups=17
                Reduce shuffle bytes=976
                Reduce input records=97
                Reduce output records=17
                Spilled Records=194
                Shuffled Maps =1
                Failed Shuffles=0
                Merged Map outputs=1
                GC time elapsed (ms)=188
                CPU time spent (ms)=3260
                Physical memory (bytes) snapshot=1444614144
                Virtual memory (bytes) snapshot=7271809024
                Total committed heap usage (bytes)=1561853952
                Peak Map Physical memory (bytes)=1157853184
                Peak Map Virtual memory (bytes)=3396034560
                Peak Reduce Physical memory (bytes)=286760960
                Peak Reduce Virtual memory (bytes)=3875774464
        Shuffle Errors
                BAD_ID=0
                CONNECTION=0
                IO_ERROR=0
                WRONG_LENGTH=0
                WRONG_MAP=0
                WRONG_REDUCE=0
        File Input Format Counters 
                Bytes Read=16680
        File Output Format Counters 
                Bytes Written=80
20/11/08 19:06:16 INFO client.AHSProxy: Connecting to Application History server at hadoop-master03.efrei.online/163.172.100.24:10200
20/11/08 19:06:16 INFO hdfs.DFSClient: Created token for eoyono: HDFS_DELEGATION_TOKEN owner=eoyono@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1604858776795, maxDate=1605463576795, sequenceNumber=5084, masterKeyId=44 on ha-hdfs:efrei
20/11/08 19:06:16 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for eoyono: HDFS_DELEGATION_TOKEN owner=eoyono@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1604858776795, maxDate=1605463576795, sequenceNumber=5084, masterKeyId=44)
20/11/08 19:06:16 WARN mapreduce.JobResourceUploader: Hadoop command-line option parsing not performed. Implement the Tool interface and execute your application with ToolRunner to remedy this.
20/11/08 19:06:16 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /user/eoyono/.staging/job_1603290159664_2871
20/11/08 19:06:17 INFO input.FileInputFormat: Total input files to process : 1
20/11/08 19:06:17 INFO mapreduce.JobSubmitter: number of splits:1
20/11/08 19:06:17 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1603290159664_2871
20/11/08 19:06:17 INFO mapreduce.JobSubmitter: Executing with tokens: [Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for eoyono: HDFS_DELEGATION_TOKEN owner=eoyono@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1604858776795, maxDate=1605463576795, sequenceNumber=5084, masterKeyId=44)]
20/11/08 19:06:17 INFO impl.TimelineClientImpl: Timeline service address: hadoop-master03.efrei.online:8190
20/11/08 19:06:17 INFO impl.YarnClientImpl: Submitted application application_1603290159664_2871
20/11/08 19:06:17 INFO mapreduce.Job: The url to track the job: https://hadoop-master01.efrei.online:8090/proxy/application_1603290159664_2871/
20/11/08 19:06:17 INFO mapreduce.Job: Running job: job_1603290159664_2871
20/11/08 19:06:29 INFO mapreduce.Job: Job job_1603290159664_2871 running in uber mode : false
20/11/08 19:06:29 INFO mapreduce.Job:  map 0% reduce 0%
20/11/08 19:06:38 INFO mapreduce.Job:  map 100% reduce 0%
20/11/08 19:06:43 INFO mapreduce.Job:  map 100% reduce 100%
20/11/08 19:06:44 INFO mapreduce.Job: Job job_1603290159664_2871 completed successfully
20/11/08 19:06:44 INFO mapreduce.Job: Counters: 53
        File System Counters
                FILE: Number of bytes read=176
                FILE: Number of bytes written=493601
                FILE: Number of read operations=0
                FILE: Number of large read operations=0
                FILE: Number of write operations=0
                HDFS: Number of bytes read=192
                HDFS: Number of bytes written=3
                HDFS: Number of read operations=8
                HDFS: Number of large read operations=0
                HDFS: Number of write operations=2
        Job Counters 
                Launched map tasks=1
                Launched reduce tasks=1
                Data-local map tasks=1
                Total time spent by all maps in occupied slots (ms)=21705
                Total time spent by all reduces in occupied slots (ms)=11036
                Total time spent by all map tasks (ms)=7235
                Total time spent by all reduce tasks (ms)=2759
                Total vcore-milliseconds taken by all map tasks=7235
                Total vcore-milliseconds taken by all reduce tasks=2759
                Total megabyte-milliseconds taken by all map tasks=11112960
                Total megabyte-milliseconds taken by all reduce tasks=5650432
        Map-Reduce Framework
                Map input records=17
                Map output records=17
                Map output bytes=136
                Map output materialized bytes=176
                Input split bytes=112
                Combine input records=0
                Combine output records=0
                Reduce input groups=1
                Reduce shuffle bytes=176
                Reduce input records=17
                Reduce output records=1
                Spilled Records=34
                Shuffled Maps =1
                Failed Shuffles=0
                Merged Map outputs=1
                GC time elapsed (ms)=207
                CPU time spent (ms)=3020
                Physical memory (bytes) snapshot=1446952960
                Virtual memory (bytes) snapshot=7267287040
                Total committed heap usage (bytes)=1556086784
                Peak Map Physical memory (bytes)=1155014656
                Peak Map Virtual memory (bytes)=3394027520
                Peak Reduce Physical memory (bytes)=291938304
                Peak Reduce Virtual memory (bytes)=3873259520
        Shuffle Errors
                BAD_ID=0
                CONNECTION=0
                IO_ERROR=0
                WRONG_LENGTH=0
                WRONG_MAP=0
                WRONG_REDUCE=0
        File Input Format Counters 
                Bytes Read=80
        File Output Format Counters 
                Bytes Written=3
```

##### Resultat :

```sh
[eoyono@hadoop-edge01 ~]$ hdfs dfs -cat /user/eoyono/mostTrees/final/part-r-00000
16
```


### Testing

We did UnitTest for each of our Mapper and Reducer classes but we had the mapper6 and mapper7_1 that failed because of the usage of our proper Writable class. We tried but didn't succeed to fix it.

### Commit

Because of a lack of understanding of GitHub, we committed but it was on the original git project so we cannot push it.
So lately, we created our own github repository and commited the exercices into. Thereby, the dates of commit won't be correlated with the dates of the TPs.

Here are the wrong commits id : 60399c96dcf7b85b27626c9a1f71fcca96dfe843 & e4ba897117958fae0a138bf9ed5aa7f9c35dfd53

Here is the link of the GitHub : https://github.com/Sarah-OB/HDFS_MapReduce

 