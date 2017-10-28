#include <iostream>
#include <cstring>

using namespace std;

class MyString
{
	private:
		char ch[100];
	public:
		MyString(char c[] = "")
		{
			strcpy(ch, c);
		}
		bool operator<(const MyString & m)
		{
			if(strcmp(ch, m.ch) < 0)
				return true;
			return false;
		}
		bool operator<=(const MyString & m)
		{
			if(strcmp(ch, m.ch) <= 0)
				return true;
			return false;
		}
		bool operator==(const MyString & m)
		{
			if(strcmp(ch, m.ch) == 0)
				return true;
			return false;
		}
		bool operator>(const MyString & m)
		{
			if(strcmp(ch, m.ch) > 0)
				return true;
			return false;
		}
		bool operator>=(const MyString & m)
		{
			if(strcmp(ch, m.ch) >= 0)
				return true;
			return false;
		}
		friend ostream & operator << (ostream & o, MyString & m);
};

ostream & operator << (ostream & o, MyString & m)
{
	o << m.ch;
	return o;
}

template <class T>
void mySwap(T & a, T & b)
{
	T c;
	c = a;
	a = b;
	b = c;
}

template <class T>
void display(T a[], int n)
{
	for(int i = 0; i < n; i++)
		cout << a[i] << " ";
	cout << endl;
}

template <class T>
int partition(T a[], int low, int high)
{
	int l = low + 1, r = high;
	T pivot = a[low];
	while(l <= r)
	{
		while(l < high && a[l] < pivot)
			l++;
		while(a[r] > pivot)
			r--;
		if(l < r)
		{
			mySwap(a[l], a[r]);
			l++; r--;
		}
		else
			l++;
	}
	swap(a[low], a[r]);
	return r;
}

template <class T>
void quickSort(T a[], int low, int high)
{
	if(low < high)
	{
		int pivot = partition(a, low, high);
		quickSort(a, low, pivot - 1);
		quickSort(a, pivot + 1, high);
	}
}

int main()
{
	int a[] = {0, 11, 44, 19, -4};
	int na = 5;
	cout << "Initial Array:" << endl;
	display(a, na);
	quickSort(a, 0, na - 1);
	cout << "After Quick Sort:" << endl;
	display(a, na);	
	
	MyString str[] = {"earth", "wind", "lighting", "air", "water"};
	int nStr = 5;
	cout << "Initial Array:" << endl;
	display(str, nStr);
	quickSort(str, 0, nStr - 1);
	cout << "After Quick Sort:" << endl;
	display(str, nStr);
	
	return 0;
}


