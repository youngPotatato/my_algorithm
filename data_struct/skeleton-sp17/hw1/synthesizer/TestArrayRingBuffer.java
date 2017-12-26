package synthesizer;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    //@Test
    //public void someTest() {
    //    ArrayRingBuffer<Integer> arb = new ArrayRingBuffer(10);
    //    for(int i = 1; i<= 10; i++)
    //        arb.enqueue(i);
    //    for(int i = 1; i<= 10; i++)
    //        System.out.println(arb.peek() + arb.dequeue());
    //}
    @Test(expected = RuntimeException.class)
    public void test2(){
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(5);
        for(int i = 1; i<= 5; i++)
            arb.enqueue(i);
        arb.enqueue(6);
    }

    @Test(expected = RuntimeException.class)
    public void test3(){
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(1);
        arb.dequeue();
    }

    @Test
    public void testIter(){
        ArrayRingBuffer<Integer> arb ;
        for(int jj = 13; jj>=0; jj--) {
             arb = new ArrayRingBuffer<>(15);
            int ii = 0;
            while (ii < jj) {
                arb.enqueue(ii);
                ii++;
            }
            Iterator it = arb.iterator();
            while (it.hasNext()) {
                System.out.print(it.next());
            }
            System.out.println();
        }
        //for(int temp : arb)
        //    System.out.println(temp);
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
