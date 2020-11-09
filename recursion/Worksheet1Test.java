import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

/** @author 
 *  <Sion Davies>
 * Student No: 1349541
 * This class contains the test cases for Worksheet1 solutions.
 *  <WRITE YOUR TEST CASES BELOW>
 */

public class Worksheet1Test {

    private List<Integer> empty; // An empty list
    private List<Integer> norm; // A list of positive integers
    private List<Integer> mixed; // A list of positive and negative integers
    private List<Integer> negative; // A list of negative integers
    private List<Integer> sorted1; // A list of sorted integers in descending order (includes duplicate values)
    private List<Integer> sorted2; // A second list of sorted integers in descending order
    private List<Integer> even; // A List of even integers
    private List<Integer> uneven; // A List of uneven integers


    @BeforeEach
    public void init(){
        empty = new List<>();
        norm = new List<>(1, new List<>(53, new List<>(17, new List<>(66, new List<>(8, new List<>())))));
        mixed = new List<>(-6, new List<>(4, new List<>(-9, new List<>(10, new List<>(0, new List<>())))));
        negative = new List<>(-5, new List<>(-3, new List<>(-50, new List<>(-100, new List<>(-1, new List<>())))));
        sorted1 = new List<>(9, new List<>(8, new List<>(8, new List<>(5, new List<>(5, new List<>())))));
        sorted2 = new List<>(6, new List<>(6, new List<>(2, new List<>(1, new List<>(0, new List<>())))));
        even = new List<>(2, new List<>(4, new List<>(6, new List<>(10, new List<>(16, new List<>())))));
        uneven = new List<>(1, new List<>(3, new List<>(5, new List<>(9, new List<>(17, new List<>())))));

    }

    /**
     * Testing the negateAll() method with a positive, negative, mixed list and empty list.
     */
    @Test
    public void test1() {
        List<Integer> expectedList = new List<>(-1, new List<>(-53, new List<>(-17, new List<>(-66, new List<>(-8, new List<>())))));
        List<Integer> actualList = Worksheet1.negateAll(norm);
        assertEquals(expectedList, actualList, "error in negateAll() method.");

        List<Integer> expectedList2 = new List<>(6, new List<>(-4, new List<>(9, new List<>(-10, new List<>(0, new List<>())))));
        List<Integer> actualList2 = Worksheet1.negateAll(mixed);
        assertEquals(expectedList2, actualList2, "error in negateAll() method.");

        List<Integer> expectedList3 = new List<>(5, new List<>(3, new List<>(50, new List<>(100, new List<>(1, new List<>())))));
        List<Integer> actualList3 = Worksheet1.negateAll(negative);
        assertEquals(expectedList3, actualList3, "error in negateAll() method.");

        List<Integer> expectedList4 = new List<>();
        List<Integer> actualList4 = Worksheet1.negateAll(empty);
        assertEquals(expectedList4, actualList4, "error in negateAll() method");
    }

    /**
     * Testing the find() method searching for an element.
     * Testing to search for a first and last element, and one in the middle.
     */
    @Test
    public void test2() {
        int expectedPosition = 3;
        int actualPosition = Worksheet1.find(10, mixed);
        assertEquals(expectedPosition, actualPosition, "error in find() method.");

        int expectedPosition2 = 0;
        int actualPosition2 = Worksheet1.find(-6, mixed);
        assertEquals(expectedPosition2, actualPosition2, "error in find() method.");

        int expectedPosition3 = 4;
        int actualPosition3 = Worksheet1.find(0, mixed);
        assertEquals(expectedPosition3, actualPosition3, "error in find() method.");
    }

    /**
     * Testing the find() method for an illegal argument, the
     * method should throw an exception.
     */
    @Test
    public void test3 () {
        assertThrows(IllegalArgumentException.class, () -> Worksheet1.find(1000, norm));
        assertThrows(IllegalArgumentException.class, () -> Worksheet1.find(2, norm));
    }

    /**
     * Testing the allEven() method for true and false.
     * Tests include an even list, an empty list, and a
     * an uneven mixed list.
     */
     @Test
    public void test4() {
         boolean expectedReturn = true;
         boolean actualReturn = Worksheet1.allEven(even);
         assertEquals(expectedReturn, actualReturn, "error in allEven() method.");

         boolean expectedReturn2 = true;
         boolean actualReturn2 = Worksheet1.allEven(empty);
         assertEquals(expectedReturn2, actualReturn2, "error in allEven() method.");

         boolean expectedReturn3 = false;
         boolean actualReturn3 = Worksheet1.allEven(mixed);
         assertEquals(expectedReturn3, actualReturn3, "error in allEven() method.");
     }

    /**
     * Testing the evenNumbers() method.
     * Lists returned should just be the even elements of
     * the given list.
     * Tests method on a normal, mixed, uneven, empty and even list.
     */
    @Test
    public void test5() {
        List<Integer> expectedList = new List<>(66, new List<>(8, new List<>()));
        List<Integer> actualList = Worksheet1.evenNumbers(norm);
        assertEquals(expectedList, actualList, "error in the evenNumbers() method.");

        List<Integer> expectedList2 = new List<>(-6, new List<>(4, new List<>(10, new List<>(0, new List<>()))));
        List<Integer> actualList2 = Worksheet1.evenNumbers(mixed);
        assertEquals(expectedList2, actualList2, "error in the evenNumbers() method.");

        List<Integer> expectedList3 = new List<>();
        List<Integer> actualList3 = Worksheet1.evenNumbers(uneven);
        assertEquals(expectedList3, actualList3, "error in the evenNumbers() method.");

        List<Integer> expectedList4 = new List<>();
        List<Integer> actualList4 = Worksheet1.evenNumbers(empty);
        assertEquals(expectedList4, actualList4, "error in the evenNumbers() method.");

        List<Integer> expectedList5 = new List<>(2, new List<>(4, new List<>(6, new List<>(10, new List<>(16, new List<>())))));
        List<Integer> actualList5 = Worksheet1.evenNumbers(even);
        assertEquals(expectedList5, actualList5, "error in the evenNumbers() method.");
    }

    /**
     * Testing the sorted() method.
     * Tests include two sorted lists, an unsorted list and an empty list.
     */
    @Test
    public void test6() {
        boolean expectedResult = true;
        boolean actualResult = Worksheet1.sorted(sorted1);
        assertEquals(expectedResult, actualResult, "error in the sorted() method.");

        boolean expectedResult2 = true;
        boolean actualResult2 = Worksheet1.sorted(sorted2);
        assertEquals(expectedResult2, actualResult2, "error in the sorted() method.");

        boolean expectedResult3 = false;
        boolean actualResult3 = Worksheet1.sorted(mixed);
        assertEquals(expectedResult3, actualResult3, "error in the sorted() method.");

        boolean expectedResult4 = true;
        boolean actualResult4 = Worksheet1.sorted(empty);
        assertEquals(expectedResult4, actualResult4);

    }

    /**
     * Testing the merge() method.
     * Tests the method with two given sorted lists as input.
     * Tests the method with a given sorted list and an empty list.
     */
    @Test
    public void test7() {
        List<Integer> expectedList = new List<>(9, new List<>(8, new List<>(8, new List<>(6, new List<>(6, new List<>
                (5, new List<>(5, new List<>(2, new List<>(1, new List<>(0, new List<>()))))))))));
        List<Integer> actualList = Worksheet1.merge(sorted1, sorted2);
        assertEquals(expectedList, actualList, "error in the merge() method.");

        List<Integer> expectedList2 = new List<>(6, new List<>(6, new List<>(2, new List<>(1, new List<>(0, new List<>())))));
        List<Integer> actualList2 = Worksheet1.merge(empty, sorted2);
        assertEquals(expectedList2, actualList2, "error in merge() method.");

        List<Integer> expectedList3 = new List<>(9, new List<>(8, new List<>(8, new List<>(5, new List<>(5, new List<>())))));
        List<Integer> actualList3 = Worksheet1.merge(sorted1, empty);
        assertEquals(expectedList3, actualList3, "error in merge() method.");
    }

    /**
     * Testing the removeDuplicates() method.
     * Tests are on two different sorted lists.
     */
    @Test
    public void test8() {
        List<Integer> expectedList = new List<>(9, new List<>(8, new List<>(5, new List<>())));
        List<Integer> actualList = Worksheet1.removeDuplicates(sorted1);
        assertEquals(expectedList, actualList, "error in the removeDuplicates() method.");

        List<Integer> expectedList2 = new List<>(6, new List<>(2, new List<>(1, new List<>(0, new List<>()))));
        List<Integer> actualList2 = Worksheet1.removeDuplicates(sorted2);
        assertEquals(expectedList2, actualList2, "error in the removeDuplicates() method.");

    }

    /**
     * Tests the power() method.
     * Four tests in total with different values.
     * Includes a test with zero as the exponent.
     */
    @Test
    public void test9() {
        int expectedResult = 625;
        int actualResult = Worksheet1.power(5, 4);
        assertEquals(expectedResult, actualResult, "error in the power() method.");

        int expectedResult2 = 96059601;
        int actualResult2 = Worksheet1.power(99, 4);
        assertEquals(expectedResult2, actualResult2, "error in the power() method.");

        int expectedResult3 = 1;
        int actualResult3 = Worksheet1.power(10, 0);
        assertEquals(expectedResult3, actualResult3, "error in the power() method.");

        int expectedResult4 = 1;
        int actualResult4 = Worksheet1.power(0, 0);
        assertEquals(expectedResult4, actualResult4, "error in the power() method.");
    }

    /**
     *  Tests the fastPower() method.
     *  Tests are on the same values as power() in order
     *  to ensure the two different methods provide the
     *  same results.
     */
    @Test
    public void test10(){
        int expectedResult = 625;
        int actualResult = Worksheet1.fastPower(5, 4);
        assertEquals(expectedResult, actualResult, "error in the fastPower() method.");

        int expectedResult2 = 96059601;
        int actualResult2 = Worksheet1.fastPower(99, 4);
        assertEquals(expectedResult2, actualResult2, "error in the fastPower() method.");

        int expectedResult3 = 1;
        int actualResult3 = Worksheet1.fastPower(10, 0);
        assertEquals(expectedResult3, actualResult3, "error in the fastPower() method.");

        int expectedResult4 = 1;
        int actualResult4 = Worksheet1.fastPower(0, 0);
        assertEquals(expectedResult4, actualResult4, "error in the fastPower() method.");
    }

}


