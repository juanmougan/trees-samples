/**
 * 
 */
package io.github.juanmougan.samples.trees;

import java.util.LinkedList;
import java.util.Queue;

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
		if (rootNode == null) {
			return false;
		}
		// If root == element, return element
		if (rootNode.data.equals(nodeData)) {
			return true;
		}
		// Else
		// If element < root, will iterate to the left
		// If element > root, will iterate to the right
		int comparation = nodeData.compareTo(rootNode.data);
		if (comparation <= 0) { // equal element will go to the left
			return isDataInTree(rootNode.left, nodeData);
		} else {
			return isDataInTree(rootNode.right, nodeData);
		}
	}
	
	public void insert(T data) {
		this.root = this.insert(this.root, data);
	}
	
	public void insertChildrenForNode(T left, T right) {
		this.root.left = new Node<T>(left);
		this.root.right = new Node<T>(right);
	}
	
	public void insert(Node node) {
	    if(root == null) {
	        root = node;
	        return;
	    }

	    /* insert using Breadth-first-search (queue to the rescue!) */
	    Queue<Node> queue = new LinkedList<Node>();
	    queue.offer(root);

	    while(true) {
	        Node n = queue.remove();
	        if(!n.visited) System.out.println(n.data);
	        n.visited = true;

	        if(n.left == null) {
	            n.left = node;
	            break;
	        } else {
	            queue.offer(n.left);
	        }           

	        if(n.right == null) {
	            n.right = node;
	            break;
	        } else {
	            queue.offer(n.right);
	        }
	    }
	}

	private Node<T> insert(Node<T> node, T data) {
		if (node == null) {
			node = new Node<T>(data);
//			this.root = node;
		} else {
			int comparation = data.compareTo(node.data);
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
		boolean visited = false;

		public Node(T data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

		public void setLeft(Node<T> left) {
			this.left = left;
		}

		public void setRight(Node<T> right) {
			this.right = right;
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
	
	/**
	 * LevelOrder traversal - Visits nodes by levels from top to bottom and from left to right.
	 * @param node
	 */
	public void trasverseInLevelOrder(Node<T> node) {
		Queue<Node<T>> queue = new LinkedList<>(); 
		if (node == null) {
			return;
		}
		queue.clear();
	    queue.add(node);
	    while (!queue.isEmpty()) {
	        Node<T> currentNode = queue.remove();
	        this.visitNode(currentNode);
	        if(currentNode.left != null) 
	        	queue.add(currentNode.left);
	        if(currentNode.right != null) 
	        	queue.add(currentNode.right);
	    }
	}

	/**
	 * PreOrder traversal - visit the parent first and then left and right children;
	 * @param node
	 */
	public void trasverseInPreOrder(Node<T> node) {
		if (node == null) {
			return;
		}
		this.visitNode(node);
		this.trasverseInPreOrder(node.left);
		this.trasverseInPreOrder(node.right);
	}
	
	/**
	 * InOrder traversal - visit the left child, then the parent and the right child;
	 * @param node
	 */
	public void trasverseInOrder(Node<T> node) {
		if (node == null) {
			return;
		}
		this.trasverseInOrder(node.left);
		this.visitNode(node);
		this.trasverseInOrder(node.right);
	}
	
	/**
	 * PostOrder traversal - visit left child, then the right child and then the parent;
	 * @param node
	 */
	public void trasverseInPostOrder(Node<T> node) {
		if (node == null) {
			return;
		}
		this.trasverseInOrder(node.left);
		this.trasverseInOrder(node.right);
		this.visitNode(node);
	}

	private void visitNode(Node<T> node) {
		System.out.println("Visiting node: " + node.data);
	}

}
