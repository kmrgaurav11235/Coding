#include <iostream>
#include <map>

using namespace std;

int main()
{
	map <int, string> m1;
	cout << "Map Size = " << m1.size() << endl;
	
	m1[0] = "Game of Thrones";
	m1[2] = "Breaking Bad";
	m1[5] = "Pushing Daisies";
	m1[4] = "Downtown Abby";
	m1[9] = "Friends";
	m1[10] = "The Big Bang Theory";
	
	cout << "Map Size = " << m1.size() << endl;
	
	cout << "Map:\n";
	map <int, string>::iterator ii;
	for(ii = m1.begin(); ii != m1.end(); ii++)
	{
		cout << ii->first << " => " << ii->second << endl;
	}
	cout << "Erasing String " << m1[9] << " from the map.\n";
	m1.erase(9);
	
	cout << "New Map Size = " << m1.size() << endl;
	cout << "New Map:\n";
	for(ii = m1.begin(); ii != m1.end(); ii++)
	{
		cout << ii->first << " => " << ii->second << endl;
	}
	
	cout << "Clearing map.\n";
	m1.clear();
	cout << "New Map Size = " << m1.size() << endl;
	
	return 0;
}
