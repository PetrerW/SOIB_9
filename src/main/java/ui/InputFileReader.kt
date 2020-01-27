package ui

import java.io.File

class InputFileReader {
    companion object{
        fun readParametersFromFile(filename: String): Array<Int>{
            var inputFrequenciesNumber = 0
            var maximalIterations = 0
            var maximalWindowSize = 0

            val lines = readFileAsLinesUsingReadLines(filename)
            for(line in lines){
                val splitArray = line.split('=').toTypedArray()
                if(splitArray[0] == "Input_frequencies"){
                    inputFrequenciesNumber = splitArray[1].toInt()
                }
                else if(splitArray[0] == "Maximum_iterations_number"){
                    maximalIterations = splitArray[1].toInt()
                }
                else if(splitArray[0] == "Maximal_window_size"){
                    maximalWindowSize = splitArray[1].toInt()
                }
            }

            return arrayOf(inputFrequenciesNumber, maximalIterations, maximalWindowSize)
        }

        fun readFileAsLinesUsingReadLines(fileName: String): List<String>
                = File(fileName).readLines()
    }
}