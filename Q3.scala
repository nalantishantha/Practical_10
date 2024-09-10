import scala.io.StdIn._

class Account(var balance: Double) {

  // Deposit function 
  def deposit(amount: Double): Unit = {
    if (amount > 0) {
      balance += amount
      println(s"Deposited $amount. New balance is $balance.")
    } else {
      println("Deposit amount must be positive.")
    }
  }

  // Withdraw function 
  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
      println(s"Withdrew $amount. New balance is $balance.")
    } else {
      println("Insufficient balance or invalid amount.")
    }
  }

  // Transfer function 
  def transfer(toAccount: Account, amount: Double): Unit = {
    if (amount > 0 && amount <= balance) {
      this.withdraw(amount)
      toAccount.deposit(amount)
      println(s"Transferred $amount to the other account.")
    } else {
      println("Transfer failed due to insufficient funds or invalid amount.")
    }
  }

  // Display balance
  def getBalance(): Unit = {
    println(s"Current balance: $balance")
  }
}

object BankApp {
      def main(args: Array[String]): Unit = {
        val account1 = new Account(1000)
        val account2 = new Account(500)

        var continue = true

        while (continue) {
            println("\nChoose an operation: 1) Deposit 2) Withdraw 3) Transfer 4) Check Balance")
            val choice = readLine().toInt

            choice match {
            case 1 =>
                println("Enter deposit amount for account1:")
                val depositAmount = readLine().toDouble
                account1.deposit(depositAmount)

            case 2 =>
                println("Enter withdrawal amount for account1:")
                val withdrawAmount = readLine().toDouble
                account1.withdraw(withdrawAmount)

            case 3 =>
                println("Enter transfer amount from account1 to account2:")
                val transferAmount = readLine().toDouble
                account1.transfer(account2, transferAmount)

            case 4 =>
                account1.getBalance()
                account2.getBalance()

            case _ =>
                println("Invalid option. Please choose a valid operation.")
            }

            // Asking user if they want to perform another operation
            print("Do you want to perform another operation? (yes/no)")
            val response = readLine().toLowerCase
            if (response != "yes") {
            continue = false
            }
        }

        println("Thank you for using the banking system!")
      }
}
