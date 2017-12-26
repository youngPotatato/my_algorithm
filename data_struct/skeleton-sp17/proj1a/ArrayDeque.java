public class ArrayDeque <type_yy>{
//public class ArrayDeque {
    //consider not doing resizing at all until you know
    // your code works without it. Resizing is a performance optimization
     //at last change it to generic

        private type_yy items[];
        private int nextFirst;
        private int nextLast;
        //sentinel
        private int size;
    /**
     * the starting size of your array should be 8
     * Zero argument constructor which creat an empty deque
     *
     */
    public ArrayDeque(){
        items = (type_yy[]) new Object[8];
        nextFirst = 7;
        nextLast = 0;
        size = 0;
    }

    /**
     * Adds an item to the front of the Deque
     * must take constant time, except during resizing operations
     * the starting size of your array should be 8
     */
    public void addFirst(type_yy tt){
            items[nextFirst] = tt;
            if(nextFirst == nextLast){
                this.doubleSize(true);
            }
            nextFirst = (nextFirst -1)&(items.length -1);
            size++;
    }

    private void doubleSize(boolean i){
        type_yy[] itemsNew  = (type_yy[]) new Object[items.length *2];
        if(i) {
            System.arraycopy(items, 0, itemsNew, 0, nextFirst);
            System.arraycopy(items, nextFirst, itemsNew, items.length + nextFirst, items.length - nextFirst);
        }else{
            System.arraycopy(items, 0, itemsNew, 0, nextFirst+1);
            System.arraycopy(items, nextFirst+1, itemsNew, items.length + nextFirst+1, items.length - nextFirst -1);
        }
        nextFirst = nextFirst + items.length;
        items = itemsNew;
    }

    /**
     * the starting size of your array should be 8
     *Adds an item to the back of the Deque
     * must take constant time, except during resizing operations
     */
    public void addLast(type_yy tt) {
        items[nextLast] = tt;
        if(nextFirst == nextLast){
            this.doubleSize(false);
        }
        nextLast = (nextLast + 1)&(items.length-1);
        size++;
    }

    /**
     *Returns true if deque is empty, false otherwise
     *
     */
    public boolean isEmpty() {
        return (size == 0);
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
        int i = nextFirst;
        int j = 0;
        while(j != size) {
            System.out.print(items[(i =(i+1)&(items.length-1)) ] +  " ");
            j++;
        }
        System.out.println();
    }

    /**The amount of memory that your program uses at any given time must be
     *proportional to the number of items.
     * For example, if you add 10,000 items to the Deque, and then remove 9,999 items,
     * you shouldn't still be using an array of length 10,000ish
     * for arrays of length 16 or more, your usage factor should always be at least 25%.
     * for usage factor can be arbitrarily low
     */

    /**
     *Removes and returns the item at the front of the Deque. If no such item exists
     *returns null
     * must take constant time, except during resizing operations
     * no loop or recursion, constant time, not depend on the size of the deque
     */
    public type_yy removeFirst() {
        size --;
        nextFirst = (nextFirst + 1)&(items.length-1);
        if(
                ((nextFirst-nextLast+1)
                        ==
                (items.length*3/4))
        )
            shinrkSize(true,true);
        else if (
                (nextLast-nextFirst-1)//nextLast-nextFirst+1 - 2
                ==
                (items.length/4)
                )
        {
            shinrkSize(true,false);
        }
        return items[0];
    }
    private void shinrkSize(boolean i,boolean j) {
        type_yy[] itemsNew = (type_yy[]) new Object[items.length / 2];
        if (i) {
            if (j) {
                System.arraycopy(items, 0, itemsNew, 0, nextLast);
                System.arraycopy(items, nextFirst, itemsNew, nextFirst - items.length / 2, items.length - nextFirst);
                nextFirst = nextFirst - items.length / 2;
                items = itemsNew;
            } else {
                System.arraycopy(items, nextFirst, itemsNew, 0, nextLast - nextFirst);
                nextFirst = 0;
                nextLast = items.length / 4 + 1;
                items = itemsNew;
            }
        } else {
            if (j) {
                System.arraycopy(items, 0, itemsNew, 0, nextLast + 1);
                System.arraycopy(items, nextFirst + 1, itemsNew, nextFirst - items.length / 2, items.length - 1 - nextFirst);
                nextFirst = nextFirst - items.length / 2;
                items = itemsNew;
            } else {
                System.arraycopy(items, nextFirst + 1, itemsNew, 1, nextLast - nextFirst);
                nextFirst = 0;
                nextLast = items.length / 4 + 1;
                items = itemsNew;
            }
        }
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
     * must take constant time, except during resizing operations
     */
    public type_yy removeLast() {
        size --;
        nextLast = (nextLast - 1)&(items.length-1);
        if(
                ((nextFirst-nextLast+1)
                        ==
                        (items.length*3/4))
                )
            shinrkSize(false,true);
        else if (
                (nextLast-nextFirst-1)//nextLast-nextFirst+1 - 2
                        ==
                        (items.length/4)
        ){
            shinrkSize(false,false);
        }
        return items[nextLast];
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so
     *forth. If no such item exists, returns null. Must not alter the deque!
     * use iteration
     */
    public type_yy get(int index) {
        if(index > size-1)
            return null;
        return items[(nextFirst + 1 + index)&(items.length -1 )];
    }

}
