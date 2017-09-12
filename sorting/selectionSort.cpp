#include <iostream>
#include <vector>

using namespace std;

void insertionSort(vector<char>& A) {
    long size = A.size();

    for (int i = 0; i < size; i++) {
        char smallestElement = A[i];
        int indexSmallestElement = i;

        // identifies the smallest remaining unsorted element
        for (int j = i + 1; j < size; j++) {
            if (A[j] < smallestElement) {
                smallestElement = A[j];
                indexSmallestElement = j;
            }
        }

        // put the smallest remaining unsorted element in the end of hte sorted portion of the array
        swap(A[i], A[indexSmallestElement]);
    }
}

void insertionSortTester() {
    vector<char> A = {'s', 'e', 'l', 'e', 'c', 't', 'i', 'o', 'n', 's', 'o', 'r', 't'};
    vector<int> B = {1, 2, 3};

    for (char ch : A)
        cout << ch;
    cout << endl;

    insertionSort(A);

    for (char ch : A)
        cout << ch;
}
