public class SLListLauncher {
	public static void main(String[] args) {
		SLList<String> s1 = new SLList<>("a0");
		s1.addLast("a1");
		s1.addLast("a2");
		s1.addLast("a3");
		s1.print();
		s1.reverse();

		s1.print();
	}
} 
