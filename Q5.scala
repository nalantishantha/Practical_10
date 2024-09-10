object LetterCountApp {
  def countLetterOccurrences(words: List[String]): Int = {
    // number of letters
    val wordLengths = words.map(word => word.length)

    // total count of letter occurrences
    val totalLetterCount = wordLengths.reduce((a, b) => a + b)

    totalLetterCount
  }

  def main(args: Array[String]): Unit = {
    val words = List("apple", "banana", "cherry", "date")
    val total = countLetterOccurrences(words)
    println(s"Total count of letter occurrences: $total")
  }
}
