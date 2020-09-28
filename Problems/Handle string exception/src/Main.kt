fun main() {
    val index = readLine()!!.toInt()
    val word = readLine()!!
    if (index > word.lastIndex || index < 0) {
        print("There isn't such an element in the given string, please fix the index!")
        return
    }
    println(word[index])
}