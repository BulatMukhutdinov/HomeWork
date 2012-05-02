package s02e08;

import java.util.ArrayList;
import java.util.LinkedList;

public class NodeGraph {
	public int data;
	public ArrayList<Object[]> vertices;
	public boolean in = false;

	NodeGraph(int data) {
		this.data = data;
		vertices = new ArrayList<Object[]>();
	}

	public void addLink(NodeGraph vertice, int weight) {

		vertices.add(new Object[] { vertice, weight });
	}

	public int getData() {

		return data;
	}

	public ArrayList<Object[]> getLinks() {

		return vertices;
	}

	public int minPath(NodeGraph ng) {
		int min = 0;
		boolean b = false;
		java.util.Queue<NodeGraph> q = new LinkedList<NodeGraph>();
		NodeGraph a = this;
		q.add(a);
		a.in = true;
		while (!q.isEmpty()) {
			a = q.poll();
			if (a.equals(ng))
				return min;
			b = false;
			for (int i = 0; i < a.vertices.size(); i++) {
				if (!a.getVertices(i).in) {
					q.add(a.getVertices(i));
					b = true;
					a.getVertices(i).in = true;
				}
			}
			if (b)
				min++;
		}
		return -1;
	}

	public Object[] getLink(int a) {
		if (vertices.isEmpty())
			return null;
		return vertices.get(a);
	}

	public NodeGraph getVertices(int i) {
		try {
			return (NodeGraph) this.vertices.get(i)[0];
		} catch (Exception e) {
			return null;
		}
	}

}
