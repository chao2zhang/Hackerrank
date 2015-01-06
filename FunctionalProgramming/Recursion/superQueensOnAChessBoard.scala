object Solution {
    type Queen = (Int, Int)
    type R = List[List[Queen]]

    def isSafe(q: Queen, qs: List[Queen]) = qs.forall(!isAttacked(q, _))
    def isAttacked(q: Queen, q2: Queen) = 
        q._1 == q2._1 ||
        q._2 == q2._2 ||
        (q._1 - q2._1).abs == (q._2 - q2._2).abs ||
        ((q._1 - q2._1) * (q._2 - q2._2)).abs == 2
    def solveNSuperQueens(sz: Int): Int = {
        def solve(n: Int): R = n match {
            case 0 => List(Nil)
            case _ => for {
                queens <- solve(n - 1)
                y <- 1 to sz
                queen = (n, y)
                if (isSafe(queen, queens))
            } yield queen :: queens 
        }
        solve(sz).length
    }

    def main(args: Array[String]) {
        println(solveNSuperQueens(readInt))
    }
}
