object Solution {

    def split(n: Int): Vector[(Int, Int, Int)] = n match {
        case 0 => Vector(Tuple3(0, 31, 32))
        case x => split(x - 1) flatMap {
                            x => Vector(
                                Tuple3(x._1, x._2, x._3 / 2),
                                Tuple3(x._1 + x._3 / 2, x._2 - x._3 / 2, x._3 / 2),
                                Tuple3(x._1 + x._3 / 2, x._2 + x._3 / 2, x._3 / 2)
                                )
                        }
    }

    def fill(l: Vector[(Int, Int, Int)]): Vector[(Int, Int)] = l flatMap {
        x => for {
            r <- x._1 until x._1 + x._3
            c <- (x._2 - x._3 + 1) to (x._2 + x._3 - 1)
            if (c - x._2).abs <= (r - x._1).abs
        } yield Tuple2(r, c)
    }

    def drawTriangles(n: Int) {
        fill(split(n)).foldLeft(Array.fill(32, 63)('_'))((z, x) => {
            z(x._1)(x._2) = '1'
            z
        }).map{x => println(x.mkString(""))} 
    }

    def main(args: Array[String]) {
        drawTriangles(readInt())
    }
}
