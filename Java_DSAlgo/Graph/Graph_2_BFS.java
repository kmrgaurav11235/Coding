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
	void bfsUtil(int source, boolean visited[])
	{
		Queue<Integer> q = new LinkedList<>();
		q.offer(source);
		while(!q.isEmpty())
		{
			int curr = q.poll();
			if(visited[curr])
				continue;
			visited[curr] = true;
			System.out.print(curr + " ");
			Iterator<Integer> i = adjList[curr].iterator();
			while(i.hasNext())
			{
				int index = (i.next();
				if(!visited[index])
					q.offer(index);
			}
		}
	}
	void bfs(int source)
	{
		boolean visited[] = new boolean[numVertices];
		bfsUtil(source, visited);
		for(int i = 0; i < numVertices; i++)
		{
			if(!visited[i])
				bfsUtil(i, visited);
		}
	}
}
class Graph_2_BFS
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
        
        System.out.println("Breadth First Traversal (starting from vertex 2)"); 
        g.bfs(2);
	}
}

