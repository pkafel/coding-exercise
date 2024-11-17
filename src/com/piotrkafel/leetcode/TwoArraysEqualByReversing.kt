package com.piotrkafel.leetcode

class TwoArraysEqualByReversing {
    fun canBeEqual(target: IntArray, arr: IntArray): Boolean {
        if(target.size != arr.size) return false
        target.sort()
        arr.sort()
        return target.contentEquals(arr)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(TwoArraysEqualByReversing().canBeEqual(intArrayOf(1,2,3,4), intArrayOf(2,4,1,3)))
        }
    }
}