package model

import sun.misc.Signal

class LinealSolver {
    companion object{
        fun solve(maxUpgrades: Int, maxWindowSize: Int, InputFreqsCount: Int, maxIterations: Int): FrequencyNet{
            //Starting population
            var startInputFrequencies = arrayListOf<Int>()
            for(i in 1..InputFreqsCount){
                startInputFrequencies.add(i)
            }

            //Iterator over allSignals
            var bestSignalGroup = SignalGroup(0,0,0)

            //Return variable
            var bestFreqNet = FrequencyNet(arrayListOf(bestSignalGroup))

            var upgrades = 0
            var iterations = 0

            //SignalGroups with non-repeated frequencies
            val allSignals = FreqGen.genGroupsOf3Freqs(InputFreqsCount, startInputFrequencies)

            var a: Int
            var b: Int
            var c: Int
            var d: Int
            var fi: Int
            var fj: Int
            var fk: Int

           while(upgrades < maxUpgrades && iterations < maxIterations){

               for(signal in allSignals){
                   fi = signal.fi
                   fj = signal.fj
                   fk = signal.fk

                   a = fi + fj - fk
                   //FreqGen has provided that fj != fk and fi != fk
                   if(a != fk){
                       b = fi - fj + fk
                       if(b != fj) {
                           c = -fj + fj + fk
                           if(c != fi){
                               d = fi + fj + fk

                            //TODO: Check every signal group in the loop
                            val signalGroup = SignalGroup(fi, fj, fk)
                            val signalGroups = arrayListOf<SignalGroup>(signalGroup)
                            var freqNet = FrequencyNet(signalGroups)

                            if(!freqNet.checkCollisions() && isBetter(bestSignalGroup, signalGroup)){
                                bestSignalGroup = signalGroup
                                bestFreqNet = freqNet

                                upgrades++

                                if(upgrades > maxIterations)
                                    break
                            }
                           }
                       }
                   }
               }

               iterations++
           }

        }

        fun solve1(maxUpgrades: Int, maxWindowSize: Int): FrequencyNet{
            var upgrades = 0

            //SignalGroups with non-repeated frequencies
            val allSignals = FreqGen.genFreqs(maxUpgrades)
            //Iterator over allSignals
            var bestSignalGroup = SignalGroup(0,0,0)
            //Return variable
            var bestFreqNet = FrequencyNet(arrayListOf(bestSignalGroup))

            var a: Int
            var b: Int
            var c: Int
            var d: Int
            var fi: Int
            var fj: Int
            var fk: Int

            for((signalIndex, signal) in allSignals.withIndex()){
                fi = allSignals[signalIndex].fi
                fj = allSignals[signalIndex].fj
                fk = allSignals[signalIndex].fk

                a = fi + fj - fk
                //FreqGen has provided that fj != fk and fi != fk
                if(a != fk){
                    b = fi - fj + fk
                    if(b != fj) {
                        c = -fj + fj + fk
                        if(c != fi){
                            d = fi + fj + fk

//                            //TODO: Check every signal group in the loop
//                            val signalGroup = SignalGroup(fi, fj, fk)
//                            val signalGroups = arrayListOf<SignalGroup>(signalGroup)
//                            var freqNet = FrequencyNet(signalGroups)
//
//                            if(!freqNet.checkCollisions() && isBetter(bestSignalGroup, signalGroup)){
//                                bestSignalGroup = signalGroup
//                                bestFreqNet = freqNet
//
//                                upgrades++
//
//                                if(upgrades > maxIterations)
//                                    break
//                            }
                        }
                    }
                }
            }
            return bestFreqNet
        }

        fun isBetter(new: SignalGroup, old: SignalGroup): Boolean{
            return true
        }


    }
}