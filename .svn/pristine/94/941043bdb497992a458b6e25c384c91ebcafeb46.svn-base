package sample.cwe676;

public class Basic_ThreadRun {
	
	public void bad() throws Throwable{
		
		// 중요도가 떨어져 더 이상 사용되지 않고 앞으로는 사라지게 될 메소드인 Run을 사용하여 취약하다.		
		new Thread("KISA").run();
		new Thread("ABC").run();
	}
	
	public void good() throws Throwable{
		
		
		//  Run 대신 Start 를 사용한다.	
		new Thread("KISA").start();
		new Thread("ABC").start();
	}
	
}
