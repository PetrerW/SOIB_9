package ui

import java.io.File

class InputFileReader {
    companion object{
        fun readParametersFromFile(filename: String): Array<Int>{
            var inputFrequenciesNumber = 0
            var maximalIterations = 0

            val lines = readFileAsLinesUsingReadLines(filename)
            for(line in lines){
                if(line.split('=').toTypedArray()[0] == "Input frequencies"){
                    inputFrequenciesNumber = line[3].toInt()
                }
                else if(line.split('=').toTypedArray()[0] == "Maximum iterations number"){
                    maximalIterations = line[3].toInt()
                }
            }

            return arrayOf(inputFrequenciesNumber, maximalIterations)
        }

        fun readFileAsLinesUsingReadLines(fileName: String): List<String>
                = File(fileName).readLines()
    }
}