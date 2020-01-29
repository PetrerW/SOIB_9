package ui

import model.FrequencyNet
import java.io.File

class NetPrinter {
    companion object {
        fun printFrequenciesWithSlots(net: FrequencyNet) {

            var minFrequency = net.frequencies.minBy { it.key }

            for (freq in net.frequencies.keys.sorted()) {
                var normalizedFrequency = 0
                if (minFrequency != null) {
                    //Subtracting min frequency and adding one to normalize them to start from one
                    normalizedFrequency = freq - minFrequency.key + 1
                }
                print("[" + normalizedFrequency + "]: " + net.frequencies.getValue(freq))

                if(net.inputFrequencies.contains(freq)){
                    println(" <-- input")
                }else
                    println()
            }
        }

        fun printInputFrequency(net: FrequencyNet) {
            var minFrequency = net.inputFrequencies.minBy { it }

            print("{")

            for (freq in net.inputFrequencies) {
                var normalizedFrequency: Int
                if (minFrequency != null) {
                    //Adding min frequency to normalize them to start from zero
                    normalizedFrequency = freq - minFrequency
                    print(" $normalizedFrequency ")
                }
            }

            println("}")

            println("Collisions: ${net.hasCollisions}")
        }

        fun writeSolutionToFile(net: FrequencyNet, upgrades: Int, iterations: Int, fileName: String){
            File(fileName).delete()

            var minFrequency = net.inputFrequencies.minBy { it }!!

            val file = File(fileName)

            file.writeText("collisions=${net.hasCollisions}\n")
            file.appendText("iterations=$iterations\n")
            file.appendText("upgrades=$upgrades\n")
            file.appendText("solution=")

            val solutionFrequencies = net.inputFrequencies.toTypedArray()
            for(i in 0..solutionFrequencies.size - 2 ){
                file.appendText("${solutionFrequencies[i] - minFrequency},")
            }
            file.appendText("${solutionFrequencies.last() - minFrequency}\n")
        }
    }
}