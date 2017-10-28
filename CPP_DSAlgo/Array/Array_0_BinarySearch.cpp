//Search in a sorted Array
#include <iostream>

using namespace std;


int binarySearch(int * array, int low, int high, int key)
{
	if(low > high)
		return -1;
	int mid = (low + high) / 2;
	if(array[mid] == key)
		return mid;
	else if (array[mid] > key)
		return binarySearch(array, low, mid - 1, key);
	else
		return binarySearch(array, mid + 1, high, key);
}

int main()
{
	int array[] = {2, 6, 6, 7, 9, 10};
	int key = 8;
	int index = binarySearch(array, 0, 5, key);
	
	if (index < 0)
		cout << "Element " << key << " not found in array.\n";
	else
		cout << "Element " << key << " found in array at index " << index << ".\n";
}
