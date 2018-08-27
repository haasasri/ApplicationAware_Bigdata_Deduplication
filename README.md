# ApplicationAware_Bigdata_Deduplication
Design of a deduplication model utilizing the property of application awareness i.e a high range of data similarity exists between a particular kind of applications. A two tiered inter node data routing enhanced by intra node application awareness is employed to achieve this optimized deduplication.

## Code

## Two tiered data routing scheme:

The two tiered data routing scheme includes the file-level application aware routing and similarity based on grouping into super chunks in director. 

### Application aware routing algorithm:

* Input: the directory where deduplication has to be performed.

* Output: a node used for storage of similar application data.

* For each file f in the directory
1.	Get the extension name of file f from its extension at the end of full name.
2.	The application route table in the disk storage is queried by the director, the dedupe storage node Ali that stores the same type of application data is identified; The corresponding storage node from ID_li={Al1, Al2, … , Alm} in route table Alk is identified
3.	Check the node list: if ID_li=  or all overloading problem persists in node list, then new dedupe storage node is added into the list 
4.	Return the main storage node Alk to be used for further deduplication is returned to the director.
	
### Handprinting based stateful data routing:

* Input: A list of fingerprints of chunks constituting a super-chunk Sk in a file, {f1, f2, … , fc}, and the corresponding main storage node  Alk. 

* Output: a target sub node n.

1. m minimum chunk fingerprints {rf1, rf2, …, rfk} are to be selected as a fingerprint for the super-chunk Sk by performing sort function on  the list of chunk fingerprints {f1, f2, …, fc}
2. The similarity ratio of the super-chunk Sk is calculated by comparing with the  fingerprint of the previously stored super-chunks in the storage sub nodes in the main node, which are denoted as {rp1, rp2, …, rpk};
3. The storage sub node with ID n that satisfies rn = max{rp1, rp2, …, rpk}is chosen as the target sub node.


## Results
 
* Input is given in the form of directory where the deduplication has to be performed. Various data traces are passed through the designed deduplicator to observe the deduplication ratios and thereby evaluate deduplication efficiency.

### Pdf traces 

* A directory containing pdf files is deduplicated. The original size of the input folder is 41.3 MB. After the deduplication is performed in the dedupe storage node allocated to pdf files, the total disk storage with the chunk fingerprints is equal to 5.3 MB. The total time taken for the deduplication is 14 seconds.

* Deduplication ratio = 41.3 MB/5.3 MB 
                                =7.79
* Deduplication efficiency = (41.3-5.3)MB/14 sec
                                = 2.57 MB/sec

### Audio Traces 

* A directory containing audio files is deduplicated. The original size of the input folder is 77.2 MB. After the deduplication is performed in the dedupe storage node allocated to mp3/mp4 files, the total disk storage with the chunk fingerprints is equal to 20.3 MB. The total time taken for the deduplication is 17 seconds.

* Deduplication ratio = 77.2 MB/20.3 MB 
                                =3.80
* Deduplication efficiency = (77.2-20.3)MB/17 sec
                                = 3.35 MB/sec

### Video traces 

* A directory containing video files is deduplicated. The original size of the input folder is 528 MB. After the deduplication is performed in the dedupe storage node allocated to mk3/mk4 files, the total disk storage with the chunk fingerprints is equal to 62.68 MB. The total time taken for the deduplication is 32 seconds.

* Deduplication ratio = 528 MB/62.68 MB 
                                =8.42
* Deduplication efficiency = (528-62.68) MB/32 sec= 14.54 MB/sec


### Web traces

* A directory containing web traces is deduplicated. The original size of the input folder is 3400 MB. After the deduplication is performed in the dedupe storage node allocated to blkparse files, the total disk storage with the chunk fingerprints is equal to 370 MB. The total time taken for the deduplication is 120 seconds.

* Deduplication ratio = 3400 MB/370 MB 
                                =10.88
* Deduplication efficiency = (3400-370) MB/120 sec= 25.25 MB/sec



* From the above results, we can infer that there is an increase in deduplication throughput on incorporating application awareness phenomenon.


## Conclusion

* Using this application aware scalable inline distributed deduplication framework for data deduplication, an agreement is reached between performance scalability and the distributed deduplication effectiveness by employing application awareness, data locality and similarity.
* To route data at the super-chunk level, two-tiered data routing is employed to reduce the cross-node data redundancy with good load balance and a low communication overhead, and adopts an optimization based on application-aware similarity index to enhance deduplication efficiency in each node where RAM usage is less.
* The significant advantages are demonstrated clearly over the state-of-the-art distributed deduplication methods for huge clusters in the below two ways.
* First, it beats the remarkably costly and poorly scalable stateful tight coupling scheme in the group wide deduplication proportion,however,just hardly at a marginally higher system overhead than the exceedingly adaptable loose coupling schemes.
* Second, it enhances the stateless loose coupling schemes in the group-wide effective deduplication ratio while holding the high system scalability of the other with low overhead.   


## Programming Language

Java

## Tools/IDE

Eclipse

