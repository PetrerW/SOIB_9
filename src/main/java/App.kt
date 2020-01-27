import model.LinealSolver
import ui.NetPrinter

object Application {
    var JAVA = "java"
    var KOTLIN = "kotlin"
    @JvmStatic
    fun main(args: Array<String>) {
//        printWithSlotsOccupance(10)
//        printOnlyFrequencies(3)
        printInputFrequencies(4)
    }

    fun printWithSlotsOccupance(howManyFreqs: Int){
        val frequencyNet = LinealSolver.solve(howManyFreqs)
        var setCount = 1
        for(net in frequencyNet){
            println("Set number " + setCount + ": ")
            NetPrinter.printFrequenciesWithSlots(net)
            println()
            setCount++
        }
    }

    fun printOnlyFrequencies(howManyFreqs: Int){
        val frequencyNet = LinealSolver.solve(howManyFreqs)
        var setCount = 1
        for(net in frequencyNet){
            print("Set number " + setCount + ": ")
            NetPrinter.printOnlyFreqiencies(net)
            setCount++
        }
    }

    fun printInputFrequencies(howManyFreqs: Int){
        val frequencyNet = LinealSolver.solve(howManyFreqs)
        var setCount = 1
        for(net in frequencyNet){
            print("Set number " + setCount + ": ")
            NetPrinter.printInputFreqiencies(net)
            setCount++
        }
    }
}