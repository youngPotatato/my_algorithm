package synthesizer;
import java.util.*;

public class queueTest {
    public static void main(String[] args){
        Queue<Integer> aa = new ArrayDeque(10);
        int i = 0;
        for(int ii : aa) {
            ii = i++;
        }
        for(int ii : aa)
            System.out.print(ii);

    }
}
