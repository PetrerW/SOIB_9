package ui

import model.LinealSolver

class UserInterface {
    companion object{
        fun run(){

            val filename = "src/main/resources/parameters.txt";
            val inputParams =  InputFileReader.readParametersFromFile(filename)
            val inputFrequenciesNumber = inputParams["Input_frequencies_number"] ?: error("Error reading Input_frequencies_number")
            //Maximal number of iterations in the algorithm
            val maxIterations = inputParams["Max_iterations_number"] ?: error("Error reading Max_iterations_number")
            val maxWindowSize = inputParams["Max_window_size"] ?: error("Error reading Max_window_size")
            val maxUpgradesNumber = inputParams["Max_upgrades_number"] ?: error("Error reading Max_upgrades_number")


            if(inputFrequenciesNumber != null && maxIterations != null){
                val frequencyNet = LinealSolver.solve(maxUpgradesNumber, maxWindowSize, inputFrequenciesNumber, maxIterations)
                NetPrinter.printInputFrequency(frequencyNet)
                NetPrinter.printFrequenciesWithSlots(frequencyNet)
            }
            else
                println("Invalid input data: Input_frequencies_number = " + inputFrequenciesNumber +
                        "\nMax_iterations_number = " + maxIterations +
                        "\nMax_window_size = " + maxWindowSize +
                        "\nMax_upgrades_number = " + maxUpgradesNumber)
        }

//        fun printWithSlotsOccupance(maxIterations: Int){
//            val frequencyNet = LinealSolver.solve(maxIterations, )
//            var setCount = 1
//            for(net in frequencyNet){
//                println("Set number " + setCount + ": ")
//                NetPrinter.printFrequenciesWithSlots(net)
//                println()
//                setCount++
//            }
//        }

//        fun printOnlyFrequencies(maxIterations: Int){
//            val frequencyNet = LinealSolver.solve(maxIterations)
//            var setCount = 1
//            for(net in frequencyNet){
//                print("Set number " + setCount + ": ")
//                NetPrinter.printOnlyFreqiencies(net)
//                setCount++
//            }
//        }

//        fun printInputFrequencies(maxUpgrades: Int, maxWindowSize: Int, InputFreqsCount: Int, maxIterations: Int){
//            val frequencyNet = LinealSolver.solve(maxUpgrades, maxWindowSize, InputFreqsCount, maxIterations)
//            NetPrinter.printInputFrequency(frequencyNet)
//        }
    }
}