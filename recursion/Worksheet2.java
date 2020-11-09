/**
 * @author <Sion Davies>
 * This class contains the solution for Worksheet2
 */

public class Worksheet2 implements Worksheet2Interface {


	/**
	 * Exercise 1.
	 * negateAll() takes in a tree of Integers and returns a new tree with
	 * all values negated, i.e. 10 becomes -10.
	 * The base case is if the tree is empty.
	 * Until the base case is reached the root of the tree is multiplied by
	 * negative 1 and returned in a new tree. Recursive calls are made on
	 * both left and right subtrees to filter their values to be the root
	 * recursively. This continues until the tree is empty and the base case
	 * is reached, in which the new tree is returned with signs negated.
	 *
	 * @param t the tree to be negated.
	 * @return the new negated tree.
	 */

	static Tree<Integer> negateAll(Tree<Integer> t) {
		if (t.isEmpty()) {
			return t;
		} else {
			return new Tree<Integer>(t.getValue() * -1, negateAll(t.getLeft()), negateAll(t.getRight()));
		}
	}

	/**
	 * Exercise 2.
	 * allEven() takes in a tree of integers and returns a boolean
	 * value indicating if all the trees elements are even.
	 * The base case is if the tree is empty. Until the base case
	 * is reached, the root of the tree is analyzed to see if it
	 * is divisible by 2. If it is not, the method returns false.
	 * Else, recursive calls are made on the left and right subtrees
	 * to traverse their values, to see if their elements are also
	 * divisible by 2. Once the tree is empty, it indicates all of
	 * its elements must have past the condition, and returns true.
	 *
	 * @param a given tree of integers.
	 * @return boolean value to indicate whether all of trees elements
	 * are of even value.
	 */

	static boolean allEven(Tree<Integer> a) {
		if (a.isEmpty()) {
			return true;
		} else if (a.getValue() % 2 != 0) {
			return false;
		} else {
			return allEven(a.getLeft()) && allEven(a.getRight());
		}
	}

	/**
	 * Exercise 3.
	 * depth() takes in a tree of integers and a node value, and returns
	 * the depth of where the node is located within the tree.
	 * Base case #1 is if the tree is empty, return -1, as it indicates
	 * the node is not in the tree as it was never found.
	 * Base case #2 is if the root == x, return 0, as the depth of the
	 * root node is 0.
	 * Else, if a recursive call on the left subtree != 0, this indicates
	 * that the node is in the left. Therefore, return a recursive call
	 * on the left to traverse its nodes. Once it is found at the root,
	 * 0 is returned, plus 1 * the number of times the recursive call
	 * was made, which will give us the depth of the node.
	 * If node was not in left, repeat these above steps on the right
	 * subtree.
	 *
	 * @param a the tree.
	 * @param x the node.
	 * @return -1 if node is not in tree. Else return the depth of
	 * where the node is located.
	 */

	static int depth(Tree<Integer> a, int x) {
		if (a.isEmpty()) {
			return -1;
		} else if (a.getValue() == x) {
			return 0;
		} else if (depth(a.getLeft(), x) != -1) {
			return depth(a.getLeft(), x) + 1;
		} else if (depth(a.getRight(), x) != -1) {
			return depth(a.getRight(), x) + 1;
		} else return -1;
	}

	/**
	 * Exercise 4.
	 * preorder() takes in a generic Tree and returns the nodes
	 * in preorder (node first, left subtree second, right subtree third)
	 * as a List.
	 * If the tree provided is empty, an empty list is returned.
	 * Else a list is returned with the root as the head of the List,
	 * and then a helper function 'concatenate' is used to join the
	 * the left and right subtrees into the tail of the list.
	 * Recursive calls are made on both the left and right subtrees
	 * so that their elements are in preorder.
	 *
	 * @param a   The given tree.
	 * @param <E> Indicating the tree is of type generic.
	 * @return A list with all the elements of the tree in preorder.
	 */

	static <E> List<E> preorder(Tree<E> a) {
		if (a.isEmpty()) {
			return new List<E>();
		} else {
			return new List<E>(a.getValue(), concatenate(preorder(a.getLeft()), preorder(a.getRight())));
		}
	}

	/**
	 * concatenate() is a helper function that takes in two generic lists
	 * and concatenates them into one recursively.
	 *
	 * @param a   The first list to be joined.
	 * @param b   The second list to be joined.
	 * @param <E> The function is generic.
	 * @return a new list with b joined to a.
	 */

	private static <E> List<E> concatenate(List<E> a, List<E> b) {
		if (a.isEmpty()) {
			return b;
		} else {
			return new List<E>(a.getHead(), concatenate(a.getTail(), b));
		}
	}

	/**
	 * Exercise 5.
	 * isSearchTree() takes in a tree of integers and returns
	 * a boolean value indicating whether the tree is a binary
	 * search tree. It uses the helper function isBST() to
	 * determine this.
	 * It passes the tree into the isBST() method and sets
	 * its min parameter to Integer.MIN_VALUE and its max
	 * parameter to Integer.MAX_VALUE.
	 *
	 * @param a the given tree.
	 * @return boolean value indicating if the tree is a BST.
	 */

	static boolean isSearchTree(Tree<Integer> a) {
		return isBST(a, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	/**
	 * isBST() is a helper function which determines whether a
	 * tree of integers is a binary search tree.
	 * To do this it recursively checks the condition that
	 * every nodes left subtree is of less value than it, and,
	 * if every nodes right subtree is of greater value than it.
	 * If this condition is continually met, eventually the
	 * left and right subtrees will be empty, and the base case
	 * will be met, returning true.
	 * Else if condition is not met, return false.
	 *
	 * @param a   given tree of integers.
	 * @param min sets the minimum value.
	 * @param max sets the maximum value.
	 * @return boolean value indicating if the tree is a BST.
	 */

	static boolean isBST(Tree<Integer> a, int min, int max) {
		if (a.isEmpty()) {
			return true;
		} else if (a.getValue() < min || a.getValue() > max) {
			return false;
		} else {
			return isBST(a.getLeft(), min, a.getValue())
					&& isBST(a.getRight(), a.getValue(), max);
		}
	}

	/**
	 * Exercise 6.
	 * printDescending() takes in a BST of integers,
	 * and prints its value in descending order.
	 * First it uses a recursive call to print the
	 * right subtree, then it prints the root, and
	 * finally it uses a recursive call to print
	 * the left subtree.
	 *
	 * @param a BST of integers.
	 */

	static void printDescending(Tree<Integer> a) {
		if (a.isEmpty()) {
			return;
		} else {
			printDescending(a.getRight());
			System.out.println(a.getValue());
			printDescending(a.getLeft());
		}
	}

	/**
	 * Exercise 7.
	 * max() takes in a BST of integers as its argument, and
	 * returns the maximum value in the tree.
	 * As this is a BST, the maximum value must be stored in the
	 * right most branch of the right subtree. Therefore it is
	 * only necessary to traverse this path.
	 * If the argument tree is empty, an illegal argument exception
	 * is thrown.
	 * Else if the right subtree is empty, the root value is returned.
	 * Until this condition is met the right subtree is recursively
	 * called, filtering the values in the right subtree until the
	 * final, highest value becomes the root of the tree, which
	 * is eventually returned.
	 *
	 * @param a BST of integers
	 * @return The maximum value in the tree.
	 */

	static int max(Tree<Integer> a) {
		if (a.isEmpty()) {
			throw new IllegalArgumentException("Tree is empty.");
		} else if (a.getRight().isEmpty()) {
			return a.getValue();
		} else {
			return max(a.getRight());
		}
	}

	/**
	 * Exercise 8.
	 * Delete() takes in an integer BST tree as its argument and an int
	 * value. The method deletes the given int value from the tree,
	 * and returns a new tree that contains all of the original elements
	 * of the tree except for the deleted value. The new tree keeps its
	 * BST properties.
	 *
	 * When deleting a node from a BST there are three conditions we
	 * must cater for.
	 * 1: if the node has no children (is a leaf).
	 * 2: if the node has one child
	 * 3: if the node has two children.
	 *
	 * For case 1, we can use simple recursion to delete the leaf node.
	 *
	 * For case 2, we use simple recursion to get the value of the node
	 * and its child. When these two elements come to the condition:
	 * "if (a.getLeft().isEmpty()) --> return right" &&
	 * "if (a.getRight().isEmpty()) --> return left"
	 * This will return the node (whether on the left or right) to the
	 * tree, without its parent node that we have deleted.
	 *
	 * For case 3, if x == node, the argument will pass
	 * straight to the last return statement. If not
	 * the previous conditions will recursively filter
	 * the tree, until it is just the node we want to
	 * delete as a tree with its two children nodes.
	 * It will then pass to the last return statement.
	 * This statement returns the maximum value of the
	 * left subtree as the head of the tree, deletes
	 * this maximum value from its original place in
	 * the left subtree, and then attaches the right
	 * subtree.
	 *
	 * @param a The BST tree
	 * @param x The element to be deleted from the BST.
	 * @return A new BST with x deleted from it.
	 */

	static Tree<Integer> delete(Tree<Integer> a, int x) {
		if (a.isEmpty()) {
			return a;
			// filtering tree && getting x
		} else if (x < a.getValue()) {
			return new Tree<Integer>(a.getValue(), delete(a.getLeft(), x), a.getRight());
		} else if (x > a.getValue()) {
			return new Tree<Integer>(a.getValue(), a.getLeft(), delete(a.getRight(), x));
		} else {
			// deleting leaf node && node with one child
			if (a.getLeft().isEmpty()) {
				return a.getRight();
			} else if (a.getRight().isEmpty()) {
				return a.getLeft();
			}
			// deleting a node with two children.
			return new Tree<Integer>(max(a.getLeft()), delete(a.getLeft(), max(a.getLeft())), a.getRight());
		}

	}

	/**
	 * Exercise 9.
	 * isHeightBalanced() takes in a generic tree as its
	 * argument and checks it to determine whether it is
	 * a height-balanced AVL tree.
	 *
	 * To be an AVL tree no node can have a height difference
	 * which is greater than 1.
	 * To check this the method recursively calls both left and
	 * right subtrees, and if the height of the left subtree subtract
	 * the height of the right subtree is less than or equal to 1, it
	 * returns true. Else, the difference is greater the 1, indicating
	 * the tree is not height balanced, returning false.
	 * @param a Given arbitrary tree.
	 * @param <E> generic method.
	 * @return boolean value indicating if the tree is height balanced.
	 */

	static <E> boolean isHeightBalanced(Tree<E> a) {
		if (a.isEmpty()) {
			return true;
		} else if (isHeightBalanced(a.getLeft()) &&
				  isHeightBalanced(a.getRight()) &&
				a.getLeft().height - a.getRight().height <= 1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Exercise 10, part 1 (insert).
	 * insert() inserts an int value into an integer, height
	 * balanced binary search tree, whilst maintaining the
	 * trees properties to keep it both height-balanced and
	 * a BST.
	 * The method uses several helper functions to achieve this
	 * including:
	 *
	 * insert(): inserts a value into a tree.
	 *
	 * getBalance(): which gets the height-balance property of
	 * the tree.
	 *
	 * rightRightRotate(): performs two right rotations.
	 * rightLeftRotate(): performs a right then left rotation.
	 * leftLeftRotate(): performs two left rotations.
	 * leftRightRotate(): performs a left then right rotation.
	 *
	 * @param a The given integer, height-balanced BST.
	 * @param x the value to be inserted into a.
	 * @return A new tree preserving the AVL properties with 'x' inserted.
	 */

	static Tree<Integer> insertHB(Tree<Integer> a, int x) {
		Tree<Integer> b = insert(a, x);
		if (getBalance(b) > 1 && x > b.getRight().getValue()) {
			return rightRightRotate(b);
		} else if(getBalance(b) < -1 && x < b.getLeft().getValue()) {
			return leftLeftRotate(b);
		} else if(getBalance(b) > 1 && x > b.getLeft().getValue()) {
			return leftRightRotate(b);
		} else if(getBalance(b) < -1 && x < b.getRight().getValue()) {
			return rightLeftRotate(b);
		}
		return b;
	}

	/**
	 * insert() - Helper function.
	 * Inserts a value into a tree.
	 * @param a Given integer tree.
	 * @param x the value to be inserted
	 * @return new tree with 'x' inserted into 'a'.
	 */

	static Tree<Integer> insert(Tree<Integer> a, int x) {
		if (a.isEmpty()) {
			return new Tree<Integer>(x);
		} else if (x < a.getValue()) {
			return new Tree<Integer>(a.getValue(), insertHB(a.getLeft(), x), a.getRight());
		} else if (x > a.getValue()) {
			return new Tree<Integer>(a.getValue(), a.getLeft(), insertHB(a.getRight(), x));
		} else return a;
	}

	/**
	 * getBalance() - helper function
	 * @param a given integer tree.
	 * @return the height balance of the tree.
	 */

	static int getBalance(Tree<Integer> a) {
		if (a.isEmpty()) {
			return 0;
		} else {
			return a.getLeft().getHeight() - a.getRight().getHeight();
		}
	}

	/**
	 * leftRightRotate() - helper function.
	 * @param a given integer tree.
	 * @return new tree after a left then right rotation on elements.
	 */

	static Tree<Integer> leftRightRotate(Tree<Integer> a) {
		return new Tree<Integer>(a.getLeft().getRight().getValue(),
				new Tree<>(a.getLeft().getValue(), a.getLeft().getLeft(), a.getLeft().getRight()),
				new Tree<>(a.getValue(), a.getLeft().getRight().getRight(), a.getRight()));
	}

	/**
	 * leftRight() - helper function.
	 * @param a given integer tree.
	 * @return new tree after two left rotations are performed on elements.
	 */

	static Tree<Integer> leftLeftRotate(Tree<Integer> a) {
		return new Tree<Integer>(a.getLeft().getValue(), a.getLeft().getLeft(),
				new Tree<>(a.getValue(), a.getLeft().getRight(), a.getRight()));
	}

	/**
	 * rightLeft() - helper function
	 * @param a given integer tree.
	 * @return new tree after a right then left rotation is performed on elements.
	 */

	static Tree<Integer> rightLeftRotate(Tree<Integer> a) {
		return new Tree<Integer>(a.getRight().getLeft().getValue(),
				new Tree<>(a.getValue(), a.getLeft(), a.getRight().getLeft().getLeft()),
						new Tree<>(a.getRight().getValue(), a.getRight().getLeft().getRight(), a.getRight().getRight()));
	}

	/**
	 * rightRight() - helper function
	 * @param a given integer tree.
	 * @return new tree after two right rotations are performed on elements.
	 */

	static Tree<Integer> rightRightRotate(Tree<Integer> a) {
		return new Tree<Integer>(a.getRight().getValue(),
				new Tree<>(a.getValue(), a.getLeft(), a.getRight().getLeft()), a.getRight().getRight());

	}

	/**
	 * Exercise 10, part 2 (delete).
	 * delete() deletes an int value from a integer, height
	 * balanced binary search tree, whilst maintaining the
	 * trees properties to keep it both height-balanced and
	 * a BST.
	 *
	 * The method uses several helper functions to achieve this:
	 *
	 * delete(): deletes a value from a BST.
	 * rightRightRotate(): performs two right rotations.
	 * rightLeftRotate(): performs a right then left rotation.
	 * leftLeftRotate(): performs two left rotations.
	 * leftRightRotate(): performs a left then right rotation.
	 *
	 * @param a The given height-balanced, BST.
	 * @param x the node to be deleted from the tree.
	 * @return tree 'a' with node 'x' deleted from it.
	 */

	static Tree<Integer> deleteHB(Tree<Integer> a, int x) {
		Tree<Integer> b = delete(a, x);
		if (getBalance(b) < -1 && getBalance(b.getRight()) <= 0) {
			return rightRightRotate(b);
		} else if(getBalance(b) < -1 && getBalance(b.getRight()) > 0) {
			return rightLeftRotate(b);
		} else if(getBalance(b) > 1 && getBalance(b.getLeft()) >= 0) {
			return leftLeftRotate(b);
		} else if(getBalance(b) > 1 && getBalance(b.getLeft()) < 0) {
			return leftRightRotate(b);
		}
		return b;
	}

}