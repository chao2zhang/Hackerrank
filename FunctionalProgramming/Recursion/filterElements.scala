object Solution {

    def f(k: Int, a: Array[Int]) {
        val b = a.zipWithIndex.groupBy(_._1).filter(_._2.length >= k).map{ case (x,y) => (
x, y(0)._2)}.toList.sortBy(_._2).map(_._1).toArray.mkString(" ")
        if (b.isEmpty)
            println(-1)
        else
            println(b)
    }
    def iter(): Unit = f(readLine().trim().split(' ').map(_.toInt).apply(1), readLine().trim().split(' ').map(_.toInt))
    def loop(t: Int): Unit = if (t > 0) {
        iter()
        loop(t - 1)
    }
    def main(args: Array[String]) {
        loop(readInt())
    }
}