package ui

import model.FrequencyNet

class NetPrinter {
    companion object {
        fun printFrequenciesWithSlots(net: FrequencyNet) {
            println("Collisions: " + net.checkCollisions())

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
//
//        fun printOnlyFreqiencies(net: FrequencyNet) {
//            var minFrequency = net.frequencies.minBy { it.key }
//
//            print("{")
//
//            for (freq in net.frequencies.keys.sorted()) {
//                var normalizedFrequency = 0
//                if (minFrequency != null) {
//                    //Adding min frequency to normalize them to start from zero
//                    normalizedFrequency = freq - minFrequency.key
//                }
//
//                print(" " + normalizedFrequency)
//
//                when (freq) {
//                    net.signalGroup.fi -> print("(fi)")
//                    net.signalGroup.fj -> print("(fj)")
//                    net.signalGroup.fk -> print("(fk)")
//                }
//
//                print(" ")
//            }
//
//            println("}")
//        }

        fun printInputFrequency(net: FrequencyNet) {
            var minFrequency = net.inputFrequencies.minBy { it }

            print("{")

            for (freq in net.inputFrequencies) {
                var normalizedFrequency = 0
                if (minFrequency != null) {
                    //Adding min frequency to normalize them to start from zero
                    normalizedFrequency = freq - minFrequency + 1
                    print(" $normalizedFrequency ")
                }

//                when (freq) {
//                    net.signalGroup.fi, net.signalGroup.fj, net.signalGroup.fk -> print(" " + normalizedFrequency + " ")
//                }
            }

            println("}")
        }
    }
}