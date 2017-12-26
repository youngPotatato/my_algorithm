package synthesizer;

public abstract class AbstractBoundedQueue<t> implements BoundedQueue<t>{
    protected int fillCount;
    protected int capacity;
}
