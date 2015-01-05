object Solution {

    def superOnce(n: String): String = n.map(_.asDigit).sum.toString

    def superDigit(n: String): String = if (n.length == 1) n else superDigit(superOnce(n))

    def main(args: Array[String]) {
        println(superDigit(readLine().split(' ') match { case Array(x, y) => superOnce(x) * y.toInt }))
    }
}