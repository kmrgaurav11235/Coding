#include <iostream>
#include <cstdlib>

using namespace std;

int rollDice()
{
	return ((rand() % 6) + 1);
}

int main()
{
	int firstDice, secondDice;
	do
	{
		firstDice = rollDice();
		secondDice = rollDice();
		cout << "First Dice: " << firstDice << ", Second Dice: " << secondDice << endl;
	}
	while(firstDice != 1 || secondDice != 1);
	return 0;
}
