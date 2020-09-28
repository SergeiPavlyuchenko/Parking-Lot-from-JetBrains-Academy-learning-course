import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    var notException = true
    while (notException) {
        val a = scanner.nextInt()
        val b = scanner.nextInt()
        val c = if (b != 0) {
            print(a / b)
            notException = false
        } else {
            print("Division by zero, please fix the second argument!")
            notException = false
        }
    }

}