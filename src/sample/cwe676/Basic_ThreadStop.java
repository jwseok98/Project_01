package sample.cwe676;

public class Basic_ThreadStop {
	

	public void bad()
	{
		Thread thread = new Thread();
		thread.start();
		
		// �߿䵵�� ������ �� �̻� ������ �ʰ� �����δ� ������� �� �޼ҵ��� stop�� ����Ͽ� ����ϴ�
		thread.stop();
	}
	
	public void good()
	{
		Thread thread = new Thread();
		thread.start();
		
		//  stop ��� interrupt �� ����Ѵ�.
		thread.interrupt();
	}
}
