package datastruct.graph;

public interface DirectedGraph extends Graph{

	public int nodeInDegree(int node);
	public int nodeOutDegree(int node);
	
	@Override
	default int nodeDegree(int node) {
		// TODO Auto-generated method stub
		return nodeInDegree(node) + nodeOutDegree(node);
	}
}
