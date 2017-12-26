 /** An SLList is a list of integers, which hides the terrible truth
   * of the nakedness within. */
public class SLList<LochNess> {	
	private class StuffNode {
		public LochNess item;
		public StuffNode next;

		public StuffNode(LochNess i, StuffNode n) {
			item = i;
			next = n;
		}
	} 

	private StuffNode first;
	private int size;

	public SLList(LochNess x) {
		first = new StuffNode(x, null);
		size = 1;
	}

 	/** Adds x to the front of the list. */
 	public void addFirst(LochNess x) {
 		first = new StuffNode(x, first);
 		size += 1;
 	}

 	/** Returns the first item in the list. */
 	public LochNess getFirst() {
 		return first.item; 		
 	}


	public void insert (LochNess item, int pos) {
		if(pos == 0) {
			addFirst(item);
			return;
		}
		StuffNode xx;
		xx = this.first;
		while(pos != 1) {
			xx = xx.next;
			pos --;

		}
		xx.next = new StuffNode(item,xx.next);

		size += 1;
	}
	 private void reve(int i) {
		 StuffNode tt = first;
		 LochNess ii;
		 while (i != 0) {
			 ii = tt.item;
			 tt.item = tt.next.item;
			 tt.next.item = ii;
			 tt = tt.next;
			 i--;
		 }
	 }
	public void reverse() {
 	        for (int jj = this.size -1; jj >0 ; jj --)
				reve(jj);
	}

	public void print(){
		StuffNode kk;
		kk = this.first;
		while(kk != null){
			System.out.println(kk.item);
			kk = kk.next;
		}
	}

 	/** Adds an item to the end of the list. */
 	public void addLast(LochNess x) {
 		size += 1;

 		StuffNode p = first;

 		/* Move p until it reaches the end of the list. */
 		while (p.next != null) {
 			p = p.next;
 		}

 		p.next = new StuffNode(x, null);
 	}

 	public int size() {
 		return size;
 	}
}
