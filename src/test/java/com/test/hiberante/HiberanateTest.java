package com.test.hiberante;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author xiangqh
 *
 */
public class HiberanateTest {

	public static void main(String[] args) {

		ApplicationContext context = new FileSystemXmlApplicationContext(
				new String[]{"D:/workspace/OJ/web/WEB-INF/config/application.hibernate.xml"
				,"D:/workspace/OJ/web/WEB-INF/config/application-dao.xml"});

//		IProblemDao dao = (IProblemDao) context.getBean("problemDao");
//		Problem problem = dao.getProblem(1993);
//		System.out.println(problem.getDescription()+":"+problem.getTitle());
//		problem.setTitle("qwert");
//		dao.saveProblem(problem);
//		problem = dao.getProblem(1993);
//		System.out.println(problem.getDescription()+":"+problem.getTitle());

		SessionFactory factory = (SessionFactory) context.getBean("sessionFactory");
		Session session = factory.openSession();

		UserTest user = new UserTest();
//		Transaction tx = session.beginTransaction();
//		tx.begin();
//
//		user.setNick("123");
//		user.setUser_id("1");
//		session.save(user);
//		tx.commit();
		user = (UserTest) session.get(UserTest.class, "1");
		System.out.println(user);


	}
}
