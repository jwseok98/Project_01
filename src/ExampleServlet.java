import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExampleServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String number = request.getParameter("number");
		
		String number2 = request.getParameter("number2");
		
		// Integer.parseInt 함수는 문자열형의 숫자를 정수형으로 변환하는 역할.
		// 정상 예) "1234" => 1234
		// 오류 예) "A1234" => 오류 (NumberFormatException 발생)
		// 오류 발생시 try-catch 구문으로 잡지 않는 경우 현재 함수 ( doPost ) 를 호출한 호출자에게 오류를 던짐.
		// 현 ( doPost ) 함수를 호출한 호출자는 Apache Tomcat 이므로 Apache Tomcat의 오류처리 매커니즘이 발동됨.
		// Apache Tomcat의 오류처리를 메커니즘은 상태코드를 500으로 설정하고 오류메시지를 응답본문에 출력하는것임.
		// 만약, 아래와 같이 try-catch 구문으로 예외를 처리하는 경우 응답상태코드는 200인 정상코드로 설정됨.
		int iNumber = Integer.parseInt(number);
		
		// try-catch 구문으로 예외를 직접 처리하는 코드
		try {
			int iNumber2 = Integer.parseInt(number2);
		} catch (NumberFormatException nfe) {
			response.getWriter().println(nfe.getMessage());
		}
		
	}
}