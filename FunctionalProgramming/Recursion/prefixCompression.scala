object Solution {

    def g(s1: String, s2: String, l: Int) {
        printf("%d %s\n", l, s1.substring(0, l))
        printf("%d %s\n", s1.length - l, s1.substring(l))
        printf("%d %s\n", s2.length - l, s2.substring(l))
    }

    def f(s1: String, s2: String): Unit = {
        g(s1, s2, (s1 zip s2).span(x => x._2 == x._1)._1.length)
    }

    def main(args: Array[String]) {
        f(readLine(), readLine())
    }
}