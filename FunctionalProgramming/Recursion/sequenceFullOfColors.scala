object Solution {

    def f(s: String): Unit = {
        var rg = 0
        var yb = 0
        for (ch <- s) {
            ch match {
                case 'Y' => yb += 1
                case 'B' => yb -= 1
                case 'G' => rg += 1
                case 'R' => rg -= 1
            }
            if (yb > 1 || yb < -1 || rg > 1 || rg < -1) {
                println("False")
                return
            }
        }
        if (yb != 0 || rg != 0) println("False") else println("True")
    }
    def iter(): Unit = f(readLine().trim())
    def main(args: Array[String]) {
        (1 to readInt()).foreach(x => iter())
    }
}