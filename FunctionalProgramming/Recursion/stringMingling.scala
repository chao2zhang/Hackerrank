object Solution {

    def main(args: Array[String]) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution
*/
        (1 to readInt()).foreach{ 
            e => println(readLine().grouped(2).toList.foldLeft(new StringBuilder())((x, y) => y.reverse.addString(x)))
        }
    }
}