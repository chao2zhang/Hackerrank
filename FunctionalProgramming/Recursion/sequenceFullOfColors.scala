object Solution {

    def f(s: String) {
        val yb = s.filter(x => x == 'Y' || x == 'B')
        val rg = s.filter(x => x == 'R' || x == 'G')
        println(yb.indexOf("YY") + yb.indexOf("BB") + rg.indexOf("RR") + rg.indexOf("GG") == -4)
    }
    def iter(): Unit = f(readLine().trim())
    def loop(t: Int): Unit = if (t > 0) {
        iter()
        loop(t - 1)
    }
    def main(args: Array[String]) {
        loop(readInt())
    }
}