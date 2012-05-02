package s02e08;

import java.util.ArrayList;

import java.util.Stack;


public class Graph {
	public ArrayList<NodeGraph> graph;

	public Graph() {
		graph = new ArrayList<NodeGraph>();
	}

	public int[] DijkstrasAlgorithm(NodeGraph vertice) {
		int[] w = new int[graph.size()];
		int begin = 0;
		for (int i = 0; i < graph.size(); i++) {
			w[i] = Integer.MAX_VALUE;
			if (graph.get(i).getData() == vertice.getData()) {
				w[i] = 0;
				begin = i;
			}
		}
		Stack<NodeGraph> st = new Stack<NodeGraph>();
		st.push(graph.get(begin));
		NodeGraph ng = new NodeGraph(-1);
		int edge = 0;
		while (!st.isEmpty()) {
			ng = st.pop();
			edge = 0;
			while (edge != ng.vertices.size()) {
				int num = 0, num1 = 0; // num - номер данной вершины в
										// множестве, num1 - номер проверяемой
										// ссылки в множестве
				for (int i = 0; i < graph.size(); i++) {
					if (graph.get(i).getData() == ng.getData())
						num = i;
				}
				for (int i = 0; i < graph.size(); i++) {
					if (((NodeGraph) ng.vertices.get(edge)[0]).getData() == graph
							.get(i).getData())
						num1 = i;

				}
				if ((int) ng.vertices.get(edge)[1] + w[num] < w[num1]) {
					w[num1] = (int) ng.vertices.get(edge)[1] + w[num];
				}
				st.push((NodeGraph) ng.vertices.get(edge)[0]);
				edge++;
			}
		}
		return w;
	}

	public void addVertice(NodeGraph vertice) {
		graph.add(vertice);
	}
	
}