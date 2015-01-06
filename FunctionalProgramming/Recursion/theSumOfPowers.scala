object Solution {
    
    def numberOfWays(x:Int, n:Int):Int = {
        val f = Array.fill(x + 1)(0)
        f(0) = 1
        (1 to Math.pow(x, 1.0 / n).toInt).foreach(i => {
            val m = Math.pow(i, n).toInt
            (x to m by -1).foreach(j => f(j) += f(j - m))
            })
        f(x)
    }

    def main(args: Array[String]) {
       println(numberOfWays(readInt(),readInt()))
    }
}
