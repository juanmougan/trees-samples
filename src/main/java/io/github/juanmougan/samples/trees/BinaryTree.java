/**
 * 
 */
package io.github.juanmougan.samples.trees;

/**
 * @author juanma
 *
 */
public class BinaryTree<T extends Comparable<T>> {

	private Node<T> root;

	public BinaryTree() {
		this.root = null;
	}

	public Node<T> getRoot() {
		return root;
	}
	
	public boolean isDataInTree(T data) {
		return this.isDataInTree(this.root, data);
	}

	private boolean isDataInTree(Node<T> rootNode, T nodeData) {
		// If tree is empty, return false
		if (this.root == null) {
			return false;
		}
		// If root == element, return element
		if (this.root.equals(nodeData)) {
			return true;
		}
		// Else
		// If element < root, will iterate to the left
		// If element > root, will iterate to the right
		int comparation = nodeData.compareTo(this.root.data);
		if (comparation <= 0) { // equal element will go to the left
			return isDataInTree(rootNode.left, nodeData);
		} else {
			return isDataInTree(rootNode.right, nodeData);
		}
	}
	
	public void insert(T data) {
		this.root = this.insert(this.root, data);
	}

	private Node<T> insert(Node<T> node, T data) {
		if (node == null) {
			node = new Node<T>(data);
			this.root = node;
		} else {
			int comparation = data.compareTo(this.root.data);
			if (comparation <= 0) { // equal element will go to the left
				node.left = insert(node.left, data);
			} else {
				node.right = insert(node.right, data);
			}
		}
		return node; // in any case, return the new pointer to the caller
	}

	public static class Node<T extends Comparable<T>> {
		T data;
		Node<T> left;
		Node<T> right;

		public Node(T data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((data == null) ? 0 : data.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			@SuppressWarnings("unchecked")
			Node<T> other = (Node<T>) obj;
			if (data == null) {
				if (other.data != null)
					return false;
			}
			return this.data.compareTo(other.data) == 0;
		}

		public boolean nodeLessThan(Node<T> anotherNode) {
			int comparation = this.data.compareTo(anotherNode.data);
			return comparation < 0; // I don't care about equality...
		}

	}

}
