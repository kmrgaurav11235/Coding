#include<iostream>

using namespace std;

int partition(int * a, int low, int high)
{
	int pivot, i, j, temp;
	pivot = a[low];
	i = low + 1;
	j = high;
	
	while (i <= j)
	{
		//We stop when i passes j
		while ((a[i] < pivot) && (i <= high))
			i++;
		while (a[j] > pivot)
			j--;
		if (i < j)
		{
			//exchange a[i] and a[j]
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}
		else
			i++;
	}
	//pivot's place is j. putting it there
	a[low] = a[j];
	a[j] = pivot;
	return j;
}

void QuickSort(int * a, int low, int high)
{
	if(low >= high)
		return;
	int pivot = partition(a, low, high);
	QuickSort(a, low, pivot-1);
	QuickSort(a, pivot+1, high);
}

int main()
{
	int n;
    cout << "Quick Sort Problem.\nEnter Total Number of Elements in the array." << endl;
    cin >> n;
    int a[n];
    cout << "\nEnter Array:\n";
    for (int i = 0; i < n; i++)
    {
        cout << "Array [" << i << "] = ";
        cin >> a[i];
    }
    
    QuickSort(a, 0, (n-1));
	cout << "\nSorted Array:\n";
    for (int i = 0; i < n; i++)
    {
        cout << a[i] << " ";
    }
    cout << endl;
	return 0;
}
