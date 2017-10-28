/*
 * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge uv, 
 * vertex u comes before v in the ordering. 
 * Topological Sorting for a graph is not possible if the graph is not a DAG. 
 * There can be more than one topological sorting for a graph.
 */
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
	void topologicalSortUtil(int v, boolean isVisited[], Deque<Integer> dq)
	{
		if(isVisited[v])
			return;
		isVisited[v] = true;
		
		Iterator<Integer> it = adjList[v].iterator();
		while(it.hasNext())
		{
			int i = it.next();
			if(!isVisited[i])
				topologicalSortUtil(i, isVisited, dq);
		}		
		dq.push(v);
	}
	void topologicalSort()
	{
		boolean isVisited[] = new boolean[numVertices];
		Deque<Integer> dq = new LinkedList<>();
		
		for(int i = 0; i < numVertices; i++)
		{
			if(!isVisited[i])
				topologicalSortUtil(i, isVisited, dq);
		}
		
		while(!dq.isEmpty())
			System.out.print(dq.pop() + " ");
	}
	/*
	 * We can modify DFS to find Topological Sorting of a graph. In DFS, we start from a vertex, we first print it and then recursively 
	 * call DFS for its adjacent vertices. 
	 * 
	 * In topological sorting, we use a temporary stack. We don’t print the vertex immediately, we first recursively call topological 
	 * sorting for all its adjacent vertices, then push it to a stack. Finally, print contents of stack. 
	 * 
	 * Note that a vertex is pushed to stack only when all of its adjacent vertices (and their adjacent vertices and so on) are already 
	 * in stack.
	 */
}
class Graph_5_TopologicalSorting
{
	public static void main(String args[])
	{
		Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
 
        System.out.println("Graph:\n" + g); 
        System.out.println("Topological sort of the Graph:");
        g.topologicalSort();
	}
}
