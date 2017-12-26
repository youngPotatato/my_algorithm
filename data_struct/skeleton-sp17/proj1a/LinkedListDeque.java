public class LinkedListDeque<type_yy> {

    //at last change it to generic
    private class Node {
        public type_yy item;
        public Node prev;
        public Node next;
        public Node(type_yy i, Node pre, Node nex) {
            item = i;
            prev = pre;
            next = nex;
        }
    }
    //sentinel
    private Node sentinel;
    int size;

    /**
     * Zero argument constructor which creat an empty deque
     *
     */
    public LinkedListDeque(){
        sentinel = new Node(null,null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }


    /**
     * Adds an item to the front of the Deque
     * no loop or recursion, constant time, not depend on the size of the deque
     */
    public void addFirst(type_yy tt){
        Node ff = new Node(tt,sentinel,sentinel.next);
        sentinel.next.prev = ff;
        sentinel.next = ff;
        size ++;
    }

    /**
     *Adds an item to the back of the Deque
     * no loop or recursion, constant time, not depend on the size of the deque
     */
    public void addLast(type_yy tt) {
        Node ll = new Node(tt,sentinel.prev,sentinel);
        sentinel.prev.next = ll;
        sentinel.prev = ll;
        size ++;
    }

    /**
     *Returns true if deque is empty, false otherwise
     *
     */
    public boolean isEmpty() {
        return (sentinel.next == sentinel);
    }

    /**
     *Returns the number of items in the Deque
     *constant time
     */
    public int size() {
        return size;
    }

    /**
     *Prints the items in the Deque from first to last, separated by a space
     *
     */
    public void printDeque() {
        Node ii = sentinel.next;
        while(ii!=sentinel) {
            System.out.print(ii.item + " ");
            ii = ii.next;
        }
        System.out.println();
    }

    /**The amount of memory that your program uses at any given time must be
     *proportional to the number of items.
     * For example, if you add 10,000 items to the Deque, and then remove 9,999 items,
     * the resulting size should be more like a deque with 1 item than 10,000.
     * Do not maintain references to items that are no longer in the Deque.
     */
    /**
     *Removes and returns the item at the front of the Deque. If no such item exists
     *returns null
     * no loop or recursion, constant time, not depend on the size of the deque
     */
    public type_yy removeFirst() {
        if(sentinel.next == sentinel)
            return null;
        type_yy i = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size --;
        return i;
    }

    /**The amount of memory that your program uses at any given time must be
     *proportional to the number of items.
     * For example, if you add 10,000 items to the Deque, and then remove 9,999 items,
     * the resulting size should be more like a deque with 1 item than 10,000.
     * Do not maintain references to items that are no longer in the Deque.
     */
    /**
     *Removes and returns the item at the back of the Deque. If no such item exists
     *returns null
     * no loop or recursion, constant time, not depend on the size of the deque
     */
    public type_yy removeLast() {
        if(sentinel.next == sentinel)
            return null;
        type_yy i = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size --;
        return i;
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so
     *forth. If no such item exists, returns null. Must not alter the deque!
     * use iteration
     */
    public type_yy get(int index) {
        if(index > size-1)
            return null;
        Node kk = sentinel.next;
        while(index !=0){
            kk = kk.next;
            index --;
        }
        return kk.item;
    }

    /**
     *Same as get, but uses recursion
     */
    public type_yy getRecursive(int index) {
        if(index > size-1)
            return null;
        Node kk = sentinel.next;
        if(index != 0) {
            kk = kk.next;
            return getRecursive(--index);
        }else {
            return kk.item;
        }
    }
;}
