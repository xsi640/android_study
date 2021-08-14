package com.github.xsi640.databinding2

class StarUtils {
    companion object {
        @JvmStatic
        fun star(star: Int): String {
            return when (star) {
                1 -> "一星"
                2 -> "二星"
                3 -> "三星"
                4 -> "四星"
                else -> "五星"
            }
        }
    }
}