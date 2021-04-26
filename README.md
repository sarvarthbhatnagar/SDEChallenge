# PaytmLabs SDE Challenge

## Coding Question

IMovingAverageAware provides constructs for adding elements,
calculating moving averages for N elements and getting underlying elements.

MovingAverageImpl uses LinkedList as the underlying datastructure as it would offer
O(1) for writes - LinkedList has pointer to the last node
O(N) for calculating moving average on last N elements

3. Provide any additional explanation about the interface and implementation in a README file.

## Design Question

1. Handle large write volume: Billions of write events per day.
This can be addressed by a scalable messaging queue - Apache Kafka.
The publish-subscribe model in the self-replicating clusters seems to be a good fit.
Considering the benefits like high throughput, fault tolerance and durability, Kafka would be able to address this problem


2. Handle large read/query volume: Millions of merchants wish to gain insight into their business. Read/Query patterns are time-series related metrics.
For scaling, the good choice might seem to be NoSQL. However, RDBMS is powerful for time-series.
Hence, a time-series scalable database like TimeScaleDB would be a better choice than NoSQL

3. Provide metrics to customers with at most one hour delay.
Grafana is open-source and helps in analyzing and visualizing metrics like CPU, memory, I/O & disk utilization.
This would be good option for providing metrics to customers

4. Run with minimum downtime.
If using the micro-service architecture then the analytics service can be containerized and orchestrated with Kubernetes.
Any update to the code can be pushed with 0 downtime.

5. Have the ability to reprocess historical data in case of bugs in the processing logic.
Elastic Search support will be useful in this case. Elasticsearch sink connector helps in integrating Apache Kafka and Elasticsearch.
