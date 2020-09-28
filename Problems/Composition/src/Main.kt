class OperatingSystem() {
    var name = readLine()!!
}

class DualBoot() {
    var primaryOs = OperatingSystem()
    var secondaryOs = OperatingSystem()
}

fun main() {
    print(DualBoot().primaryOs.name)
}