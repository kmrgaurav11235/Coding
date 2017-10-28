//Heap Sort Problem
#include<iostream>

using namespace std;

void swapNum(int & a, int & b)
{
    int temp = a;
    a = b;
    b = temp;
}

int parent(int indx)
{
    return ((indx - 1)/2);
}

int leftChild(int indx)
{
    return (2 * indx + 1);
}

int rightChild(int indx)
{
    return (2 * (indx + 1));
}

void restoreDown(int a[], int n, int i)
{
    //Heapify Procedure: Takes Log n time
    //n is size of heap. i is index of misplaced element
    int left = leftChild(i);
    int right = rightChild(i);
    int largest = i;

    if(left < n && a[left] > a[largest])
        largest = left;
    if(right < n && a[right] > a[largest])
        largest = right;

    if(i != largest)
    {
        swapNum(a[i], a[largest]);
        restoreDown(a, n, largest);
    }
}

void buildHeap(int a[], int n)
{
    int indx = n/2 - 1;
    for(int i = indx; i >= 0; i--)
        restoreDown(a, n, i);
}

void heapSort(int a[], int n)
{
    int heapSize = n;
    buildHeap(a, n);

    for(int i = 0; i < n; i++)
    {
        swapNum(a[n - i - 1], a[0]);
        restoreDown(a, n - i - 1, 0);
    }
}

int main()
{
	int n;
    cout << "Heap Sort Problem.\nEnter Total Number of Elements in the array." << endl;
    cin >> n;
    int a[n];
    cout << "\nEnter Array:\n";
    for (int i = 0; i < n; i++)
    {
        cout << "Array [" << i << "] = ";
        cin >> a[i];
    }

    heapSort(a, n);
	cout << "\nSorted Array:\n";
    for (int i = 0; i < n; i++)
    {
        cout << a[i] << " ";
    }
    cout << endl;
	return 0;
}
