package s02e07;

import java.util.Stack;

public class TreeNode {
	public int data;
	public TreeNode left;
	public TreeNode right;

	TreeNode(int data) {
		this.data = data;
	}

	public void setData(int a) {
		data = a;
	}

	public int getData() {

		return data;
	}

	public void insert(TreeNode tn) {
		TreeNode a = this;
		while (a.left != tn && a.right != tn) {
			if (tn.data >= a.data) {
				if (a.right != null) {
					a = a.right;
				} else {
					a.right = tn;
				}
			}
			if (tn.data < a.data) {
				if (a.left != null) {
					a = a.left;
				} else {
					a.left = tn;
				}
			}
		}
	}

	public void delete(TreeNode tn) {
		Object a[] = bypass();
		
		for (int i = 1; i < a.length ; i++) {
			if (a[i] != tn)
				this.insert((TreeNode) a[i]);
		}
	}

	public Object[] bypass() {
		Stack<TreeNode> a = new Stack<TreeNode>();
		Object o[] = new Object[count()];
		int k = 0;
		a.push(this);
		TreeNode b = null;
		while (!a.empty()) {
			b = (TreeNode) a.pop();
			

			if (b.left != null)
				a.push(b.left);
			if (b.right != null)
				a.push(b.right);
			b.left = null;
			b.right = null;
			o[k] = b;
			k++;
		}
		return o;
	}

	public int count() {
		int a = rec(this, 1);

		return a;
	}

	public int rec(TreeNode root, int a) {
		if (root.left != null) {
			rec((TreeNode) root.left, a);
			a++;
		}
		if (root.right != null) {
			rec((TreeNode) root.right, a);
			a++;
		}
		return a;
	}
}
