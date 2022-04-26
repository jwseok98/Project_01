
public class InfinitLoop {
	
	public void bad() {
		for (;;) {
			System.out.println("a");
		}
	}
	
	public void bad2() {
		while (true) {
			System.out.println("b");
		}
	}
	
	public void bad3() {
		int i = 0;
		
		while (i < 5847) {
			System.out.println("dd");
		}
	}
}
