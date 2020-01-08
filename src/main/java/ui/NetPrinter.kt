package ui

import model.FrequencyNet

class NetPrinter {
    fun printFrequencies(net: FrequencyNet){
        println("Collisions: " + net.checkCollisions())
        for(freq in 0 until net.frequencies.size){
                println("[" + freq + "]: " + net.frequencies[freq])
        }
    }
}