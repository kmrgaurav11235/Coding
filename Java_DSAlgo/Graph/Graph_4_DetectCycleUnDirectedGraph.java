import java.util.*;
class UndirectedGraph
{
	private int numVertices;
	private LinkedList<Integer> adjList[];
	UndirectedGraph(int v)
	{
		numVertices = v;
		adjList = new LinkedList[v];
		for(int i = 0; i < v; i++)
			adjList[i] = new LinkedList<Integer>();
	}
	void addEdge(int vertex1, int vertex2)
	{
		adjList[vertex1].add(vertex2);
		adjList[vertex2].add(vertex1);
	}
	@Override
	public String toString()
	{
		String str = "";
		for(int i = 0; i < numVertices; i++)
		{
			str = str + i;
			Iterator ii = adjList[i].iterator();
			while(ii.hasNext())
			{
				str = str + " -> " + String.valueOf(ii.next());
			}
			str = str + "\n";
		}
		return str;
	}
	private boolean isCyclePresentUtil(int source, boolean isVisited[], int parent)
	{
		if(isVisited[source])
			return false;
		isVisited[source] = true;
		
		Iterator<Integer> it = adjList[source].iterator();
		while(it.hasNext())
		{
			int i = it.next();
			if(!isVisited[i])
			{
				if(isCyclePresentUtil(i, isVisited, source))
					return true;
			}
			//isVisited[i] is implicit here
			else if(i != parent)
				return true;
		}
		
		return false;
	}
	boolean isCyclePresent()
	{
		/*
		 * Depth First Traversal can be used to detect cycle in a UnDirected Graph too. 
		 * We don't need to store the recursion stack though.
		 * For every visited vertex ‘v’, if there is an adjacent ‘u’ such that u is already visited and u is not parent of v, 
		 * then there is a cycle in graph.
		 */
		 boolean isVisited[] = new boolean[numVertices];
		 for(int i = 0; i < numVertices; i++)
		 {
			 if(!isVisited[i])
			 {
				 if(isCyclePresentUtil(i, isVisited, -1))
					return true;
			 }
		 }
		 return false;
	}
}
class Graph_4_DetectCycleUnDirectedGraph
{
	public static void main(String args[])
	{
		UndirectedGraph g1 = new UndirectedGraph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 0);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        
        System.out.println("Graph:\n" + g1); 
        System.out.println("Is cycle present in this Graph: " + g1.isCyclePresent());
        
        UndirectedGraph g2 = new UndirectedGraph(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        
        System.out.println("Graph:\n" + g2); 
        System.out.println("Is cycle present in this Graph: " + g2.isCyclePresent());
	}
}
