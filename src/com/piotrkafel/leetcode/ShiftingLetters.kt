package com.piotrkafel.leetcode

class ShiftingLetters {

    private val lowerBoundary: Char = Char(97)

    private val upperBoundary: Char = Char(122)

    fun shiftingLetters(s: String, shifts: Array<IntArray>): String {
        val input = s.toCharArray()
        for(config in shifts) {
            for(index in config[0] .. config[1]) {
                if(config[2] == 0) {
                    input[index] = input[index].dec()

                    if(input[index] < lowerBoundary) input[index] = upperBoundary
                } else {
                    input[index] = input[index].inc()

                    if(input[index] > upperBoundary) input[index] = lowerBoundary
                }
            }
        }
        return input.concatToString()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(ShiftingLetters().shiftingLetters(
                "abc", arrayOf(intArrayOf(0,1,0), intArrayOf(1,2,1), intArrayOf(0,2,1)))
            )
        }
    }
}