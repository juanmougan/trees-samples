/**
 * 
 */
package io.github.juanmougan.samples.trees;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import io.github.juanmougan.samples.trees.BinaryTree.Node;

/**
 * @author juanma
 *
 */
public class BinaryTreeTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsertOnlyRootElement() {
		// Given
		BinaryTree<Integer> emptyTree = new BinaryTree<>();
		Assert.assertNull(emptyTree.getRoot());
		// When
		emptyTree.insert(1);
		// Then
		Assert.assertEquals(new Integer(1), emptyTree.getRoot().data);
	}

	@Test
	public void testInsertMoreElements() {
		// Given
		BinaryTree<Integer> tree = new BinaryTree<>();
		Assert.assertNull(tree.getRoot());
		// When
		tree.insert(2);
		tree.insert(3);
		tree.insert(1);
		// Then
		Assert.assertEquals(new Integer(2), tree.getRoot().data);
		Assert.assertTrue(tree.isDataInTree(new Integer(1)));
		Assert.assertTrue(tree.isDataInTree(new Integer(3)));
	}

	@Test
	public void testInPreOrderTrasversal() {
		// Given
		BinaryTree<Integer> tree = new BinaryTree<>();
		// When
		tree.insert(2);
		tree.insert(3);
		tree.insert(1);
		// Then
		tree.trasverseInPreOrder(tree.getRoot());
	}
	
	@Test
	public void testInOrderTrasversal() {
		// Given
		BinaryTree<Integer> tree = new BinaryTree<>();
		// When
		tree.insert(2);
		tree.insert(3);
		tree.insert(1);
		// Then
		tree.trasverseInOrder(tree.getRoot());
	}
	
	@Test
	public void testInPostOrderTrasversal() {
		// Given
		BinaryTree<Integer> tree = new BinaryTree<>();
		// When
		tree.insert(2);
		tree.insert(3);
		tree.insert(1);
		// Then
		tree.trasverseInPostOrder(tree.getRoot());
	}
	
	@Test
	public void testInLevelOrderTrasversal() {
		// Given
		BinaryTree<Integer> tree = new BinaryTree<>();
		// When
		tree.insert(2);
		tree.insert(3);
		tree.insert(1);
		// Then
		tree.trasverseInLevelOrder(tree.getRoot());
	}
	
	@Test
	public void testInLevelOrderTrasversalForBigTree() {
		// Given
		/*
		 * ASCII art of the requested graph
			         1
			        / \
			       3   5
			      / \   \
			     2   4   7
			    / \       \
			   9   6       8
		 */
		BinaryTree<Integer> tree = new BinaryTree<>();
		tree.insert(new Node<Integer>(1));
		tree.insert(new Node<Integer>(3));
		tree.insert(new Node<Integer>(5));
		tree.insert(new Node<Integer>(2));
		tree.insert(new Node<Integer>(4));
		tree.insert(new Node<Integer>(7));
		tree.insert(new Node<Integer>(9));
		tree.insert(new Node<Integer>(6));
		tree.insert(new Node<Integer>(8));
		// When
		tree.trasverseInLevelOrder(tree.getRoot());
		// Then
		List<Node<Integer>> expectedList = Arrays.asList(new Node<Integer>(1), new Node<Integer>(3), new Node<Integer>(5), 
				new Node<Integer>(2), new Node<Integer>(4), new Node<Integer>(7), new Node<Integer>(9), 
				new Node<Integer>(6), new Node<Integer>(8));
		Assert.assertEquals(expectedList, tree.getVisitedNodes());
	}

	@Test
	public void testComparator() {
		Node<Integer> someNode = new Node<Integer>(5);
		boolean shouldBeBigger = someNode.nodeLessThan(new Node<Integer>(3));
		Assert.assertEquals(false, shouldBeBigger);
		boolean shouldBeSmaller = someNode.nodeLessThan(new Node<Integer>(7));
		Assert.assertEquals(true, shouldBeSmaller);
	}

	@Test
	public void testEquals() {
		Node<Integer> someNode = new Node<Integer>(5);
		boolean shouldBeBigger = someNode.equals(new Node<Integer>(3));
		Assert.assertEquals(false, shouldBeBigger);
		boolean shouldBeSmaller = someNode.equals(new Node<Integer>(3));
		Assert.assertEquals(false, shouldBeSmaller);
		boolean shouldBeEqual = someNode.equals(new Node<Integer>(5));
		Assert.assertEquals(true, shouldBeEqual);
	}

}
