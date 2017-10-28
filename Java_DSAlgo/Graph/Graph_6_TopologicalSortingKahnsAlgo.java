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
	void topologicalSort()
	{
		int indegree[] = new int[numVertices];
		int topoSort[] = new int[numVertices];
		
		//Calulating Indegree for all vertices
		for(int i = 0; i < numVertices; i++)
		{
			Iterator<Integer> it = adjList[i].iterator();
			while(it.hasNext())
			{
				int index = it.next();
				indegree[index]++;
			}
		}
		
		boolean isVisited[] = new boolean[numVertices];
		Queue<Integer> q = new LinkedList<>();
		int count = 0;
		
		//Getting vertices with 0 indegree
		for(int i = 0; i < numVertices; i++)
			if(indegree[i] == 0)
				q.offer(i);
		
		while(!q.isEmpty())
		{
			int index = q.poll();
			
			if(isVisited[index])
				continue;
			
			isVisited[index] = true;
			topoSort[count] = index;
			count++;
			
			Iterator<Integer> it = adjList[index].iterator();
			while(it.hasNext())
			{
				int i = it.next();
				if(!isVisited[i])
				{
					indegree[i]--;
					if(indegree[i] == 0)
						q.offer(i);
				}
			}
		}//end of while(!q.isEmpty())
		if(count == numVertices)
			System.out.println(Arrays.toString(topoSort));
		else
			System.out.println("Cannot print topological sort. This graph has a cycle.");
	}
}
class Graph_6_TopologicalSortingKahnsAlgo
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
