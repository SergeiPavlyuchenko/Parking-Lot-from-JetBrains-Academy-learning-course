package parking

import java.util.*

data class Spot(var number: String = "none", var color: String = "none", var status: String = "free")

open class Create(val size: Int) {
    fun create(): Parking {
        println("Created a parking lot with $size spots.")
        return Parking(size)
    }
}

class Parking(size: Int): Create(size) {
    var spotsArray: Array<Spot> = Array(size) { Spot() }

    fun park (number: String, color: String) {
       for (i in spotsArray.indices) {
            if (spotsArray[i].status == "free") {
                spotsArray[i].number = number
                spotsArray[i].color = color.toUpperCase()
                spotsArray[i].status = "occupied"
                println("$color car parked in spot ${i + 1}.")
                return
            }
       }
        println("Sorry, the parking lot is full.")
    }
/////
    fun leave (spot: Int) {
        for (i in spotsArray.indices) {
            if (i  == spot - 1) {
                if (spotsArray[i].status != "free") {
                    spotsArray[i].number = "none"
                    spotsArray[i].color = "none"
                    spotsArray[i].status = "free"
                    println("Spot $spot is free.")
                } else println("There is no car in spot $spot.")
            }
        }
    }
////
   fun status() {
    var isFree = true
    for (i in spotsArray.indices) {
        if (spotsArray[i].status != "free") {
            println("${i + 1} ${spotsArray[i].number} ${spotsArray[i].color}")
            isFree = false
        }
    }
    if(isFree) println("Parking lot is empty.")
}

    fun regByColor(color: String) {
        var rbcOutput = ""
        for (i in 0 until size) {
            if (color.toUpperCase() == spotsArray[i].color)
                rbcOutput += "${spotsArray[i].number}, "
    }
        println(if (rbcOutput.isEmpty()) "No cars with color $color were found." else rbcOutput.substring(0,rbcOutput.lastIndex - 1))
    }

    fun spotByColor(color: String) {
        var sbcOutput = ""
        for (i in 0 until size) {
            if (color.toUpperCase() == spotsArray[i].color)
                sbcOutput += "${i + 1}, "
        }
        println(if (sbcOutput.isEmpty()) "No cars with color $color were found." else sbcOutput.substring(0,sbcOutput.lastIndex - 1))
    }

    fun spotByReg(number: String) {
        var sbrOutput = ""
        for (i in 0 until size) {
            if (number == spotsArray[i].number)
                sbrOutput += "${i + 1}"
        }
        println(if (sbrOutput.isEmpty()) "No cars with registration number $number were found." else sbrOutput)
    }


}




fun main() {
    val scanner = Scanner(System.`in`)
    var parking = Parking(0)
    val notCreate = "Sorry, a parking lot has not been created."
    while (scanner.hasNext()) {
        when (scanner.next()) {
            "create" -> parking = Create(scanner.nextInt()).create()
            "status" -> if(parking.spotsArray.isEmpty()) println(notCreate) else parking.status()
            "leave" -> if(parking.spotsArray.isEmpty()) println(notCreate) else parking.leave(scanner.nextInt())
            "park" -> if(parking.spotsArray.isEmpty()) println(notCreate) else parking.park(scanner.next(), scanner.next())
            "reg_by_color" -> if(parking.spotsArray.isEmpty()) println(notCreate) else parking.regByColor(scanner.next())
            "spot_by_color" -> if(parking.spotsArray.isEmpty()) println(notCreate) else parking.spotByColor(scanner.next())
            "spot_by_reg" -> if(parking.spotsArray.isEmpty()) println(notCreate) else parking.spotByReg(scanner.next())
            "exit" -> return
        }
    }
}