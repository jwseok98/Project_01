package sample.cwe676;

public class Basic_ThreadStop {
	

	public void bad()
	{
		Thread thread = new Thread();
		thread.start();
		
		// 중요도가 떨어져 더 이상 사용되지 않고 앞으로는 사라지게 될 메소드인 stop을 사용하여 취약하다
		thread.stop();
	}
	
	public void good()
	{
		Thread thread = new Thread();
		thread.start();
		
		//  stop 대신 interrupt 를 사용한다.
		thread.interrupt();
	}
}
