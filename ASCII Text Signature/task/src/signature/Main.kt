package signature
import java.io.File
import java.util.*


fun main() {
    val scanner = Scanner(System.`in`)
    print("Enter name and surname: ")
    val inputName = scanner.nextLine()
    print("Enter person's status: ")
    val inputStatus = scanner.nextLine()


    val nameRowLength = name(inputName).split("\n")[0].length
    val statusRowLength = status(inputStatus).split("\n")[0].length

    val maxLengthOfRow = if (nameRowLength > statusRowLength) {
        nameRowLength
    } else {
        statusRowLength
    }

    if (maxLengthOfRow == nameRowLength) {
        repeat(maxLengthOfRow + 8) { print("8") }
        println()
        for (i in 0..9) {
            print("88  ${name(inputName).lines()[i]}  88\n")
        }
        for (i in 0..2) {
            print("88")
            print(spaces(maxLengthOfRow, statusRowLength, nameRowLength,"left"))
            print(status(inputStatus).lines()[i])
            print(spaces(maxLengthOfRow, statusRowLength, nameRowLength,"right"))
            print("88\n")
        }
        repeat(maxLengthOfRow + 8) { print("8") }
    } else {
        repeat(maxLengthOfRow + 8) { print("8") }
        println()
        for (i in 0..9) {
            print("88")
            print(spaces(maxLengthOfRow, statusRowLength, nameRowLength, "left"))
            print(name(inputName).lines()[i])
            print(spaces(maxLengthOfRow, statusRowLength, nameRowLength, "right"))
            print("88\n")
        }
        for (i in 0..2) {
            print("88  ${status(inputStatus).lines()[i]} 88\n")
        }
        repeat(maxLengthOfRow + 8) { print("8") }
    }
}


fun name(inputName: String): String {
    val roman = File("D:/temp/roman.txt").readLines()
    var outputName = ""
    for (rowIndex in 1..10) {
        loop@ for (nameIndex in inputName.indices) {
            for (romanIndex in roman.indices) {
                when (inputName[nameIndex]) {
                    ' ' -> {
                        outputName += "          "
                        continue@loop
                    }
                    roman[romanIndex].first() -> if (roman[romanIndex][1] == ' ') outputName += roman[romanIndex + rowIndex]
                }
            }
        }
        outputName += '\n'
    }
    return (outputName)
}

fun status(inputStatus: String ): String {
    val medium = File("D:/temp/medium.txt").readLines()
    var outputStatus = ""
    for (rowIndex in 1..3) {
        loop@ for (nameIndex in inputStatus.indices) {
            for (romanIndex in medium.indices) {
                when (inputStatus[nameIndex]) {
                    ' ' -> {
                        outputStatus += "     "
                        continue@loop
                    }
                    medium[romanIndex].first() -> if (medium[romanIndex][1] == ' ') outputStatus += medium[romanIndex + rowIndex]
                }
            }
        }
        outputStatus += '\n'
    }
    return (outputStatus)
}


fun spaces(maxLengthOfRow: Int, statusRowLength: Int,nameRowLength: Int, side: String): String {
    val middleOfRow = (maxLengthOfRow + 4 - if (maxLengthOfRow != statusRowLength) statusRowLength else nameRowLength) / 2
    var leftSpace = ""
    var rightSpace = ""
    for (i in 0 until middleOfRow) {
        leftSpace += " "
    }
    rightSpace = if((maxLengthOfRow + 4 - if (maxLengthOfRow != statusRowLength) statusRowLength else nameRowLength) % 2 != 0) {
        "$leftSpace "
    } else {
        leftSpace
    }
    return if (side == "left") (leftSpace) else (rightSpace)
}


