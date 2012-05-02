package s02e05;

public class Node {
	public Node data;
	public Node next;

	Node(Node data, Node next) {
		this.data = data;
		this.next = next;
	}

	public Node getData() {
		return data;
	}

	public void setData(Node a) {
		data = a;
	}
	public void next(Node a) {
		next = a;
	}

}
