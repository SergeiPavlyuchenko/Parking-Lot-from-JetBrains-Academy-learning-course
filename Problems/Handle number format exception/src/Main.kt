fun parseCardNumber(cardNumber: String): Long {
    var long = ""
    var count = 0
    for (i in cardNumber) {
        if (i.isWhitespace()) count++ else long += i
    }
    if (count != 3) throw Exception("Incorrect number of card")
    return if (long.lastIndex == 15) long.toLong() else 0
}