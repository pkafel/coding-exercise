package com.piotrkafel.leetcode

class RankTransformOfAnArray {
    fun arrayRankTransform(arr: IntArray): IntArray {
        val forSorting = arr.copyOf()
        forSorting.sort()

        val mapValueToIndex = forSorting.toSet().withIndex().associateBy({ it.value }, { it.index })

        return arr.map { mapValueToIndex.getValue(it) }.toIntArray()
    }
}