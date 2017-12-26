// TODO: Make sure to make this class a part of the synthesizer package
package synthesizer;
import java.util.Iterator;

//TODO: Make sure to make this class and all of its methods public
//TODO: Make sure to make this class extend AbstractBoundedQueue<t>
public class ArrayRingBuffer<tt> extends AbstractBoundedQueue<tt>{
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private tt[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
        this.capacity = capacity;
        fillCount = 0;
        first = 0;
        last = 0;
        rb = (tt[]) new Object[capacity];
    }
    public ArrayRingBuffer(int capacity, tt ini_value){
        this.capacity = capacity;
        fillCount = 0;
        first = 0;
        last = 0;
        rb = (tt[]) new Object[capacity];
        for(tt temp :rb) {
            temp = ini_value;
        }
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    @Override
    public void enqueue(tt x) {
        if(isFull()){
            throw new RuntimeException("Ring buffer overflow");
        }
        rb[last] = x;
        // TODO: Enqueue the item. Don't forget to increase fillCount and update last.
        fillCount ++;
        last = (last+1)%capacity;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    @Override
    public tt dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and update
        if(isEmpty()){
            throw new RuntimeException("Ring buffer underflow");
        }
        tt result = rb[first];
        fillCount --;
        first = (first+1)%capacity;
        return result;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    @Override
    public tt peek() {
        // TODO: Return the first item. None of your instance variables should change.
        return rb[first];
    }

    @Override
    public int capacity(){
        return capacity;
    }

    @Override
    public int fillCount(){
       return fillCount;
    }

    public Iterator<tt> iterator(){
        return new my_iterator();
    }

    // TODO: When you get to part 5, implement the needed code to support iteration.
    private class my_iterator implements Iterator<tt>{
        private ArrayRingBuffer<tt> copy_buffer;
        public my_iterator(){
            copy_buffer = new ArrayRingBuffer<>(capacity);
            copy_buffer.fillCount = fillCount;
            copy_buffer.first = first;
            copy_buffer.last = last;
            for(int i = 0; i < capacity;i++) {
                copy_buffer.rb[i] = rb[i];
            }
        }
        public boolean hasNext(){
            return (!copy_buffer.isEmpty());
        }
        public tt next(){
            return copy_buffer.dequeue();
        }
    }
}
