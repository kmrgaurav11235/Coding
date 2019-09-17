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
	void addEdge(int source, int dest)
	{
		adjList[source].add(dest);
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
	private boolean isCyclePresentUtil(int source, boolean isVisited[], boolean recursionStack[])
	{
		// Incorrect? First we need to check if this vertex is in recursionStack.
		if(isVisited[source])
			return false;
		isVisited[source] = true;
		recursionStack[source] = true;
		
		Iterator<Integer> it = adjList[source].iterator();
		while(it.hasNext())
		{
			int i = it.next();
			if(!isVisited[i])
			{
				if(isCyclePresentUtil(i, isVisited, recursionStack))
					return true;
			}
			else if(recursionStack[i])
				return true;
		}
		
		recursionStack[source] = false;
		return false;
	}
	boolean isCyclePresent()
	{
		/*
		 * Depth First Traversal can be used to detect cycle in a Graph. 
		 * There is a cycle in a graph only if there is a back edge present in the graph. A back edge is an edge that is from a node to 
		 * itself (selfloop) or one of its ancestor in the tree produced by DFS.
		 */
		 boolean isVisited[] = new boolean[numVertices];
		 boolean recursionStack[] = new boolean[numVertices];
		 for(int i = 0; i < numVertices; i++)
		 {
			 if(!isVisited[i])
			 {
				 if(isCyclePresentUtil(i, isVisited, recursionStack))
					return true;
			 }
		 }
		 return false;
	}
}
class Graph_3_DetectCycleDirectedGraph
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
        
        System.out.println("Graph:\n" + g); 
        System.out.println("Is cycle present in this Graph: " + g.isCyclePresent());
	}
}
