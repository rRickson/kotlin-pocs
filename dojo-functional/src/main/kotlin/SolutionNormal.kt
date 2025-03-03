package com.github.rrickson.kotlinpocs

class SolutionNormal {
    fun maxPoints(points: Array<IntArray>): Int {
        if (points.size == 1) return 1
        var result = 0
        for (i in points.indices) {
            val map = mutableMapOf<Pair<Int, Int>, Int>()
            var maxPointsOnLine = 0
            for (j in i + 1 until points.size) {
                val dx = points[j][0] - points[i][0]
                val dy = points[j][1] - points[i][1]
                val gcd = gcd(dy, dx)
                val slope = Pair(dy / gcd, dx / gcd)
                map[slope] = (map[slope] ?: 1) + 1
                maxPointsOnLine = maxOf(maxPointsOnLine, map[slope]!!)
            }
            result = maxOf(result, maxPointsOnLine)
        }
        return result
    }

    fun gcd(a: Int, b: Int): Int {
        if (b == 0) return a
        return gcd(b, a % b)
    }
}