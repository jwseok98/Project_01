/*
 * 참조: 행정안전부 SW개발보안가이드 - SQL삽입 - 안전한코드
 */
package sample.cwe89;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class SQLi_servlet_hibernate_basic_good02 extends HttpServlet {
	
	private static final long serialVersionUID = 3210839740851249786L;
	
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("usernm");
		String password = request.getParameter("passwd");
		
		String loginHql = "from t_user where username=:name and password=:passwd";
		
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		
		SessionFactory sessionFactory = null;
		Session session = null;
		
		try {
			sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
			session = sessionFactory.openSession();
			
			/* FIX.. */
			Query query = session.createQuery(loginHql);
			query.setParameter("name", username);
			query.setString("passwd", password);
			
			List list = query.list();
		} catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy( registry );
		}
	}
}