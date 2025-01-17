package com.piotrkafel.leetcode

class StringMatching {

    fun stringMatching(words: Array<String>): List<String> {
        val result = mutableListOf<String>()
        for(i in words.indices) {
            val potentialSubstring = words[i]
            for(j in words.indices) {
                val word = words[j]
                if(potentialSubstring.length > word.length || i == j) continue

                if(word.contains(potentialSubstring)) {
                    result.add(potentialSubstring)
                    break
                }
            }
        }
        return result
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(StringMatching().stringMatching(arrayOf("mass","as","hero","superhero")))
        }
    }
}