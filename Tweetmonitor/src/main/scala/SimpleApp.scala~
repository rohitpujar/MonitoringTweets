import java.io._
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.mllib.classification.NaiveBayes
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint



object SimpleApp{  

def main(args: Array[String]){

//val logFile = "data/sample.txt"
val trainingFile = "data/trainingdata.txt"
val testingFile = "data/testingdata.txt"
val sc = new SparkContext("local", "Simple App", "/path/to/spark-1.3.0-incubating",
List("target/scala-2.10/simple-project_2.10-1.0.jar"))
//val data = sc.textFile(logFile, 2).cache()

val trainingdata = sc.textFile(trainingFile).cache()
val testingdata = sc.textFile(testingFile).cache()

val parsedTrainingData = trainingdata.map { line =>
  val parts = line.split(',')
  LabeledPoint(parts(0).toDouble, Vectors.dense(parts(1).split(' ').map(_.toDouble)))
}

val parsedTestingData = testingdata.map { line =>
  val parts = line.split(',')
  LabeledPoint(parts(0).toDouble, Vectors.dense(parts(1).split(' ').map(_.toDouble)))
}

// Split data into training (60%) and test (40%).
//val splits = parsedData.randomSplit(Array(0.8, 0.2), seed = 11L)
val training = parsedTrainingData
val test = parsedTestingData
val model = NaiveBayes.train(training, lambda = 1.0)

val predictionAndLabel = test.map(p => (model.predict(p.features), p.label))

val file = "naiveop.txt"
val writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)))

println("---------------Printing rdd ---------------------")
predictionAndLabel.toArray().foreach(line=>writer.write(line._1+"\n"))


/*for(x <- predictedData){
 writer.write(x + "\n")
}*/
writer.close()
val accuracy = 1.0 * predictionAndLabel.filter(x => x._1 == x._2).count() / test.count()

println("Prediction and label : "+predictionAndLabel.toString())
println("Accuracy : "+accuracy)
println("-----------------------------------------------")
}
}

