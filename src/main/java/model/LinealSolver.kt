package model

import oracle.jrockit.jfr.events.Bits.intValue
import sun.misc.Signal
import sun.security.krb5.Confounder.intValue

class LinealSolver {
    companion object{
        fun solve(maxUpgrades: Int, maxWindowSize: Int, InputFreqsCount: Int, maxIterations: Int): FrequencyNet{
            //Starting population
            var startInputFrequencies = ArrayList<Int>(InputFreqsCount)
            for(i in 1..InputFreqsCount){
                startInputFrequencies.add(2*i-1)
            }

            var upgrades = 0
            var iterations = 0

            //SignalGroups with non-repeated frequencies
            var allSignals = FreqGen.genGroupsOf3Freqs(startInputFrequencies, maxWindowSize)

            //Return variable initialized
            var bestFreqNet = FrequencyNet(allSignals)

            //Changed with each iteration
            var freqNet = bestFreqNet

            var a: Int
            var b: Int
            var c: Int
            var d: Int
            var fi: Int
            var fj: Int
            var fk: Int

           while(upgrades < maxUpgrades && iterations < maxIterations){
               if (!freqNet.hasCollisions && isBetter(freqNet, bestFreqNet)){
                   bestFreqNet = freqNet
                   upgrades++
               }

               val inputFreqsArray = freqNet.inputFrequencies.toTypedArray()
               var nextInputFreqs = ArrayList<Int>(inputFreqsArray.size)

               for(i in inputFreqsArray){
                   nextInputFreqs.add(i)
               }

               allSignals = FreqGen.genGroupsOf3Freqs(nextInputFreqs, maxWindowSize)
               freqNet = FrequencyNet(allSignals)

               iterations++
           }
            return bestFreqNet
        }

        fun isBetter(new: FrequencyNet, old: FrequencyNet): Boolean{
            return new.findLongestWindow() < old.findLongestWindow()
        }

//        fun solve1(maxUpgrades: Int, maxWindowSize: Int): FrequencyNet{
//            var upgrades = 0
//
//            //SignalGroups with non-repeated frequencies
//            val allSignals = FreqGen.genFreqs(maxUpgrades)
//            //Iterator over allSignals
//            var bestSignalGroup = SignalGroup(0,0,0)
//            //Return variable
//            var bestFreqNet = FrequencyNet(arrayListOf(bestSignalGroup))
//
//            var a: Int
//            var b: Int
//            var c: Int
//            var d: Int
//            var fi: Int
//            var fj: Int
//            var fk: Int
//
//            for((signalIndex, signal) in allSignals.withIndex()){
//                fi = allSignals[signalIndex].fi
//                fj = allSignals[signalIndex].fj
//                fk = allSignals[signalIndex].fk
//
//                a = fi + fj - fk
//                //FreqGen has provided that fj != fk and fi != fk
//                if(a != fk){
//                    b = fi - fj + fk
//                    if(b != fj) {
//                        c = -fj + fj + fk
//                        if(c != fi){
//                            d = fi + fj + fk
//
////                            //TODO: Check every signal group in the loop
////                            val signalGroup = SignalGroup(fi, fj, fk)
////                            val signalGroups = arrayListOf<SignalGroup>(signalGroup)
////                            var freqNet = FrequencyNet(signalGroups)
////
////                            if(!freqNet.checkCollisions() && isBetter(bestSignalGroup, signalGroup)){
////                                bestSignalGroup = signalGroup
////                                bestFreqNet = freqNet
////
////                                upgrades++
////
////                                if(upgrades > maxIterations)
////                                    break
////                            }
//                        }
//                    }
//                }
//            }
//            return bestFreqNet
//        }
    }
}