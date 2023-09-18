import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.FunctionalQueue;
import repository.IFunctionalQueue;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerFunctionalQueueTest {
    private IFunctionalQueue<Integer> queue = new FunctionalQueue<>();

    @BeforeEach
    public void setUp() {
        queue = new FunctionalQueue<>();
    }

    @Test
    public void testPush() {
        queue.push(1);
        queue.push(2);
        queue.push(3);
        assertEquals(3, queue.size());
    }

    @Test
    public void testPop() {
        queue.push(1);
        Integer poppedValue = queue.pop();
        assertAll(
                () -> assertEquals(1, poppedValue),
                () -> assertEquals(0, queue.size())
        );
    }

    @Test
    public void testPopWhenEmpty() {
        Integer poppedValue = queue.pop();
        assertAll(
                () -> assertNull(poppedValue),
                () -> assertEquals(0, queue.size())
        );
    }

    @Test
    public void testFindWhenNotFound() {
        queue.push(1);
        queue.push(2);
        queue.push(3);
        Integer found = queue.find(x -> x > 3);
        assertNull(found);
    }

    @Test
    public void testFindIndexWhenNotFound() {
        queue.push(1);
        queue.push(2);
        queue.push(3);
        int foundIndex = queue.findIndex(x -> x > 3);
        assertEquals(-1, foundIndex);
    }

    @Test
    public void testFindLastWhenNotFound() {
        queue.push(1);
        queue.push(2);
        queue.push(3);
        Integer found = queue.findLast(x -> x > 3);
        assertNull(found);
    }

    @Test
    public void testFindLastIndexWhenNotFound() {
        queue.push(1);
        queue.push(2);
        queue.push(3);
        int foundIndex = queue.findLastIndex(x -> x > 3);
        assertEquals(-1, foundIndex);
    }

    @Test
    public void testFilter() {
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        List<Integer> filtered = queue.filter(x -> x > 3);
        assertAll(
                () -> assertEquals(2, filtered.size()),
                () -> assertTrue(filtered.contains(4)),
                () -> assertTrue(filtered.contains(5))
        );
    }

    @Test
    public void testMap() {
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        List<Integer> mapped = queue.map(x -> x * 2);
        assertAll(
                () -> assertEquals(5, mapped.size()),
                () -> assertTrue(mapped.contains(2)),
                () -> assertTrue(mapped.contains(4)),
                () -> assertTrue(mapped.contains(6)),
                () -> assertTrue(mapped.contains(8)),
                () -> assertTrue(mapped.contains(10))
        );
    }

    @Test
    public void testFind() {
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        Integer found = queue.find(x -> x > 3);
        assertEquals(4, found);
    }

    @Test
    public void testFindIndex() {
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        int foundIndex = queue.findIndex(x -> x > 3);
        assertEquals(3, foundIndex);
    }

    @Test
    public void testFindLast() {
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        Integer found = queue.findLast(x -> x > 3);
        assertEquals(5, found);
    }

    @Test
    public void testFindLastIndex() {
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        int foundIndex = queue.findLastIndex(x -> x > 3);
        assertEquals(4, foundIndex);
    }

    @Test
    public void testForEach() {
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        List<Integer> integers = new ArrayList<>();
        queue.forEach(x -> {
            integers.add(x);
            return null;
        });
        assertAll(
                () -> assertEquals(5, integers.size()),
                () -> assertTrue(integers.contains(1)),
                () -> assertTrue(integers.contains(2)),
                () -> assertTrue(integers.contains(3)),
                () -> assertTrue(integers.contains(4)),
                () -> assertTrue(integers.contains(5))
        );
    }

    @Test
    public void testSort() {
        queue.push(5);
        queue.push(4);
        queue.push(3);
        queue.push(2);
        queue.push(1);
        List<Integer> sorted = queue.sort(x -> x);
        assertAll(
                () -> assertEquals(5, sorted.size()),
                () -> assertEquals(1, sorted.get(0)),
                () -> assertEquals(2, sorted.get(1)),
                () -> assertEquals(3, sorted.get(2)),
                () -> assertEquals(4, sorted.get(3)),
                () -> assertEquals(5, sorted.get(4))
        );
    }

    @Test
    public void testIsEmpty() {
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testSize() {
        queue.push(1);
        queue.push(2);
        queue.push(3);
        assertEquals(3, queue.size());
    }
}
