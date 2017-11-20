/*
 * - Algorithm:
 * The maximum-subarray problem (divide and conquer version)
 *
 * - Algorithm description:
 * Input: An array with n numbers <a1, a2, ..., an>.
 * Output: A tuple containing the indices that demarcate the subarray whose sum of elements is the biggest, along with
 * the sum of the values in it.
 */

package arrays

fun main(args: Array<String>) {
    val elements: IntArray = intArrayOf(13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7)
    print(findMaximumSubarray(A = elements, left = 0, right = elements.size - 1))
}

fun findMaximumSubarray(A: IntArray, left: Int, right: Int) : Triple<Int, Int, Int> {
    if (left == right)
        return Triple(left, left, A[left])

    val middle = (left + right) / 2

    // find maximum subarrays within the let and right subarrays
    val maxSubarrayLeft = findMaximumSubarray(A, left, middle)
    val maxSubarrayRight = findMaximumSubarray(A, middle + 1, right)

    // finds a maximum subarray that crosses the midpoint
    val maxSubarrayCrossing = findMaxCrossingSubarray(A, left, middle, right)


    // finds out the biggest subarray found so far
    if (maxSubarrayLeft.third > maxSubarrayRight.third && maxSubarrayLeft.third > maxSubarrayCrossing.third)
        return maxSubarrayLeft

    if (maxSubarrayRight.third > maxSubarrayLeft.third && maxSubarrayRight.third > maxSubarrayCrossing.third)
        return maxSubarrayLeft

    return maxSubarrayCrossing
}

fun findMaxCrossingSubarray(A: IntArray, left: Int, middle: Int, right: Int) : Triple<Int, Int, Int> {
    var leftSum = Int.MIN_VALUE
    var sum = 0
    var maxLeft = 0

    for (i in middle downTo left) {
        sum += A[i]

        if (sum > leftSum) {
            leftSum = sum
            maxLeft = i
        }
    }

    var rightSum = Int.MIN_VALUE
    sum = 0
    var maxRight = 0

    for (i in (middle + 1) .. right) {
        sum += A[i]

        if (sum > rightSum) {
            rightSum = sum
            maxRight = i
        }
    }

    return Triple(maxLeft, maxRight , leftSum + rightSum)
}
