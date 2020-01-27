package model

class FrequencyNet(
        //First Int - number of frequency (carrier)
        //Second Int -
        // Number of signals occupying the carrier
        //1 - good
        //>1 - collision
        var frequencies: MutableMap<Int, Int>,
        var signalGroup: SignalGroup

){
    fun addSignalGroup(s: SignalGroup){
        if(frequencies.containsKey(s.fi))
            frequencies.replace(s.fi, frequencies.getValue(s.fi) + 1)
        else
            frequencies.put(s.fi, 1)
        if(frequencies.containsKey(s.fj))
            frequencies.replace(s.fj, frequencies.getValue(s.fj) + 1)
        else
            frequencies.put(s.fj, 1)
        if(frequencies.containsKey(s.fk))
            frequencies.replace(s.fk, frequencies.getValue(s.fk) + 1)
        else
            frequencies.put(s.fk, 1)

        this.signalGroup = s

        var products = s.findProducts()
        for(p in products){
            if(this.frequencies.containsKey(p)){
                frequencies.replace(p, frequencies.getValue(p) + 1)
            }
            else{
                frequencies.put(p, 1)
            }
        }
    }

    // On which positions there are any collisions?
    fun findCollisions(): ArrayList<Int>{
        var collisions = ArrayList<Int>(0)
        for(f in this.frequencies.keys){
            if (frequencies.getValue(f) > 1){
                collisions.add(f)
            }
        }
        return collisions
    }

    //True if there are any collisions
    fun checkCollisions(): Boolean{
        val collisions = findCollisions()
        return collisions.size > 0
    }
}