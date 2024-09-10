object Q2{

  case class Rational(numerator: Int, denominator: Int) {
  
    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
    private val g = gcd(numerator, denominator)
    val num: Int = numerator / g
    val den: Int = denominator / g

    def -(that: Rational): Rational = {
      val newNum = this.num * that.den - this.den * that.num
      val newDen = this.den * that.den
      Rational(newNum, newDen).simplify()
    }

    def simplify(): Rational = {
      val commonDivisor = gcd(num, den)
      Rational(num / commonDivisor, den / commonDivisor)
    }

    override def toString: String = s"$num/$den"
  }

  def main(args: Array[String]): Unit = {
    val x = Rational(3, 4)    
    val y = Rational(4, 5)    
    val z = Rational(2, 9)   

    val result = y - z

    println(s"Result of y - z: $result")
    println(s"Final expression x + (y - z): ${x - result}")
  }
}
