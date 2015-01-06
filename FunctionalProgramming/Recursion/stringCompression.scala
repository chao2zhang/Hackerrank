import scala.collection.mutable.ArrayBuffer

object Solution {

    def main(args: Array[String]) {
        println(readLine().foldLeft(ArrayBuffer[(Char, Int)]()) ((z, c) => {
            if (!z.isEmpty && z.last._1 == c) z(z.length-1) = Tuple2(z.last._1, z.last._2 + 1)
            else z += Tuple2(c, 1)
            z
        }).foldLeft(new StringBuffer) ((z, t) => {
            z.append(t._1)
            if (t._2 > 1) z.append(t._2)
            z
        }))
    }
}