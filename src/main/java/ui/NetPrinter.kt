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
                    //Adding min frequency to normalize them to start from zero
                    normalizedFrequency = freq - minFrequency.key
                }
                print("[" + normalizedFrequency + "]: " + net.frequencies.getValue(freq))

                when (freq) {
                    net.signalGroup.fi -> println(" <-- fi")
                    net.signalGroup.fj -> println(" <-- fj ")
                    net.signalGroup.fk -> println(" <-- fk ")
                    else -> println()
                }
            }
        }

        fun printOnlyFreqiencies(net: FrequencyNet) {
            var minFrequency = net.frequencies.minBy { it.key }

            print("{")

            for (freq in net.frequencies.keys.sorted()) {
                var normalizedFrequency = 0
                if (minFrequency != null) {
                    //Adding min frequency to normalize them to start from zero
                    normalizedFrequency = freq - minFrequency.key
                }

                print(" " + normalizedFrequency)

                when (freq) {
                    net.signalGroup.fi -> print("(fi)")
                    net.signalGroup.fj -> print("(fj)")
                    net.signalGroup.fk -> print("(fk)")
                }

                print(" ")
            }

            println("}")
        }

        fun printInputFreqiencies(net: FrequencyNet) {
            var minFrequency = net.frequencies.minBy { it.key }

            print("{")

            for (freq in net.frequencies.keys.sorted()) {
                var normalizedFrequency = 0
                if (minFrequency != null) {
                    //Adding min frequency to normalize them to start from zero
                    normalizedFrequency = freq - minFrequency.key
                }

                when (freq) {
                    net.signalGroup.fi, net.signalGroup.fj, net.signalGroup.fk -> print(" " + normalizedFrequency + " ")
                }
            }

            println("}")
        }
    }
}