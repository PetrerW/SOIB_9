package model

import sun.misc.Signal
import java.lang.Math.floor

// Generates non-repeated SignalGroup objects with non-repeated frequencies
// fi is assumed always to be 0
class FreqGen {
    companion object {

        // Generates all not-repeated combinations of
        fun genGroupsOf3Freqs(inputFreqsNumber: Int, oldInputFreqs: ArrayList<Int>): ArrayList<SignalGroup>{

            var groups = ArrayList<SignalGroup>(inputFreqsNumber)

            for(fi in 1 until inputFreqsNumber-2){
                val fj = fi + 1
                for(fk in 1 until inputFreqsNumber){
                    groups.add(SignalGroup(fi, fj, fk))
                }
            }

            return groups
        }

        fun genFreqs(howManyFreqs: Int): ArrayList<SignalGroup> {
            //Array with triple
            var Freqs = ArrayList<SignalGroup>(howManyFreqs)
            var count = 0
            //sum = fj + fk
            //3 in the beginning (3 = 0 + 1 + 2)
            var sum = 3.0

            //Constant value of fi. Incrementing complicates problem and the whole net starting with fi=0
            // could be shifted instead
            val fi = 0
            var fj: Int
            var fk: Int

            while (count < howManyFreqs) {
                val fjmax = floor((sum - 1) / 2).toInt()
                for (fj in 1..fjmax) {
                    fk = sum.toInt() - fj
                    Freqs.add(SignalGroup(fi, fj, fk))
                    count++
                    sum++
                    if (count >= howManyFreqs)
                        break
                }
            }
            return Freqs
        }
    }
}