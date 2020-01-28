package model

class LinealSolver {
    companion object{
        fun solve(maxUpgrades: Int, maxWindowSize: Int, InputFreqsCount: Int, maxIterations: Int): FrequencyNet{
            //Starting population
            var startInputFrequencies = ArrayList<Int>(InputFreqsCount)
            for(i in 1..InputFreqsCount){
                startInputFrequencies.add(i)
            }

            var upgrades = 0
            var iterations = 0

            //SignalGroups with non-repeated frequencies
            var allSignals = FreqGen.genGroupsOf3Freqs(startInputFrequencies, maxWindowSize)

            //Return variable initialized
            var bestFreqNet = FrequencyNet(allSignals)

            //Changed with each iteration
            var freqNet = bestFreqNet

           while(upgrades < maxUpgrades && iterations < maxIterations){
//               && isBetter(freqNet, bestFreqNet)
               if (!freqNet.hasCollisions){
                   bestFreqNet = freqNet
                   upgrades++
               }

               val inputFreqs = toArrayList(freqNet.inputFrequencies.toTypedArray())

               allSignals = FreqGen.genGroupsOf3Freqs(inputFreqs, maxWindowSize)
               freqNet = FrequencyNet(allSignals)

               iterations++
           }
            print("iterations: $iterations")

            if(iterations == maxIterations)
                println(" (max)")
            else
                println()

            if(upgrades != 0){
                print("swaps: $upgrades")

                if(upgrades == maxUpgrades)
                    println(" (max)")
                else
                    println()
            }

            return bestFreqNet
        }

        fun isBetter(new: FrequencyNet, old: FrequencyNet): Boolean{
            return new.findLongestWindow() < old.findLongestWindow()
        }

        fun toArrayList(array: Array<Int>):ArrayList<Int>{
            val arrayList = ArrayList<Int>(array.size)

            for(i in array){
                arrayList.add(i)
            }

            return arrayList
        }

    }
}