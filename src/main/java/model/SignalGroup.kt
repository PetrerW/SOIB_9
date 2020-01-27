package model

//A group of three signals with their products
class SignalGroup(val fi: Int, val fj: Int, val fk: Int) {
    fun findProducts(): ArrayList<Int> {
        var products = ArrayList<Int>(4)
        products.add(0, fi + fj - fk)
        products.add(1, fi - fj + fk)
        products.add(2, -fi + fj + fk)
        products.add(3, fi + fj + fk)

        return products
    }
}

//package model
//
//class SignalGroup(val freqs: ArrayList<Int>) {
//    fun computeProducts(): ArrayList<Int> {
//
//        val N = freqs.size
//
//        for(product in products){
//            //TODO Take groups of 3 frequencies
//            //For each group compute products
//        }
//
//        products.add(0, fi + fj - fk)
//        products.add(1, fi - fj + fk)
//        products.add(2, -fi + fj + fk)
//        products.add(3, fi + fj + fk)
//
//        return products
//    }
//}