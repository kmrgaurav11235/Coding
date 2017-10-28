//Dijkstra’s shortest path algorithm
#include <iostream>
#include <climits>

#define MAX 9

using namespace std;

int dijkstra(int adj[][MAX], int n, int source, int dest, int pred[], int distFromSource[], bool isPerm[])
{
	int i;
	
	for(i = 0; i < n; i++)
	{
		pred[i] = -1;
		isPerm[i] = false;
		distFromSource[i] = INT_MAX;
	}
	
	distFromSource[source] = 0;
	
	while(!isPerm[dest])
	{
		int minIndex = -1;
		int minVal = INT_MAX;
		
		for(i = 0; i < n; i++)
		{
			if((!isPerm[i]) && (distFromSource[i] < minVal))
			{
				minVal = distFromSource[i];
				minIndex = i;
			}
		}
		
		if(minIndex == -1)
			break;
		
		isPerm[minIndex] = true;
		for(i = 0; i < n; i++)
		{
			if((!isPerm[i]) && (adj[minIndex][i] != 0) && (distFromSource[i] > (adj[minIndex][i] + distFromSource[minIndex])))
			{
				distFromSource[i] = adj[minIndex][i] + distFromSource[minIndex];
				pred[i] = minIndex;
			}
		}
	}//end of while
	
	return distFromSource[dest];
}

int main()
{
    int n = MAX;
    int i;

    //Initializattion
    int adj[MAX][MAX] = {{0, 4, 0, 0, 0, 0, 0, 8, 0},
                      {4, 0, 8, 0, 0, 0, 0, 11, 0},
                      {0, 8, 0, 7, 0, 4, 0, 0, 2},
                      {0, 0, 7, 0, 9, 14, 0, 0, 0},
                      {0, 0, 0, 9, 0, 10, 0, 0, 0},
                      {0, 0, 4, 14, 10, 0, 2, 0, 0},
                      {0, 0, 0, 0, 0, 2, 0, 1, 6},
                      {8, 11, 0, 0, 0, 0, 1, 0, 7},
                      {0, 0, 2, 0, 0, 0, 6, 7, 0}
                     };
	int source = 0;
	int dest = 4;
	int pred[MAX];
	int distFromSource[MAX];
	bool isPerm[MAX];
	
    int totalPathLength = dijkstra(adj, n, source, dest, pred, distFromSource, isPerm);
    
    cout << "Shortest Path from Node " << source << " to Node " << dest << " = " << totalPathLength << ". \nPredecessor Array:\n";
    for(i = 0; i < n; i++)
		if(isPerm[i])
		cout << "Node " << i << " -> " << pred[i] << endl;
		
	cout << "\nDistance from Source:\n";
	for(i = 0; i < n; i++)
	{
		if(isPerm[i])
			cout << "Node " << i << " : " << distFromSource[i] << endl;
		else
			cout << "Node " << i << " : Value not calculated." << endl;
	}

    return 0;
}

