import java.util.*;
class Graph
{
	private int numVertices;
	private LinkedList<Integer> adjList[];
	Graph(int v)
	{
		numVertices = v;
		adjList = new LinkedList[v];
		for(int i = 0; i < v; i++)
			adjList[i] = new LinkedList<Integer>();
	}
	boolean addEdge(int source, int destination)
	{
		if(source >= 0 && destination >= 0 && source < numVertices && destination < numVertices)
		{
			adjList[source].add(destination);
			return true;
		}
		return false;
	}
	void dfsUtil(int source, boolean visited[])
	{
		Deque<Integer> q = new LinkedList<>();
		q.push(source);
		while(!q.isEmpty())
		{
			int curr = q.pop();
			if(visited[curr])
				continue;
			visited[curr] = true;
			System.out.print(curr + " ");
			ListIterator<Integer> i = adjList[curr].listIterator();
			while(i.hasNext())
				i.next();
			//We need to insert in reverse Order
			while(i.hasPrevious())
			{
				int index = i.previous();
				if(!visited[index])
					q.push(index);
			}
		}
	}
	void dfs(int source)
	{
		boolean visited[] = new boolean[numVertices];
		dfsUtil(source, visited);
		for(int i = 0; i < numVertices; i++)
		{
			if(!visited[i])
				dfsUtil(i, visited);
		}
	}
}
class Graph_1_DFS
{
	public static void main(String args[])
	{
		Graph g = new Graph(4);
 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        
        System.out.println("Depth First Traversal (starting from vertex 0)"); 
        g.dfs(0);
	}
}
