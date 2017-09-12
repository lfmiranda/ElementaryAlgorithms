#include <iostream>
#include <vector>

using namespace std;

void insertionSort(vector<int>& A) {
    long size = A.size();

    /* We start with a single element and then we incrementally insert the remaining elements so that the list stays
    sorted. */
    for (int i = 1; i < size; ++i) {
        int j = i;

        while ((j > 0) && (A[j - 1] > A[j])) {
            swap(A[j - 1], A[j]);
            j--;
        }
    }
}

void insertionSortTester() {
    vector<int> A = {154, 245, 568, 324, 654, 324};

    insertionSort(A);

    for (int i : A) {
        cout << i << " ";
    }
}
