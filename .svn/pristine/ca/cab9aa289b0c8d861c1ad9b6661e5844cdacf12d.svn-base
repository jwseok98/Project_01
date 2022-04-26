package sample.dataflow.commandinjection;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String batchCommand = request.getParameter("batchcmd");
		
		String[] command = batchCommand.split(",");
		
		try {
			execute(command);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			BatchCommandExecutor executor = new BatchCommandExecutor();
			executor.execute(command);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void execute(String[] command) throws Exception {
		// POTENTAIL FLAW
		Process process = Runtime.getRuntime().exec(command);
		process.waitFor();
	}
	
}
