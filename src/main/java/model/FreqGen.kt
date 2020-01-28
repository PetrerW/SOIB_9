package model

import sun.misc.Signal
import java.lang.Math.floor
import java.util.*
import kotlin.collections.ArrayList

// Generates non-repeated SignalGroup objects with non-repeated frequencies
// fi is assumed always to be 0
class FreqGen {
    companion object {

        // Generates all not-repeated combinations of
        fun genGroupsOf3Freqs(inputFreqs: ArrayList<Int>, maxWindowSize: Int): ArrayList<SignalGroup>{

            val inputFreqsNumber = inputFreqs.size
            val (newFrequency, indexToSwap) = findFreeFrequency(inputFreqs, maxWindowSize)
            inputFreqs[indexToSwap] = newFrequency
            inputFreqs.sort()

            var groups = ArrayList<SignalGroup>()

            for(i in 0..inputFreqs.lastIndex-2){
                val j = i + 1

                for(k in j+1..inputFreqs.lastIndex)
                    groups.add(SignalGroup(inputFreqs[i], inputFreqs[j], inputFreqs[k]))
            }

//            //-1 because index, -2 because we've got three numbers in a group
//            for(fi in inputFreqs[0]..inputFreqs[inputFreqsNumber-1-2]){
//
//                val fj = inputFreqs[inputFreqs.indexOf(fi) + 1]
//
//                for(fk in inputFreqs[inputFreqs.indexOf(fj) + 1]..inputFreqs.last()){
//                    groups.add(SignalGroup(fi, fj, fk))
//                }
//            }

            return groups
        }

        //Returns new frequency and index of the array to assign that new frequency to
        fun findFreeFrequency(freqs: ArrayList<Int>, maxWindowSize: Int): Pair<Int, Int>{
            var swapped = false
            //Get a random index
            var indexToSwap = (0 until freqs.lastIndex).shuffled(Random(1)).first()
            var newFreq = -1
            var seed: Long = 1

            while(!swapped){
                val first = freqs.first()
                when (indexToSwap) {
                    0 -> {
                        //Get new frequency at random taking into account max window size
                        newFreq = (first+1 until first+1+maxWindowSize).shuffled(Random(seed)).first()
                    }
                    freqs.lastIndex -> {
                        val last = freqs.last()

                        if(last < first + maxWindowSize){
//                            swapped = true
                            newFreq = (last until first+maxWindowSize).shuffled(Random(seed)).first()
                        }
                    }
                    else -> {
                        newFreq = ((freqs[indexToSwap]+1)..(first+maxWindowSize)).shuffled(Random(seed)).first()
                    }
                }

                //if newFreq is free
                if(!freqs.contains(newFreq)){
                    swapped = true
                }else{
                    //Get a random index and continue loop
                    indexToSwap = (0 until freqs.lastIndex).shuffled(Random(++seed)).first()
                    println("seed = $seed")
                }
            }
            return Pair(newFreq, indexToSwap)
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