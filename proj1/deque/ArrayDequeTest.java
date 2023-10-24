package deque;

import org.junit.Test;

import java.lang.reflect.Array;

import static org.junit.Assert.*;

public class ArrayDequeTest {

    @Test
    public void addIsEmptySizeTest(){

        ArrayDeque<String> ald1 = new ArrayDeque<>();

        assertTrue("A newly initialized LLDeque should be empty", ald1.isEmpty());
        ald1.addFirst("front");

        assertEquals(1, ald1.size());
        assertFalse("lld1 should now contain 1 item", ald1.isEmpty());

        ald1.addLast("middle");
        assertEquals(2, ald1.size());

        ald1.addLast("back");
        assertEquals(3, ald1.size());

        System.out.println("print out the deque: ");
        ald1.printDeque();
    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {


        ArrayDeque<Integer> ald1 = new ArrayDeque<>();
        // should be empty
        assertTrue("ald1 should be empty upon initialization", ald1.isEmpty());

        ald1.addFirst(10);
        // should not be empty
        assertFalse("ald1 should contain 1 item", ald1.isEmpty());

        ald1.removeFirst();
        // should be empty
        assertTrue("ald1 should be empty after removal", ald1.isEmpty());

    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {

        ArrayDeque<Integer> ald1 = new ArrayDeque<>();

        ald1.removeLast();
        ald1.removeFirst();
        ald1.removeLast();
        ald1.removeFirst();

        int size = ald1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);

    }

    @Test
    /* Check if you can create LinkedListDeques with different parameterized types*/
    public void multipleParamTest() {

        ArrayDeque<String> ald1 = new ArrayDeque<>();
        ArrayDeque<Double> ald2 = new ArrayDeque<>();
        ArrayDeque<Boolean> ald3 = new ArrayDeque<>();

        ald1.addFirst("string");
        ald2.addFirst(3.14159);
        ald3.addFirst(true);

        String s = ald1.removeFirst();
        double d = ald2.removeFirst();
        boolean b = ald3.removeFirst();

    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {

        ArrayDeque<Integer> ald1 = new ArrayDeque<>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertNull("Should return null when removeFirst is called on an empty Deque,", ald1.removeFirst());
        assertNull("Should return null when removeLast is called on an empty Deque,", ald1.removeLast());


    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {

        ArrayDeque<Integer> ald1 = new ArrayDeque<>();
        for (int i = 0; i < 1000000; i++) {
            ald1.addLast(i);
        }

        for (int i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (int) ald1.removeFirst());
        }

        for (int i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (int) ald1.removeLast());
        }


    }


}
