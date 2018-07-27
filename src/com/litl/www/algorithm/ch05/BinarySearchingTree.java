package com.litl.www.algorithm.ch05;

public class BinarySearchingTree {
	private BinaryTreeNode root;

	public BinarySearchingTree(BinaryTreeNode root) {
		this.root = root;
	}

	public BinaryTreeNode search(int data) {
		return search(root, data);
	}

	public BinaryTreeNode search(BinaryTreeNode node, int data) {
		if (node == null) {
			return null;
		} else if (node.getData() == data) {
			return node;
		} else if (data > node.getData()) {
			return search(node.getRightChild(), data);
		} else {
			return search(node.getLeftChild(), data);
		}
	}

	public void insert(int data) {
		if (root == null) {
			root = new BinaryTreeNode();
			root.setData(data);
		} else {
			searchAndInsert(null, root, data);
		}
	}

	public BinaryTreeNode searchAndInsert(BinaryTreeNode parent, BinaryTreeNode node, int data) {
		if (node == null) {
			node = new BinaryTreeNode();
			node.setData(data);
			if (data > parent.getData()) {
				parent.setRightChild(node);
			} else {
				parent.setLeftChild(node);
			}
			return node;
		} else if (node.getData() == data) {
			return node;
		} else if (data > node.getData()) {
			return searchAndInsert(node, node.getRightChild(), data);
		} else {
			return searchAndInsert(node, node.getLeftChild(), data);
		}
	}

	public void delete(int data) {
		if (root.getData() == data) {
			root = null;
			return;
		}
		BinaryTreeNode parent = searchParent(data);
		if (parent == null) {
			return;
		}
		BinaryTreeNode node = search(parent, data);
		if (node.getLeftChild() == null && node.getRightChild() == null) {
			if (parent.getLeftChild() != null && parent.getLeftChild().getData() == data) {
				parent.setLeftChild(null);
			} else {
				parent.setRightChild(null);
			}
		} else if (node.getLeftChild() != null && node.getRightChild() == null) {
			if (parent.getLeftChild() != null && parent.getLeftChild().getData() == data) {
				parent.setLeftChild(node.getLeftChild());
			} else {
				parent.setRightChild(node.getLeftChild());
			}
		} else if (node.getLeftChild() == null && node.getRightChild() != null) {
			if (parent.getLeftChild() != null && parent.getLeftChild().getData() == data) {
				parent.setLeftChild(node.getRightChild());
			} else {
				parent.setRightChild(node.getRightChild());
			}
		} else {
			BinaryTreeNode deleteNode = node;
			BinaryTreeNode temp = node.getRightChild();
			if (temp.getLeftChild() == null) {
				temp.setLeftChild(deleteNode.getLeftChild());
			} else {
				while (temp.getLeftChild() != null) {
					node = temp;
					temp = temp.getLeftChild();
				}
				node.setLeftChild(temp.getRightChild());
				temp.setLeftChild(deleteNode.getLeftChild());
				temp.setRightChild(deleteNode.getRightChild());
			}
			if (parent.getLeftChild() != null && parent.getLeftChild().getData() == data) {
				parent.setLeftChild(temp);
			} else {
				parent.setRightChild(temp);
			}
		}
	}

	public BinaryTreeNode searchParent(int data) {
		return searchParent(null, root, data);
	}

	// public BinaryTreeNode search(BinaryTreeNode node, int data) {
	// if (node == null) {
	// return null;
	// } else if (node.getData() == data) {
	// return node;
	// } else if (data > node.getData()) {
	// return search(node.getRightChild(), data);
	// } else {
	// return search(node.getLeftChild(), data);
	// }
	// }

	public BinaryTreeNode searchParent(BinaryTreeNode parent, BinaryTreeNode node, int data) {
		if (node == null) {
			return null;
		} else if (node.getData() == data) {
			return parent;
		} else if (data > node.getData()) {
			return searchParent(node, node.getRightChild(), data);
		} else {
			return searchParent(node, node.getLeftChild(), data);
		}
	}

	public BinaryTreeNode getRoot() {
		return root;
	}
}
