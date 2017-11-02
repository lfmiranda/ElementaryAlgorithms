/*
 * - Algorithm:
 * Mergesort
 *
 * - Algorithm description:
 * Divide the n-element sequence to be sorted into two subsequences of n/2 elements each. Then sort the two subsequences
 * recursively using merge sort and merge the two sorted subsequences to produce the sorted answer.
 * Input: A sequence of n numbers <a1, a2, ..., an>.
 * Output: A permutation <a'1, a'2, ..., a'n> of the input sequence such that a'1 <= a'2 <= ... <= a'n.
 */

mergeSortTester();

function mergeSortTester() {
    let A = [5, 2, 4, 7, 1, 3, 2, 6];

    console.log(A.toString());
    mergeSort(A, 0, A.length - 1);
    console.log(A.toString());
}

// Sorts an array using the Mergesort algorithm.
function mergeSort(A, left, right) {
    if (left >= right)
        return;

    let middle = Math.floor((left + right) / 2);

    mergeSort(A, left, middle);
    mergeSort(A, middle + 1, right);
    merge(A, left, middle, right);
}

// Sorts the elements in a specific range of an array.
function merge(A, left, middle, right) {
    let leftHalf = A.slice(left, middle + 1);
    let rightHalf = A.slice(middle + 1, right + 1);

    /* Adds a sentinel at the end of each array to avoid having to check whether either array was fully copied in each
    basic step. */
    leftHalf.push(Infinity);
    rightHalf.push(Infinity);

    let leftIndex = 0;
    let rightIndex = 0;

    /* Merges the newly created arrays (which are sorted). At each iteration, the smallest element among the first
    elements of each array is copied over the original array, sorting the original array a whole. */
    for (let i = left; i <= right; i++) {
        if (leftHalf[leftIndex] <= rightHalf[rightIndex]) {
            A[i] = leftHalf[leftIndex];
            leftIndex++;
        } else {
            A[i] = rightHalf[rightIndex];
            rightIndex++;
        }
    }
}
