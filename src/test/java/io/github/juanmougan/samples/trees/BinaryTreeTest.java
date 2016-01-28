/**
 * 
 */
package io.github.juanmougan.samples.trees;

import static org.junit.Assert.*;

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

	// TODO move these tests elsewhere - Node should be a top level class
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
