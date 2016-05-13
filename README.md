# MoonShot_Project

Application: Simulation real-time predictive analytics on banking credit-applicaitons.

The project was built and deployed in Amazon AWS instance.
The core components of the projects include the following:
	a. Simulator for message streams.
	b. Apache Kafka for message streaming.
	c. Apache Spark Ecosystem  for Precitive Analytics.
	d. Visualizing analytics (moonshot dashboard) hosted on heroku cloud.
 
A. Simulator for message streams:
	The simulator is part of the Apache Kafka. It's a producer that streams messages to the Kafka brokers, which lead the data ultimately to the zookeeper.
	Techical info:
	**************
		
		The simulator is a REST API which streams opted amount of message streams by the user from the dashboard(Moonshot_dashboard project).

		The API has been coded in NodeJS which utilises the Kafka-node npm module, which is a producer that streams data to the kafka-engine.



B. Apache Kafka for message streaming:
	
	The streaming engine is hosted on Amazon AWS instances. Physically there are three AMIs deployed, with each one housing the following:
			1.  Zookeeper
			2.  Broker-1
			3. 	Broker-2

C. Apache Spark Ecosystem :

	The spark ecosystem lies on the other end of the Kafka engine. The consumer for the messages streams to the Kafka engine by the producer on the other side is received by the spark ecosystem and is fed to the Machine learning model(Naive Bayes) which predicts the possible outcome redirected to the database in EC2 on the Amazon AWS cloud.
	Techical info:
	**************
		The entire spark eco-system is programmed in scala. 
		The consumer for kafka and MLlib in spark besides db operations.

d. Visualizing analytics :
	Refer to the project Moonshot_dashboard in the repositories for details about this section of the project.


Technologies Used:
******************
 AWS-Amazon, Apache Kafka, Apache Spark, NodeJS, HerokuCloud, MySQL, UNIX.

