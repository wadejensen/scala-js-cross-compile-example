package au.com.wjensen

import scala.scalajs.js.JSApp

object Main  extends JSApp {
  def main(): Unit = {
    println("Hello world scala.js")

    println("Using shared library code: 2^2 = ...")
    val lib = new MyLibrary
    println(lib.sq(2))
  }
}
