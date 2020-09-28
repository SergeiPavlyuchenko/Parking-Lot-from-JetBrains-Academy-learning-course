import kotlin.math.roundToInt

/*
fun main() {
    val rooms = readLine()!!.toInt()
    var price = readLine()!!.toInt()
        price = when {
           price < 0 -> 0
           price > 1_000_000 -> 1_000_000
        else -> price
    }



    // val house = House(rooms, price)

    val house = when {
        rooms <= 0 -> Cabin(rooms, price)
        rooms in 2..3 -> Bungalow(rooms, price)
        rooms == 4 -> Cottage(rooms, price)
        rooms in 5..7 -> Mansion(rooms, price)
        else -> Palace(rooms, price)
    }

    val totalPrice = price * house.coefficient
    println(totalPrice.toInt())
}

open class House(val rooms: Int, val price: Int, val coefficient: Double) { }

class Cabin(rooms: Int, price: Int, coefficient: Double = 1.0) : House(rooms, price, coefficient)

class Bungalow(rooms: Int, price: Int, coefficient: Double = 1.2) : House(rooms, price, coefficient)

class Cottage(rooms: Int, price: Int, coefficient: Double = 1.25) : House(rooms, price, coefficient)

class Mansion(rooms: Int, price: Int, coefficient: Double = 1.4) : House(rooms, price, coefficient)

class Palace(rooms: Int, price: Int, coefficient: Double = 1.6) : House(rooms, price, coefficient)*/


fun main() {
    val leatherCase = LeatherCase(190, "brown")
    val softCase = SoftCase(120, "yellow")
    val woodCase = WoodCase(230, "orange")
    println(getCaseTax(leatherCase) + getCaseTax(softCase) + getCaseTax(woodCase))
}

open class Case(val cost: Int) {
    fun getFullInfo(): String = "$$cost cost" + getTax()

    open fun getTax(): Int = (cost * 0.25).roundToInt()
}

open class SoftCase(cost: Int, val color: String) : Case(cost) {
    override fun getTax(): Int = super.getTax() + 100
}

open class WoodCase(cost: Int, val color: String) : Case(cost)

open class LeatherCase(cost: Int, color: String) : SoftCase(cost, color) {
    override fun getTax(): Int = (cost * 0.35).roundToInt()
}

fun getCaseTax(case: Case): Int = case.getTax()