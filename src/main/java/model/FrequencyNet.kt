package model

class FrequencyNet(
        //Number of signals occupying the carrier
        //1 - good
        //>1 - collision
        var frequencies: ArrayList<Int>

){
    fun addSignalGroup(s: SignalGroup){
        frequencies[s.fi] += 1
        frequencies[s.fj] += 1
        frequencies[s.fk] += 1

        var products = s.getProducts {  }
        for(p in products){
            this.frequencies[p] += 1
        }
    }

    // On which positions there are collisions?
    fun findCollisions(): ArrayList<Int>{
        var collisions = ArrayList<Int>(0)
        for(f in this.frequencies){
            if (f > 1){
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