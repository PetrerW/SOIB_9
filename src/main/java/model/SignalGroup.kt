package model

class SignalGroup(val fi: Int, val fj: Int, val fk: Int) {
    fun getProducts(): ArrayList<Int> {
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
//    fun getProducts(N: Int): ArrayList<Int> {
//
//        //For N inputs there are N+1 products
//        //TODO: Check if correctly (Ada)
//        var products = ArrayList<Int>(N+1)
//
//        for(product in 1..N+1){
//            for(freq in 1..N){
//                var freqWithSign = freq
//                if(freq == product){
//
//                }
//            }
//        }
//        products.add(0, fi + fj - fk)
//        products.add(1, fi - fj + fk)
//        products.add(2, -fi + fj + fk)
//        products.add(3, fi + fj + fk)
//
//        return products
//    }
//}