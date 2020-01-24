package ui

import model.FrequencyNet

class NetPrinter {
    companion object{
        fun printFrequencies(net: FrequencyNet){
            println("Collisions: " + net.checkCollisions())
            for(freq in net.frequencies.keys.sorted()){
                print("[" + freq + "]: " + net.frequencies.getValue(freq))
                if(freq == net.signalGroup.fi)
                    println(" <-- fi")
                else if (freq == net.signalGroup.fj)
                    println(" <-- fj ")
                else if (freq == net.signalGroup.fk)
                    println(" <-- fk ")
                else
                    println()
            }
        }
    }
}