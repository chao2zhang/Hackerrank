def f(x: Float):Float = {
    def factorial(n: Float): Float = {  
      if (n <= 1) 1 else n * factorial(n - 1)
    }
    (0 to 9).map(n => Math.pow(x, n).toFloat / factorial(n)).reduce(_ + _)
}