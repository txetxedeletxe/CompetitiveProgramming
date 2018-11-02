package datastruct.graph;
import java.util.List;

public interface Graph {

	public boolean hasEdge(int node1 , int node2);
	public void addEdge(int node1 , int node2);
	public void removeEdge(int node1, int node2);
	public int nodeCount();
	public int edgeCount();
	public int nodeDegree(int node);
	public List<Integer> adjList(int node);
}
