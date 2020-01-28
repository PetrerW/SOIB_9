package ui

import java.io.File

class InputFileReader {
    companion object{
        fun readParametersFromFile(filename: String): Map<String, Int>{
            var inputFrequenciesNumber = 0
            var maxIterations = 0
            var maxWindowSize = 0
            var maxUpgrades = 0

            val lines = readFileAsLinesUsingReadLines(filename)

            var paramsMap = mutableMapOf<String, Int>()
            for(line in lines){
                val splitArray = line.split('=').toTypedArray()
                when {
                    splitArray[0] == "Input_frequencies_number" -> {
                        inputFrequenciesNumber = splitArray[1].toInt()
                        paramsMap["Input_frequencies_number"] = inputFrequenciesNumber
                    }
                    splitArray[0] == "Max_iterations_number" -> {
                        maxIterations = splitArray[1].toInt()
                        paramsMap["Max_iterations_number"] = maxIterations
                    }
                    splitArray[0] == "Max_window_size" -> {
                        maxWindowSize = splitArray[1].toInt()
                        paramsMap["Max_window_size"] = maxWindowSize
                    }
                    splitArray[0] == "Max_upgrades_number" -> {
                        maxUpgrades = splitArray[1].toInt()
                        paramsMap["Max_upgrades_number"] = maxUpgrades
                    }
                }
            }

            return paramsMap.toMap()
        }

        private fun readFileAsLinesUsingReadLines(fileName: String): List<String>
                = File(fileName).readLines()
    }
}