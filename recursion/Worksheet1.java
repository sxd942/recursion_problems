/**
 * @author <Sion Davies> This class contains the solution for Worksheet1
 * Student No: 1349541
 */

 public class Worksheet1 {

	/**
	 * Exercise 1: Part 1
	 * The power method is used for raising one integer
	 * to the power of the other recursively.
	 * It follows the logic that m to the power of n
	 * is equal to m * m n-1.
	 * We assume that the integers are both non-negative.
	 * The base case for the recursive method is when
	 * n == 0.
	 *
	 * @param m The int value.
	 * @param n The exponent the int value is to be raised
	 *          to the power of.
	 * @return The int value of m to the power of n.
	 */

	static int power(int m, int n) {

		if (n == 0) {
			return 1;
		} else {
			return m * power(m, n - 1);
		}
	}

	/**
	 * Exercise 1: Part 2
	 * The fast power method is used for raising one
	 * integer to the power of the other recursively.
	 * If the value of the exponent n is divisible by
	 * 2 (is even), we use two recursive calls.
	 * If the value of he exponent is not divisible
	 * by 2 we use straight-forward recursion.
	 * The base case for the recursive methods is
	 * if n == 0.
	 *
	 * @param m The int value.
	 * @param n The exponent the int value is to be
	 *          raised to the power of.
	 * @return The int value of m to the power of n.
	 */

	static int fastPower(int m, int n) {

		if (n == 0) {
			return 1;
		} else if (n % 2 == 0) {
			return fastPower(m, (n / 2)) * fastPower(m, (n / 2));
		} else {
			return m * fastPower(m, n - 1);
		}
	}

	/**
	 * Exercise 2
	 * The negateAll method takes a List of Integers as its'
	 * parameter and returns a new list with all the elements
	 * of the original list but with the signs negated. E.g.
	 * 1,2,3 becomes -1,-2,-3.
	 * The logic used is that a * -1 = -a.
	 * On each recursive call the head of the original list is
	 * negated and stored in the new list to be returned.
	 * The original list continually decreases in size, as
	 * on each call it loses an element (its head) to the new
	 * list, until the base case (a.isEmpty) is reached.
	 *
	 * @param a The integer list to be negated
	 * @return A new list containing all of the elements of
	 * the previous list with their signs negated.
	 */

	static List<Integer> negateAll(List<Integer> a) {

		if (a.isEmpty()) {
			return a;
		} else {
			return new List<Integer>(a.getHead() * -1, negateAll(a.getTail()));
		}
	}

	/**
	 * Exercise 3
	 * The find method takes a given integer and an integer
	 * list as parameters and returns the index position of
	 * the integer element in the given list.
	 * The method counts the index position of the element
	 * by counting the number of recursive calls needed to
	 * find the element and then adding 1 the the value.
	 * If the list does not contain element x an illegal
	 * argument exception is thrown.
	 *
	 * @param x The integer value to be searched for.
	 * @param a The integer list to be search through.
	 * @return The index position of x in a.
	 */

	static int find(int x, List<Integer> a) {

		if ((a.isEmpty())) {
			throw new IllegalArgumentException("List does not contain: " + x);
		}
		else if (a.getHead() == x) {
			return 0;
		} else {
			return (find(x, a.getTail()) + 1);
		}
	}

	/**
	 * Exercise 4
	 * The allEven method takes a given list of integers as
	 * its' parameters and returns boolean value indicating
	 * if all of the lists elements are even (divisible by 2).
	 * The logic of the method is that if any of the elements
	 * in the head of the list is not divisible by 2, then
	 * return false. If not, continue to recursively check through
	 * the remaining elements in the list by recursively calling
	 * the tail. If the list becomes empty, it indicates that
	 * all of the elements checked must be divisible by 2, and
	 * therefore be even.
	 *
	 * @param a The given list of Integers.
	 * @return True if all elements in list a are even.
	 * @return False if any element in list a is not even.
	 */

	static boolean allEven(List<Integer> a) {

		if (a.isEmpty()) {
			return true;
		} else if (a.getHead() % 2 != 0) {
			return false;
		} else {
			return allEven(a.getTail());
		}
	}

	/**
	 * Exercise 5
	 * The evenNumbers method takes in an Integer list as
	 * its parameter. The method sorts through the list,
	 * finding the elements that are divisible by 2 (are
	 * even), and then returning a new list which contain
	 * only the even numbers of the original list.
	 * To do this the method checks to see if the head is
	 * not divisible by 2, if it is not, it returns only
	 * the tail of the list via a recursive call. Else if
	 * the number is even it returns a new list with the
	 * even values via a recursive call.
	 *
	 * @param a The given Integer list.
	 * @return A new list containing only the even integer
	 * values in a in the same relative order. If the given
	 * list a contained no even numbers or is empty, the method
	 * will return an empty list.
	 */

	static List<Integer> evenNumbers(List<Integer> a) {

		if (a.isEmpty()) {
			return a;
		} else if (a.getHead() % 2 != 0) {
			return evenNumbers(a.getTail());
		} else {
			return new List<Integer>(a.getHead(), evenNumbers(a.getTail()));
		}
	}

	/**
	 * Exercise 6
	 * The sorted method takes in a given Integer list as its
	 * parameter and returns a boolean value to indicate whether
	 * the list is sorted in descending order. There can be duplicate
	 * elements in the list, however, they must be appear next to each
	 * other.
	 * To do this the method compares the head of the list to see if it
	 * is greater than or equal to the first element in lists tail. If
	 * it is it recursively calls the lists tail and continues to compare
	 * the values. If the tail of the list is empty (base case), it must
	 * indicate that the values of the list are in descending order.
	 *
	 * @param a The given list of Integers.
	 * @return True if the elements in the list are in descending order
	 * of value.
	 * @return False if the elements in the list are not in descending
	 * order of value.
	 */

	static boolean sorted(List<Integer> a) {

		if (a.isEmpty() || a.getTail().isEmpty()) {
			return true;
		} else if (a.getHead() >= a.getTail().getHead()) {
			return sorted(a.getTail());
		} else {
			return false;
		}
	}

	/**
	 * Exercise 7
	 * The merge method takes in two Integer lists as its parameters.
	 * If the elements in both given lists are sorted in descending
	 * order, the method returns a new list containing the all of
	 * the elements of both lists, in sorted descending order.
     *
	 * @param a The first sorted list of Integers.
	 * @param b The second sorted list of Integers.
	 * @return A new sorted list combined of elements a and b.
	 */

	static List<Integer> merge(List<Integer> a, List<Integer> b) {

	    if (a.isEmpty()) {
			return b;
		} else if (b.isEmpty()) {
			return a;
		} else if (a.getHead() >= b.getHead()) {
			return new List<Integer>(a.getHead(),(merge(a.getTail(), b)));
		} else {
			return new List<Integer>(b.getHead(), merge(b.getTail(), a));
		}
	}

    /**
     * Exercise 8
     * The remove duplicates method takes in a sorted list of
     * Integers, and returns a new copy of the given list, with
     * all of the duplicate copies removed.
     *
     * To do this the method compares the head of the list with
     * the first element in the lists tail, if they are equal,
     * it makes a recursive call on the tail to remove the element
     * from the head. If they are not equal, a new list is returned
     * with the element from the head, and  a recursive
     * call is made on the tail to repeat the process. The base
     * case is met when the tail of the list is empty.
     *
     * @param a The sorted list of integers.
     * @return The sorted list of integers with no duplicate elements.
     */

	static List<Integer> removeDuplicates (List < Integer > a) {

		if (a.getTail().isEmpty()){
			return a;
		}  else if (a.getHead().equals(a.getTail().getHead())) {
			return removeDuplicates(a.getTail());
		} else {
			return new List<Integer>((a.getHead()), removeDuplicates(a.getTail()));
		}
	}


	}

