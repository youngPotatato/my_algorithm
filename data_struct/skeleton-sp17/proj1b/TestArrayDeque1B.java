import static org.junit.Assert.*;
import org.junit.Test;
public class TestArrayDeque1B {

    @Test
    public void randomTest(){
        StudentArrayDeque<Integer> st = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> sol = new ArrayDequeSolution<>();

        OperationSequence opS = new OperationSequence();
        int sizeTemp = 0;

        for(int i = 0; i < 199; i = i+1) {
            double temp = StdRandom.uniform(); //temp [0,1)
            if((temp >= 0) && (temp < 0.25)){// addFirst
                DequeOperation DO = new DequeOperation("addFirst",i);
                st.addFirst(i);
                sol.addFirst(i);
                opS.addOperation(DO);
                sizeTemp ++;
            }
            if((temp >= 0.25) && (temp < 0.5)){// addLast
                DequeOperation DO = new DequeOperation("addLast",i);
                st.addLast(i);
                sol.addLast(i);
                opS.addOperation(DO);
                sizeTemp ++;
            }
            if((temp >= 5) && (temp < 0.75)){// removeFirst
                if(sizeTemp > 0) {
                    DequeOperation DO = new DequeOperation("removeFirst");
                    opS.addOperation(DO);
                    assertEquals(opS.toString(),st.removeFirst(),sol.removeFirst());
                    sizeTemp--;
                }
            }
            if((temp >= 0.75) && (temp < 1)){// removeFirst
                if(sizeTemp > 0) {
                    DequeOperation DO = new DequeOperation("removeLast");
                    opS.addOperation(DO);
                    assertEquals(opS.toString(),sol.removeLast(),st.removeLast());
                    sizeTemp--;
                }
            }
        }
    }
}
