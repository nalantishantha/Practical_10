import scala.io.StdIn.readLine

object Q1 {
  def main(args: Array[String]): Unit = {
    println("Enter a rational number:")
    print("Numerator: ")
    val numerator = readLine().toInt
    print("Denominator: ")
    val denominator = readLine().toInt

    val x = new Rational(numerator, denominator)
    println(s"x = $x")
    println(s"x.neg = ${x.neg}")
  }
}

class Rational(n: Int, d: Int) {
   require(d != 0, "Denominator must not be zero")

   private val g = gcd(n.abs, d.abs)
   val numer: Int = n / g
   val denom: Int = d / g

   def neg: Rational = new Rational(-numer, denom)

   override def toString: String = s"$numer/$denom"

   private def gcd(a: Int, b: Int): Int =
    if b==0 then a.abs else gcd(b, a%b)
}