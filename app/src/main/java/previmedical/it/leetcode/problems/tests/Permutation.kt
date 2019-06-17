package previmedical.it.leetcode.problems.tests

import android.util.Log


class Permutation {

    fun permutations(s: String) {
        this.permutations(s, "")
    }

    private fun permutations(s: String, prefix: String) {
        if (s.isEmpty()) {
            Log.w("TEST", prefix)
        }
        else {
            s.forEachIndexed { index, c ->
                val rem = s.substring(0, index) + s.substring(index + 1)
                this.permutations(rem, prefix + s[index])
            }
        }
    }

    fun test() {
        this.permutations("ciao")
    }
}
