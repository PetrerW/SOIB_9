package model

class LinealSolver {
    companion object{
        fun solve(maxIterations: Int): ArrayList<FrequencyNet>{
            var frequencyNets = ArrayList<FrequencyNet>()
            var count = 0

            //SignalGroups with non-repeated frequencies
            val allSignals = FreqGen.genFreqs(maxIterations)
            //Iterator over allSignals
            var signalIndex = 0

            var a: Int
            var b: Int
            var c: Int
            var d: Int
            var fi: Int
            var fj: Int
            var fk: Int

            while(count < maxIterations){
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

                            val map = mutableMapOf<Int, Int>()
                            val s = SignalGroup(fi, fj, fk)
                            val freqNet = FrequencyNet(map, s)

                            freqNet.addSignalGroup(s)
                            frequencyNets.add(freqNet)

                            count++
                        }
                    }
                }
                signalIndex++
            }
            return frequencyNets
        }
    }
}