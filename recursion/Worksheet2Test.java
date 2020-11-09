import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;


/**
 * @author <Sion Davies>
 * This class contains the test cases for Worksheet2 solutions.
 * <WRITE YOUR TEST CASES BELOW>
 */

public class Worksheet2Test {


    private Tree<Integer> BST;
    private Tree<Integer> fullBST;
    private Tree<Integer> perfectBST;
    private Tree<Integer> nonBST;
    private Tree<Integer> empty;
    private Tree<Integer> AVLTree;
    private Tree<Integer> nonAVLTree;
    private Tree<Integer> negative;
    private Tree<String> fruits;
    private Tree<Integer> heightBalanced;

    @BeforeEach
    public void init() {

        BST = new Tree<>(10, new Tree<>(5, new Tree<>(2)
                , new Tree<>(7)), new Tree<>(20, new Tree<>(15),
                new Tree<>(25)));

        fullBST = new Tree<>(11, new Tree<>(6, new Tree<>(2), new Tree<>(8)),
                new Tree<>(20, new Tree<>(16, new Tree<>(13), new Tree<>(19)), new Tree<>(22)));

        perfectBST = new Tree<>(30, new Tree<>(15, new Tree<>(13, new Tree<>(12), new Tree<>(14)),
                new Tree<>(17, new Tree<>(16), new Tree<>(18))), new Tree<>(45, new Tree<>(43,
                new Tree<>(42), new Tree<>(44)), new Tree<>(47, new Tree<>(46), new Tree<>(48))));

        nonBST = new Tree<>(11, new Tree<>(6, new Tree<>(2)
                , new Tree<>(1)), new Tree<>(16, new Tree<>(9),
                new Tree<>(22)));

        empty = new Tree();

        AVLTree = new Tree<Integer>(84, new Tree<>(48, new Tree<>(30), new Tree<>(50)),
                new Tree<>(96, new Tree<>(90), new Tree<>()));


        negative = new Tree<>(-70, new Tree<>(-50, new Tree<>(-45), new Tree<>(-52)),
                new Tree<>(-90, new Tree<>(-87), new Tree<>(-97)));

        fruits = new Tree<>("banana", new Tree<>("apple", new Tree<>("pear")
                , new Tree<>("blueberry")), new Tree<>("raspberry", new Tree<>("mango"),
                new Tree<>("melon")));

        nonAVLTree = new Tree<Integer>(12, new Tree<>(8, new Tree<>(5, new Tree<>(4, new Tree<>(2),
                new Tree<>()), new Tree<>(7)), new Tree<>(11)), new Tree<>(18, new Tree<>(17), new Tree<>()));

        heightBalanced = new Tree<>(30, new Tree<>(20), new Tree<>(90, new Tree<>(60), new Tree<>(95)));

    }

    /**
     * Test 1: Testing negateAll() method on a BST, a non-BST and a negative tree.
     * Exercise 1.
     */
    @Test
    public void test1() {
        Tree<Integer> expectedTree = new Tree<>(-10, new Tree<>(-5, new Tree<>(-2)
                , new Tree<>(-7)), new Tree<>(-20, new Tree<>(-15),
                new Tree<>(-25)));
        Tree<Integer> actualTree = Worksheet2.negateAll(BST);
        assertEquals(expectedTree, actualTree, "Error in negateAll()");

        Tree<Integer> expectedTree2 = new Tree<>(-11, new Tree<>(-6, new Tree<>(-2)
                , new Tree<>(-1)), new Tree<>(-16, new Tree<>(-9),
                new Tree<>(-22)));
        Tree<Integer> actualTree2 = Worksheet2.negateAll(nonBST);
        assertEquals(expectedTree2, actualTree2, "Error in negateAll()");

        Tree<Integer> expectedTree3 = new Tree<>(70, new Tree<>(50, new Tree<>(45), new Tree<>(52)),
                new Tree<>(90, new Tree<>(87), new Tree<>(97)));
        Tree<Integer> actualTree3 = Worksheet2.negateAll(negative);
        assertEquals(expectedTree3, actualTree3, "Error in negateAll()");

    }

    /**
     * Test 2: Testing allEven() on an even, uneven and empty trees.
     * and one non-BST.
     * Exercise 2.
     */
    @Test
    public void test2() {
        boolean expectedResult = true;
        boolean actualResult = Worksheet2.allEven(empty);
        assertEquals(expectedResult, actualResult, "Error in allEven()");

        boolean expectedResult2 = true;
        boolean actualResult2 = Worksheet2.allEven(AVLTree);
        assertEquals(expectedResult2, actualResult2, "Error in allEven()");

        boolean expectedResult3 = false;
        boolean actualResult3 = Worksheet2.allEven(fullBST);
        assertEquals(expectedResult3, actualResult3, "Error in allEven()");

        boolean expectedResult4 = false;
        boolean actualResult4 = Worksheet2.allEven(nonBST);
        assertEquals(expectedResult4, actualResult4, "Error in allEven()");

    }

    /**
     * Test 3: Testing depth() - BVA, first level, mid-level, upper level on
     * a BST and non-BST.
     * Exercise 3.
     */
    @Test
    public void test3() {
        int expectedDepth = 3;
        int actualDepth = Worksheet2.depth(perfectBST, 12);
        assertEquals(expectedDepth, actualDepth, "Error in depth()");

        int expectedDepth2 = 0;
        int actualDepth2 = Worksheet2.depth(perfectBST, 30);
        assertEquals(expectedDepth2, actualDepth2, "Error in depth()");

        int expectedDepth3 = 2;
        int actualDepth3 = Worksheet2.depth(perfectBST, 47);
        assertEquals(expectedDepth3, actualDepth3, "Error in depth()");

        int expectedDepth4 = 0;
        int actualDepth4 = Worksheet2.depth(nonBST, 11);
        assertEquals(expectedDepth4, actualDepth4, "Error in depth()");

        int expectedDepth5 = 1;
        int actualDepth5 = Worksheet2.depth(nonBST, 6);
        assertEquals(expectedDepth5, actualDepth5, "Error in depth()");

        int expectedDepth6 = 2;
        int actualDepth6 = Worksheet2.depth(nonBST, 1);
        assertEquals(expectedDepth6, actualDepth6, "Error in depth()");

    }

    /**
     * Test 4: Testing preorder() with trees of type Integer and String
     * One BST one non-BST.
     * Exercise 4.
     */
    @Test
    public void test4() {
        List<Integer> expectedList = new List<>(11, new List<>(6, new List<>(2, new List<>(8, new List
                <>(20, new List<>(16, new List<>(13, new List<>(19, new List<>
                (22, new List<>())))))))));
        List<Integer> actualList = Worksheet2.preorder(fullBST);
        assertEquals(expectedList, actualList, "Error in preorder()");

        List<String> expectedList2 = new List<>("banana", new List<>("apple", new List<>("pear",
                new List<>("blueberry", new List<>("raspberry", new List<>("mango", new List<>
                        ("melon", new List<>())))))));
        List<String> actualList2 = Worksheet2.preorder(fruits);
        assertEquals(expectedList2, actualList2, "Error in preorder()");

    }

    /**
     * Test 5: Testing isSearchTree(), using a BST, a non-BST and an empty list.
     * Exercise 5.
     */
    @Test
    public void test5() {
        boolean expectedResult = true;
        boolean actualResult = Worksheet2.isSearchTree(empty);
        assertEquals(expectedResult, actualResult, "Error in isSearchTree()");

        boolean expectedResult2 = true;
        boolean actualResult2 = Worksheet2.isSearchTree(BST);
        assertEquals(expectedResult2, actualResult2, "Error in isSearchTree()");

        boolean expectedResult3 = false;
        boolean actualResult3 = Worksheet2.isSearchTree(nonBST);
        assertEquals(expectedResult3, actualResult3, "Error in isSearchTree()");

        boolean expectedResult4 = true;
        boolean actualResult4 = Worksheet2.isSearchTree(perfectBST);
        assertEquals(expectedResult4, actualResult4, "Error in isSearchTree()");

    }

    /**
     * Test 6: Testing max() to find maximum value.
     * Exercise  7.
     */
    @Test
    public void test6() {
        int expectedResult = 48;
        int actualResult = Worksheet2.max(perfectBST);
        assertEquals(expectedResult, actualResult, "Error in max()");

        int expectedResult2 = 96;
        int actualResult2 = Worksheet2.max(AVLTree);
        assertEquals(expectedResult2, actualResult2, "Error in max()");

        int expectedResult3 = 22;
        int actualResult3 = Worksheet2.max(fullBST);
        assertEquals(expectedResult3, actualResult3, "Error in max()");
    }

    /**
     * Test 7: Testing max() exception.
     * Exercise 7.
     */
    @Test
    public void test8() {
        assertThrows(IllegalArgumentException.class, () -> Worksheet2.max(empty));
    }

    /**
     * Test 8: Testing isHeightBalanced() with an AVL
     * tree, a non-AVL tree, and an empty tree.
     * - Exercise 9.
     */
    @Test
    public void test9() {
        boolean expectedResult = true;
        boolean actualResult = Worksheet2.isHeightBalanced(AVLTree);
        assertEquals(expectedResult, actualResult, "Error in isHeightBalanced()");

        boolean expectedResult2 = false;
        boolean actualResult2 = Worksheet2.isHeightBalanced(nonAVLTree);
        assertEquals(expectedResult2, actualResult2, "Error in isHeightBalanced()");

        boolean expectedResult3 = true;
        boolean actualResult3 = Worksheet2.isHeightBalanced(empty);
        assertEquals(expectedResult3, actualResult3, "Error in isHeightBalanced()");

    }

    /**
     * Test 10 - testing insertHB()
     * Exercise 10.
     */
    @Test
    public void test10() {
        Tree<Integer> expectedTree = new Tree<>(60, new Tree<>(30, new Tree<>(20), new Tree<>()), new Tree<>(90, new Tree<>(62), new Tree<>(95)));
        Tree<Integer> actualTree = Worksheet2.insertHB(heightBalanced, 62);
        assertEquals(expectedTree, actualTree, "Error in insertHB()");
    }

    /**
     * Test 11 - testing deleteHB()
     * Exercise 10.
     */
    @Test
    public void test11() {
        Tree<Integer> expectedTree = Worksheet2.deleteHB(heightBalanced, 20);
        Tree<Integer> actualTree = new Tree<>(90, new Tree<>(30, new Tree<>(), new Tree<>(60)), new Tree<>(95));
        assertEquals(expectedTree, actualTree, "Error in deleteHB()");

        Tree<Integer> expectedTree2 = Worksheet2.deleteHB(heightBalanced, 30);
        Tree<Integer> actualTree2 = new Tree<>(90, new Tree<>(20, new Tree<>(), new Tree<>(60)), new Tree<>(95));
        assertEquals(expectedTree2, actualTree2, "Error in deleteHB()");

    }

    /**
     * Test 12 - testing delete()
     * Testing on a root, a leaf node and node with two children.
     * Exercise 8.
     */
    @Test
    public void test12() {
        Tree<Integer> expectedTree = Worksheet2.delete(BST, 10);
        Tree<Integer> actualTree = new Tree<>(7, new Tree<>(5, new Tree<>(2), new Tree<>()), new Tree<>(20, new Tree<>(15), new Tree<>(25)));
        assertEquals(expectedTree, actualTree, "Error in delete()");

        Tree<Integer> expectedTree2 = Worksheet2.delete(BST, 15);
        Tree<Integer> actualTree2 = new Tree<>(10, new Tree<>(5, new Tree<>(2), new Tree<>(7)), new Tree<>(20, new Tree<>(), new Tree<>(25)));
        assertEquals(expectedTree2, actualTree2, "Error in delete()");

        Tree<Integer> expectedTree3 = Worksheet2.delete(BST, 5);
        Tree<Integer> actualTree3 = new Tree<>(10, new Tree<>(2, new Tree<>(), new Tree<>(7)), new Tree<>(20, new Tree<>(15), new Tree<>(25)));
        assertEquals(expectedTree3, actualTree3, "Error in delete()");

    }

}
