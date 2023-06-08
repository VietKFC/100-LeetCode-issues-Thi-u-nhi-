fun main(args: Array<String>) {
    println(longestCommonPrefix(arrayOf("abca", "aba", "aaab")))
}

fun romanToInt(s: String): Int {
    /**
     * Done
     * URL: https://leetcode.com/problems/roman-to-integer/
     */
    val romanMaps = hashMapOf("I" to 1, "V" to 5, "X" to 10, "L" to 50, "C" to 100, "D" to 500, "M" to 1000)
    var sum = 0;
    s.forEachIndexed { index, char ->
        if (index < s.length - 1) {
            if (romanMaps[char.toString()]!! >= romanMaps[s[index + 1].toString()]!!) {
                sum += romanMaps[char.toString()]!!
            } else {
                sum -= romanMaps[char.toString()]!!
            }
        } else {
            sum += romanMaps[char.toString()]!!
        }
    }
    return sum
}

fun containsDuplicate(nums: IntArray): Boolean {
    /**
     * Time out
     * URL: https://leetcode.com/problems/contains-duplicate/
     */
    val mutableNums = nums.toMutableList()
    var count = 0
    while (mutableNums.isNotEmpty()) {
        mutableNums.removeAll(listOf(mutableNums.first()))
        count++
    }
    return count < nums.size
}

fun isPalindrome(x: Int): Boolean {
    /**
     * Done
     * URL: https://leetcode.com/problems/palindrome-number/
     */
    if (x < 0) return false
    val chars = x.toString().toCharArray()
    val reversedString = chars.reversed().joinToString(separator = "")
    if (reversedString == x.toString()) return true
    return false
}

fun longestCommonPrefix(strs: Array<String>): String {
    /**
     * Done
     * URL: https://leetcode.com/problems/longest-common-prefix/
     */
    val mutableStrs = strs.toMutableList()
    val firstStr = strs[0]
    mutableStrs.removeAt(0)
    var trackingStr = ""
    var result = ""
    firstStr.forEach lit@{ char ->
        trackingStr += char
        if (mutableStrs.firstOrNull {
                !it.contains(trackingStr) || it.contains(trackingStr) && it.substring(
                    0,
                    trackingStr.length
                ) != trackingStr
            } != null) {
            trackingStr = ""
            return result.ifEmpty { "" }
        } else if (trackingStr.length > result.length) {
            result = trackingStr
        }
    }
    return result.ifEmpty { "" }
}