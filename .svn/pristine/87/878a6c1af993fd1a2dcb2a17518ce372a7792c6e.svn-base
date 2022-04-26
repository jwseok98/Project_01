package sample.dataflow.commandinjection;

public class BatchCommandExecutor {
	
	
	public void execute(String[] command) throws Exception {
		// POTENTAIL FLAW
		Process process = Runtime.getRuntime().exec(command);
		process.waitFor();
	}

}
