/**
  * Created by palakoti on 4/23/2016.
  */



import kafka.Kafka
import kafka.consumer.Consumer
import kafka.consumer.ConsumerConfig
import kafka.consumer.ConsumerIterator
import kafka.consumer.KafkaStream
import kafka.javaapi.consumer.ConsumerConnector
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.streaming.StreamingContext
import scala.collection.immutable.Map
import scala.collection.mutable.ArrayBuffer

object s {
  def main(args: Array[String]) : Unit = {

    val props = new java.util.Properties()
    props.put("zookeeper.connect", "ec2-52-39-155-4.us-west-2.compute.amazonaws.com:2181")
    props.put("group.id", "stream")
    props.put("zookeeper.session.timeout", "500")
    props.put("zookeeper.sync.time.ms", "300")
    props.put("auto.commit.interval.ms", "1000")
    val config = new kafka.consumer.ConsumerConfig(props);

    //val consumerConnector = Consumer.createJavaConsumerConnector(config)

    val consumer = kafka.consumer.Consumer.create(config)

    val topicName = "stream"
    val numThreads = 1

    val topicMap = Map(topicName -> numThreads)

    val consumerMap = consumer.createMessageStreams(topicMap)

    val consumerIterator = consumerMap.get(topicName).get.head.iterator()

    val msgs = consumerIterator.map(_.message())

    //    msgs.foreach { msg => val x = new String(msg)
    //      val y = x.split(',')
    //      var g = ArrayBuffer[Double]()
    //      y.foreach(k=> g+=k.toDouble)
    //      print(g)
    //    }
    msgs.foreach { msg => val x = new String(msg)
      val y = x.split(',')
      val z=y.map(each=>each.toDouble)
      println(z)
      z.foreach(x=>println(x))
    }
  }
}