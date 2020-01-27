package ui

import java.io.File

class InputFileReader {
    companion object{
        fun readParametersFromFile(filename: String): Array<Int>{
            var inputFrequenciesNumber = 0
            var maxIterations = 0
            var maxWindowSize = 0
            var maxUpgrades = 0

            val lines = readFileAsLinesUsingReadLines(filename)
            for(line in lines){
                val splitArray = line.split('=').toTypedArray()
                if(splitArray[0] == "Input_frequencies_number"){
                    inputFrequenciesNumber = splitArray[1].toInt()
                }
                else if(splitArray[0] == "Max_iterations_number"){
                    maxIterations = splitArray[1].toInt()
                }
                else if(splitArray[0] == "Max_window_size"){
                    maxWindowSize = splitArray[1].toInt()
                }
                else if(splitArray[0] == "Max_upgrades_number"){
                    maxUpgrades = splitArray[1].toInt()
                }
            }

            return arrayOf(inputFrequenciesNumber, maxIterations, maxWindowSize, maxUpgrades)
        }

        fun readFileAsLinesUsingReadLines(fileName: String): List<String>
                = File(fileName).readLines()
    }
}