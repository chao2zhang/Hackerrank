 def f(arr:List[Int]):Int = arr.filter{x => (x & 1) == 1}.fold(0)(_+_)