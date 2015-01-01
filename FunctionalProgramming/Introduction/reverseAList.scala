def f(arr:List[Int]):List[Int] = {
    def r(cur:List[Int], res:List[Int]): List[Int] = cur match {
        case Nil => res
        case h :: t => r(t, h :: res)
    }
    r(arr, Nil)
}