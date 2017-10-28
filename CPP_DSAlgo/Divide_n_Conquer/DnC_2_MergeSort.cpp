#include <iostream>
#include <climits>

using namespace std;

void Merge(int * a, int low1, int high1, int low2, int high2)
{
	int n = high2 - low1 + 1;
	int i, j, k;
	int temp[n];
	for (i = low1, j = low2, k = 0; ((i <= high1) && (j <= high2)); k++)
	{
		if(a[i] <= a[j])
		{
			temp[k] = a[i];
			i++;
		}
		else
		{
			temp[k] = a[j];
			j++;
		}
	}
	while(i <= high1)
	{
		temp[k] = a[i];
		i++;
		k++;
	}
	while(j <= high2)
	{
		temp[k] = a[j];
		j++;
		k++;
	}
	for (i = low1, k = 0; k < n; i++, k++)
	{
		a[i] = temp[k];
	}
}

void Merge_Sort(int * a, int low, int high)
{
	if (low == high)
	return;
	int mid = (low + high)/2;
	Merge_Sort(a, low, mid);
	Merge_Sort(a, mid+1, high);
	Merge(a, low, mid, mid+1, high);
}

int main()
{
    int n;
    cout << "Merge Sort Problem.\nEnter Total Number of Elements in the array." << endl;
    cin >> n;
    int a[n];
    cout << "\nEnter Array:\n";
    for (int i = 0; i < n; i++)
    {
        cout << "Array [" << i << "] = ";
        cin >> a[i];
    }
    
    Merge_Sort(a, 0, (n-1));
	cout << "\nSorted Arrary:\n";
    for (int i = 0; i < n; i++)
    {
        cout << a[i] << " ";
    }
    cout << endl;
    return 0;
}
