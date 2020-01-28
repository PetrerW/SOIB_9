package model

class FrequencyNet(
        //First Int - number of frequency (carrier)
        //Second Int -
        // Number of signals occupying the carrier
        //1 - good
        //>1 - collision
        var frequencies: MutableMap<Int, Int>,
        var signalGroups: ArrayList<SignalGroup>,
        var inputFrequencies: MutableSet<Int>,
        var collisions: ArrayList<Int>,
        var hasCollisions: Boolean

){
    fun addSignalGroup(s: SignalGroup){
        if(frequencies.containsKey(s.fi)){
            //            frequencies.replace(s.fi, frequencies.getValue(s.fi) + 1)
            inputFrequencies.add(s.fi)
        }
        else{
            frequencies[s.fi] = 1
            inputFrequencies.add(s.fi)
        }

        if(frequencies.containsKey(s.fj)){
            //            frequencies.replace(s.fj, frequencies.getValue(s.fj) + 1)
            inputFrequencies.add(s.fj)
        }
        else{
            frequencies[s.fj] = 1
            inputFrequencies.add(s.fj)
        }

        if(frequencies.containsKey(s.fk)){
            //            frequencies.replace(s.fk, frequencies.getValue(s.fk) + 1)
            inputFrequencies.add(s.fk)
        }
        else{
            frequencies[s.fk] = 1
            inputFrequencies.add(s.fk)
        }

        this.signalGroups.add(s)

        var products = s.findProducts()
        for(p in products){
            if(this.frequencies.containsKey(p)){
                frequencies.replace(p, frequencies.getValue(p) + 1)
            }
            else{
                frequencies[p] = 1
            }
        }
    }

    fun addSignalGroups(signalgroups: ArrayList<SignalGroup>){
//        this.signalGroups = signalgroups
        for(s in signalgroups){
            this.addSignalGroup(s)
        }
    }

    // On which positions there are any collisions?
    fun findCollisions(): ArrayList<Int>{
        var collisions = ArrayList<Int>(0)
        for(f in this.inputFrequencies){
            if (frequencies.getValue(f) > 1){
                collisions.add(f)
            }
        }
        return collisions
    }

    //True if there are any collisions
    fun checkCollisions(): Boolean{
//        val collisions = findCollisions()
        return this.collisions.size > 0
    }

    fun findLongestWindow(): Int{
        return if(inputFrequencies.isNotEmpty()){
            val max = inputFrequencies.maxBy { it }!!
            val min = inputFrequencies.minBy { it }!!
            max - min
        }else
            0
    }

    constructor(signalgroups: ArrayList<SignalGroup>): this(mutableMapOf(), arrayListOf(),
            mutableSetOf<Int>(), arrayListOf(), false){
        this.addSignalGroups(signalgroups)
        this.collisions = findCollisions()
        this.hasCollisions = checkCollisions()
    }
}