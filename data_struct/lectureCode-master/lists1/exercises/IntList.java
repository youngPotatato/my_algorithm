public class IntList {
	public int first;
	public IntList rest;

	public IntList(int f, IntList r) {
		first = f;
		rest = r;
	}

	/** Return the size of the list using... recursion! */
	public int size() {
		if (rest == null) {
			return 1;
		}
		return 1 + this.rest.size();
	}

	/** Return the size of the list using no recursion! */
	public int iterativeSize() {
		IntList p = this;
		int totalSize = 0;
		while (p != null) {
			totalSize += 1;
			p = p.rest;
		}
		return totalSize;
	}

	/** Returns the ith value in this list.*/
	public int get(int i) {
		if(i == 1){
			return this.first;
		}else{
			i --;
			return this.rest.get(i);
		}

	}

    	public static IntList incrList(IntList L, int x) {
    	    /* Your code here. */
	    	IntList s;
    	        if(L == null){
    	    	    return null;
    	        }else{
    	    	s = new IntList(L.first+x,incrList(L.rest,x));
    	        }
    	    return s;        
    	}

    /** Returns an IntList identical to L, but with
      * each element incremented by x. Not allowed to use
      * the 'new' keyword. */
    	public static IntList dincrList(IntList L, int x) {
    	    /* Your code here. */
    	    while(L.rest!= null){
    	    	L.first += x;
    	    	L = L.rest;
    	    }
    	    return L;
    	}

	public static void main(String[] args) {
		IntList L = new IntList(37, null);
		L = new IntList(35, L);
		L = new IntList(33, L);
		L = new IntList(31, L);
		L = new IntList(29, L);
		L = new IntList(27, L);
		L = new IntList(25, L);

		System.out.println(L.get(3));
		System.out.println(L.get(4));

		IntList L1 = incrList(L,3);
		IntList L2 = dincrList(L,3);
	}
} 
