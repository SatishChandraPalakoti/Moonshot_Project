
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.mllib.classification.NaiveBayes
import org.apache.spark.mllib.classification.NaiveBayes
import org.apache.spark.mllib.classification.NaiveBayesModel
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.regression.LabeledPoint
import java.sql.DriverManager
import java.sql.Connection

import org.apache.spark.rdd.JdbcRDD


object  program
{
//  def main(args: Array[String]) = {
//    System.setProperty("hadoop.home.dir", "C:\\Users\\Sharath\\Desktop\\hadoop-common-2.2.0-bin-master\\")
//    val conf = new SparkConf().setAppName("Bayes Model").setMaster("local")
//    val sc = new SparkContext(conf)
//    val data = sc.textFile("sample_naive_bayes_data.txt")
//    val parsedData = data.map { line =>
//      val parts = line.split(',')
//      LabeledPoint(parts(14).toDouble, Vectors.dense(parts(1).toDouble,
//        parts(2).toDouble,
//        parts(3).toDouble,
//        parts(4).toDouble,
//        parts(5).toDouble,
//        parts(6).toDouble,
//        parts(7).toDouble,
//        parts(8).toDouble,
//        parts(9).toDouble,
//        parts(10).toDouble,
//        parts(11).toDouble,
//        parts(12).toDouble,
//        parts(13).toDouble))
//    }
//    // Split data into training (60%) and test (40%).
//    val splits = parsedData
//    val training = splits
//
//    val model = NaiveBayes.train(training, lambda = 1.0, modelType = "multinomial")
////    val predictionAndLabel = test.map(p => (model.predict(p.features), p.label))
//    val test = Vectors.dense(Array(41,0.04,2,10,4,0.04,0,1,1,0,1,560,1))
//    val predictionAndLabel =  model.predict(test)
////    val x=predictionAndLabel.collect()
////  println(x.length)
//    println("**************************************result*******************************")
////    x.foreach(x=> println(x.toString()+"\n"))
//    if(predictionAndLabel==0)
//    println("Prediction model says credit cannot be approved")
//    else
//      println("Prediction model says credit can be approved")
//
//
////    val accuracy = 1.0 * predictionAndLabel.filter(x => x._1 == x._2).count() / test.count()
////    println("Accuracy of the model is: "+accuracy)
//    // Save and load model
//    model.save(sc, "target/tmp/myNaiveBayesModel1")
//    //    val sameModel = NaiveBayesModel.load(sc, "target/tmp/myNaiveBayesModel")
//  }
  def main(args: Array[String])={

  val driver = "com.mysql.jdbc.Driver"
  val url = "jdbc:mysql://ec2-52-37-241-124.us-west-2.compute.amazonaws.com/credit_data"
  val username = "root"
  val password = ""

  var connection:Connection=null;
  try{
    Class.forName(driver)
    connection=DriverManager.getConnection(url,username,password)
    val statement=connection.createStatement()
    val resultset=statement.executeQuery("SELECT Married,Employed FROM credit_data")
    println(resultset.first())
//    while(resultset.next()){
//      println("Status of Marriage :"+resultset.getInt("Married")+" \n Status of Employment :"+resultset.getInt("Employed")+"\n****************")
//
//    }
//    val data=JdbcRDD.resultSetToObjectArray(resultset)
//    val res=data.toString()
//    res.foreach(line=>println(line))
  }
  catch {
    case e=> e.printStackTrace
  }
  connection.close()

  }
}