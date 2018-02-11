package au.com.wjensen

object Main {
  def main(args: Array[String]): Unit = {
    println("Hello world Scala JVM")

    println("Using shared library code: 2^2 = ...")
    val lib = new MyLibrary
    println(lib.sq(2))
  }
}
