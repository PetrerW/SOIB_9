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