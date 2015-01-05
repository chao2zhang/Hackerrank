object Solution {

    def factorial(i: Int): Int = if (i == 0) 1 else i * factorial(i - 1)

    def main(args: Array[String]) {
        for (x <- (0 until readInt()))
            println((0 to x).map(y => factorial(x) / factorial(y) / factorial(x - y)).mkString(" "))
    }
}