import model.LinealSolver
import ui.NetPrinter

object Application {
    var JAVA = "java"
    var KOTLIN = "kotlin"
    @JvmStatic
    fun main(args: Array<String>) {
        val frequencyNet = LinealSolver.solve(1000)
        var setCount = 1
        for(net in frequencyNet){
            println("Set number " + setCount + ": ")
            NetPrinter.printFrequencies(net)
            println()
            setCount++
        }
    }
}