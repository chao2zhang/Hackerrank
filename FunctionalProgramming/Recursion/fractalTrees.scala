object Solution {

    val roots = Stream.iterate(List(Tuple3(62, 49, 16)))(
        l => l flatMap {
            p => List(
                (p._1 - p._3 * 2, p._2 - p._3, p._3 / 2),
                (p._1 - p._3 * 2, p._2 + p._3, p._3 / 2)
            )
        }
    )

    def fill(l: List[(Int, Int, Int)]): List[(Int, Int)] = l flatMap {
        x => (0 until x._3).flatMap {
                s => List(
                    (x._1 - s, x._2), 
                    (x._1 - x._3 - s, x._2 - 1 - s), 
                    (x._1 - x._3 - s, x._2 + 1 + s)
                )
            }
    }

    def drawTrees(n: Int) {
        fill(roots.take(n).flatten.toList).foldLeft(Array.fill(63, 100)('_'))((z, x) => {
            z(x._1)(x._2) = '1'
            z
        }).map{x => println(x.mkString(""))} 
    }

    def main(args: Array[String]) {
        drawTrees(readInt())
    }
}
