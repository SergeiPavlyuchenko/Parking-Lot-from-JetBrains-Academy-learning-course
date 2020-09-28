/*
import java.util.*

class Application(val name: String) {

    fun run(str1: String, str2: String, str3: String) {
        println(this.name)
      */
/*  for (i in stringArray.indices) {
            print(stringArray[i])
            if (i != stringArray.lastIndex) println()
        }*//*

        println(str1)
        println(str2)
        print(str3)
    }
}

*/
/*
fun main() {
    Application("TN").run()
}
*/


open class Vehicle(val name: String, val wheelsNum: Int = 0)

open class Car(name: String, wheelsNum: Int, val spareWheelsNum: Int = 0)
 : Vehicle(name, wheelsNum)

open class Truck(name: String, wheelsNum: Int, spareWheelsNum: Int, val type: String)
 : Car(name, wheelsNum, spareWheelsNum)

fun wheelsNum(vehicle: Vehicle): Int {
    return if (vehicle.wheelsNum < 0) 0 else vehicle.wheelsNum
}

fun totalWheelsNum(car: Car): Int {
    return car.wheelsNum + car.spareWheelsNum
}

fun spareWheelsNum(car: Car): Int {
    return totalWheelsNum(car) - wheelsNum(car)
}

fun main() {
    val car = Car("Edison", 4, 2)
    val truck = Truck("Riebhell", 8, 2, "Heavy")
    println(spareWheelsNum(car) + spareWheelsNum(truck))
    print(car.spareWheelsNum + truck.spareWheelsNum)
}
