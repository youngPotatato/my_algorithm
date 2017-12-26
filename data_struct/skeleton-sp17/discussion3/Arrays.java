public class Arrays{
	public static int[] insert(int[] x, int item, int position){
		int yy[] = new int[x.length + 1];
		System.arraycopy(x,0,yy,0,position);
		yy[position] = item;
		while(position < x.length) {
			yy[position+1] = x[position];
			position ++ ;
		}
		return yy;
	}

	public static void reverse(int[] x) {
		int j = x.length -1;
		int yy;
		for(int i = 0; i< (int)(x.length/2);i ++){
			yy = x[j];
			x[j] = x[i];
			x[i] = yy;
			j--;
		}
	}

	public static void main(String [] args){
		int x[] = {1,3,4,66};
		int y[] = insert(x,5,4);
		for(int temp : y){
			System.out.println(temp);
		}


		reverse(y);
		for(int temp : y){
			System.out.println(temp);
		}
	}
}
