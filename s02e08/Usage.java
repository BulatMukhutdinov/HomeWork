package s02e08;

public class Usage {

	public static void main(String[] args) {
		Graph g = new Graph();
		g.addVertice(new NodeGraph(1));
		g.addVertice(new NodeGraph(2));
		g.addVertice(new NodeGraph(3));
		g.addVertice(new NodeGraph(4));
		g.graph.get(0).addLink(g.graph.get(1), 1);
		g.graph.get(0).addLink(g.graph.get(2), 1);
		g.graph.get(0).addLink(g.graph.get(3), 1);
		g.graph.get(1).addLink(g.graph.get(3), 1);
		g.graph.get(2).addLink(g.graph.get(3), 1);

		System.out.println(g.graph.get(0).minPath(g.graph.get(3)));

	}

}