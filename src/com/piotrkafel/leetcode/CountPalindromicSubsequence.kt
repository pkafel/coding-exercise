package com.piotrkafel.leetcode

class CountPalindromicSubsequence {
    fun countPalindromicSubsequence(s: String): Int {
        val candidates = mutableListOf<Pair<Int, Int>>()
        val firstLetter = mutableSetOf<Char>()
        val charArray = s.toCharArray()
        val result = mutableSetOf<String>()

        for(i in s.indices) {
            if(firstLetter.contains(s[i])) continue
            for(j in s.length - 1 downTo  i + 1) {
                if(s[i] == s[j] && i + 1 != j) {
                    firstLetter.add(s[i])
                    candidates.add(Pair(i,j))
                    break
                }
            }
        }

        candidates.forEach {
            val subString = charArray.slice(IntRange(it.first, it.second))
            for (letter in 1 .. subString.size - 2) {
                result.add("${subString[0]}${subString[letter]}${subString[0]}")
            }
        }
        return result.size
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(CountPalindromicSubsequence().countPalindromicSubsequence("bbcbaba"))
        }
    }
}