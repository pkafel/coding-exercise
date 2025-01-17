package com.piotrkafel.leetcode

import kotlin.math.abs

class MinOperations {

    fun minOperations(boxes: String): IntArray {
        val indexesOfBoxesWithBall = findAllIndexesIf('1', boxes)

        val result = IntArray(boxes.length)
        for(i in boxes.indices) {
            var numberOfMoves = 0
            for(index in indexesOfBoxesWithBall) {
                numberOfMoves += abs(i - index)
            }
            result[i] = numberOfMoves
        }
        return result
    }

    private fun findAllIndexesIf(c: Char, text: String): List<Int> {
        val result = mutableListOf<Int>()
        for(i in text.indices) {
            if(text[i] == '1') {
                result.add(i)
            }
        }
        return result
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(MinOperations().minOperations("001011").toList())
        }
    }
}