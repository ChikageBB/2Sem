package ru.itis.inf403.ds.tree_binary;

class Node {
	int key;
	Node left;
	Node right;
	Node parent;
}

public class Formation {

	public static void main(String[] args) {
		int dataArray[] = { 20, 18, 19, 15, 17, 16, 3, 25, 22, 27, 26, 28, 21, 23 };
		Node root = null;

		Node z = new Node();
		z.key = dataArray[0];
		z.parent = null;
		root = insert(z, root);
		for (int i=1;i<dataArray.length;i++){
			z = new Node();
			z.key = dataArray[i];
			insert(z, root);

		}
		Node t = new Node();
		for (int i=1;i<dataArray.length;i++){
		t=search(root, dataArray[i]);
		System.out.println(nodeHeight( t));
		System.out.println("êîðåíü ïîääåðåâà: " +t.key);
		System.out.println("ðîäèòåëü: " + (t.parent!=null?t.parent.key:"null"));
		System.out.println("ëåâûé ïîòîìîê: " + (t.left!=null?t.left.key:"null"));
		System.out.println("ïðàâûé ïîòîìîê: " + (t.right!=null?t.right.key:"null"));
		System.out.println("*************************************************************");
		}
	}

	public static Node insert(Node z, Node x) {
		if (x == null) {
			x = z;
		} else if (z.key < x.key) {
			x.left = insert(z, x.left);
			x.left.parent =x;
		} else {
			x.right = insert(z, x.right);
			x.right.parent =x;
		}
		return x;
	}

	public static Node search(Node x, int k) {
		if ((x == null) || (k == x.key))
			return x;
		if (k < x.key)
			return search(x.left, k);
		else
			return search(x.right, k);
	}
	public static int nodeHeight(Node x) {
	    if (x == null) return -1;
	    else
           return Math.max(nodeHeight(x.left), nodeHeight(x.right)) + 1;
	}
}
