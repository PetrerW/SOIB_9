package model

import sun.misc.Signal
import java.lang.Math.floor

// Generates non-repeated SignalGroup objects with non-repeated frequencies
// fi is assumed always to be 0
class FreqGen {
    companion object {

        fun genGroupsOf3Freqs(howManyFreqs: Int): ArrayList<SignalGroup>{

            var groups = ArrayList<SignalGroup>(howManyFreqs)

            for(fi in 1..howManyFreqs){
                for(fj in fi+1..(howManyFreqs)){
                    for(fk in fj+1..howManyFreqs){
                        //TODO Check if correct
                        val s = SignalGroup(fi, fj, fk)
                        groups.add(s)
                    }
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