#include <iostream>
#include <climits>

using namespace std;

int MaxCrossingSubArray(int * a, int low, int mid, int high, int * low_cross, int * high_cross)
{
	int max_left = INT_MIN;
	int sum_left = 0;
	int indx_left = mid;
	
	for (int i = mid; i >= low; i--)
	{
		sum_left = sum_left + a[i];
		if (sum_left > max_left)
		{
			max_left = sum_left;
			indx_left = i;
		}
	}
	
	int max_right = INT_MIN;
	int sum_right = 0;
	int indx_right = mid + 1;
	
	for (int i = mid + 1; i <= high; i++)
	{
		sum_right = sum_right + a[i];
		if (sum_right > max_right)
		{
			max_right = sum_right;
			indx_right = i;
		}
	}
	
	*low_cross = indx_left;
	*high_cross = indx_right;
	return (max_left + max_right);
}

int MaxContiguousSubArray(int * a, int low, int high, int *left_indx, int *right_indx)
{
    if (low == high)
	{
		*left_indx = low;
		*right_indx = low;
		return a[low];
	}
	int mid = (low + high)/2;
	
	int low_left, high_left, sum_left;
	sum_left = MaxContiguousSubArray(a, low, mid, &low_left, &high_left);
    //cout << "\nMax Left Values: Low = " << low_left << "\nHigh = " << high_left << "\nSum = " << sum_left << endl;
	
	int low_right, high_right, sum_right;
	sum_right = MaxContiguousSubArray(a, mid+1, high, &low_right, &high_right);
    //cout << "\nMax Right Values: Low = " << low_right << "\nHigh = " << high_right << "\nSum = " << sum_right << endl;
	
	int low_cross, high_cross, sum_cross;
    sum_cross = MaxCrossingSubArray(a, low, mid, high, &low_cross, &high_cross);
    //cout << "\nMax Crossing Values: Low = " << low_cross << "\nHigh = " << high_cross << "\nSum = " << sum_cross << endl;
    
    if(sum_left >= sum_right && sum_left >= sum_cross)
    {
    	*left_indx = low_left;
    	*right_indx = high_left;
    	return sum_left;
    }
    else if (sum_right >= sum_left && sum_right >= sum_cross)
	{
		*left_indx = low_right;
		*right_indx = high_right;
		return sum_right;
	}
	else
	{
		*left_indx = low_cross;
		*right_indx = high_cross;
		return sum_cross;
	}
}

int main()
{
    int n;
    cout << "Maximum contiguous SubArray Problem.\nEnter Total Number of Elements in the array." << endl;
    cin >> n;
    int a[n];
    cout << "\nEnter Array";
    for (int i = 0; i < n; i++)
    {
        cout << "\nArray [" << i << "] = ";
        cin >> a[i];
    }
    
    int left, right, sum;
	sum = MaxContiguousSubArray(a, 0, (n-1), &left, &right);
	cout << "\nMaximum contiguous SubArray:\n";
	for (int i = left; i <= right; i++)
	{
		cout << a[i] << " ";
	}
	cout << "\nSum = " << sum << endl;
    
    return 0;
}

