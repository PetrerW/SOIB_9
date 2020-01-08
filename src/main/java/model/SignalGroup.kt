package model

class SignalGroup(val fi: Int, val fj: Int, val fk: Int) {
    fun getProducts(function: () -> Unit): ArrayList<Int> {
        var freqs = ArrayList<Int>(4)
        freqs[0] = fi + fj - fk
        freqs[1] = fi - fj + fk
        freqs[2] = -fi + fj + fk
        freqs[3] = fi + fj + fk

        return freqs
    }
}