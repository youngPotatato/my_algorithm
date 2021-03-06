import java.util.LinkedList;

/**
 * Isn't this solution kinda... cheating? Yes.
 * The aesthete will be especially alarmed by the fact that this
 * supposed ArrayDeque is actually using a LinkedList. SAD!
 */
public class ArrayDequeSolution<Item> extends LinkedList<Item> implements Deque<Item>{
    @Override
    public void printDeque() {
        System.out.println("dummy");
    }

    public Item getRecursive(int i) {
        return get(i);
    }
    @Override
    public void addFirst(Item i){
        super.addFirst(i);
    }
    @Override
    public void addLast(Item i){
        super.addLast(i);
    }
    @Override
    public boolean isEmpty(){
        return super.isEmpty();
    }
    @Override
    public int size(){
        return super.size();
    }
    @Override
    public Item get(int index){
        return get(index);
    }

    @Override
    public Item removeFirst() {
        try {
            return super.removeFirst();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Item removeLast() {
        try {
            return super.removeLast();
        } catch (Exception e) {
            return null;
        }
    }
}
