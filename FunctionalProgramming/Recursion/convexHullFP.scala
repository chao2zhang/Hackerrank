import scala.collection.mutable.ArrayBuffer

object Solution {

    type Coordinate = (Int, Int)

    def euclid(x: Coordinate, y: Coordinate): Double = 
        Math.sqrt(Math.pow(x._1 - y._1, 2) + Math.pow(x._2 - y._2, 2))

    def array2Tuple(a: Array[Int]): Coordinate = (a(0), a(1))

    def crossProduct(a: Coordinate, b: Coordinate, c: Coordinate): Int =
        (b._1 - a._1) * (c._2 - b._2) - (c._1 - b._1) * (b._2 - a._2)

    def inBetween(a: Coordinate, b: Coordinate, c: Coordinate): Boolean =
        crossProduct(a, b, c) == 0 && (b._1 - a._1) * (b._1 - c._1) <= 0 && (b._2 - a._2) * (b._2 - c._2) <= 0

    def shouldRemove(a: Coordinate, b: Coordinate, c: Coordinate): Boolean =
        crossProduct(a, b, c) < 0 || inBetween(b, a, c)

    def convexHull(a: Array[Coordinate]): Double = {
        val p0 = a.minBy(_.swap)
        val b = a.filter(_ != p0).sortBy(x => (p0._1 - x._1) / euclid(p0, x)) :+ p0
        val h = b.tail.foldLeft(ArrayBuffer(p0, b.head)) {
            (z, x) => {
                while (z.length >= 2 && shouldRemove(z(z.length - 2), z.last, x))
                    z.remove(z.length - 1)
                if (z.length < 2 || !inBetween(z(z.length - 2), x, z.last))
                    z += x
                z
            }
        }
        h.sliding(2).toArray.map(t => euclid(t(0), t(1))).sum
    }

    def main(args: Array[String]) {
        println(convexHull((1 to readInt()).map(_ => array2Tuple(readLine.trim.split(' ').map(_.toInt))).toArray))
    }
}