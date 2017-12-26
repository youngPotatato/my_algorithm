import static org.junit.Assert.*;
import org.junit.Test;
public class getAndRemoveLastTest {
    @Test
    public void testRemoveLast() {
        LinkedListDeque<String>  yy = new LinkedListDeque<>();
        yy.addFirst("a1");
        yy.addLast("a2");
        yy.printDeque();
        System.out.println(yy.removeLast());
        yy.printDeque();
        System.out.println(yy.removeLast());
        assertEquals(null,yy.removeLast());
    }

    @Test
    public void testGet() {
        LinkedListDeque<String>  yy = new LinkedListDeque<>();
        yy.addFirst("a1");
        yy.addLast("a2");
        assertEquals("a2",yy.get(1));
        assertEquals("a1",yy.get(0));
        assertEquals(null,yy.get(3));
    }
}
