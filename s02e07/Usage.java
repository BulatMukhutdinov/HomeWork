package s02e07;

public class Usage {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		TreeNode tn1 = new TreeNode(15);
		TreeNode tn2= new TreeNode(7);
		root.insert(tn1);
		root.insert(tn2);
		root.delete(tn1);
		
	}

}
