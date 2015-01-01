def f(coefficients:List[Int],powers:List[Int],x:Double):Double = {
  (coefficients, powers).zipped.map{case (c, p) => c * Math.pow(x, p)}.sum
}

def area(coefficients:List[Int],powers:List[Int],x:Double):Double = {
  Math.PI * Math.pow(f(coefficients, powers, x), 2)
}

def summation(func:(List[Int],List[Int],Double)=>Double,upperLimit:Int,lowerLimit:Int,coefficients:List[Int],powers:List[Int]):Double = {
  ((lowerLimit + 0.0005) to (upperLimit + 0.0005, 0.001)).map(x => func(coefficients, powers, x) * 0.001).sum
}
