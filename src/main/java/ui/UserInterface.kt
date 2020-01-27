package ui

import model.LinealSolver

class UserInterface {
    companion object{
        fun run(){

            val filename = "src/resources/parameters.txt";
            val inputParams =  InputFileReader.readParametersFromFile(filename)
            val inputFrequenciesNumber = inputParams[0]
            //Maximal number of iterations in the algorithm
            val maxIterations = inputParams[1]


            if(inputFrequenciesNumber != null && maxIterations != null)
                printInputFrequencies(maxIterations)
            else
                println("Invalid input data: Number of input frequencies = " + inputFrequenciesNumber +
                        "Maximal iterations in the algorithm = " + maxIterations)
        }

        fun printWithSlotsOccupance(maxIterations: Int){
            val frequencyNet = LinealSolver.solve(maxIterations, )
            var setCount = 1
            for(net in frequencyNet){
                println("Set number " + setCount + ": ")
                NetPrinter.printFrequenciesWithSlots(net)
                println()
                setCount++
            }
        }

        fun printOnlyFrequencies(maxIterations: Int){
            val frequencyNet = LinealSolver.solve(maxIterations)
            var setCount = 1
            for(net in frequencyNet){
                print("Set number " + setCount + ": ")
                NetPrinter.printOnlyFreqiencies(net)
                setCount++
            }
        }

        fun printInputFrequencies(maxIterations: Int){
            val frequencyNet = LinealSolver.solve(maxIterations)
            var setCount = 1
            for(net in frequencyNet){
                print("Set number " + setCount + ": ")
                NetPrinter.printInputFreqiencies(net)
                setCount++
            }
        }
    }
}