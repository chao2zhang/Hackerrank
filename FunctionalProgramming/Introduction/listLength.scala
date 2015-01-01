def f(arr:List[Int]):Int = arr match {
    case Nil => 0
    case h :: t => 1 + f(t)
}