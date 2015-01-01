 def f(arr:List[Int]):List[Int] = {
     def fR(i: Int, a: List[Int]): List[Int] = (i, a) match {
         case (_, Nil) => Nil
         case (1, h :: t) => fR(0, t)
         case (0, h :: t) => h :: fR(1, t)
     }
     fR(1, arr)
 }