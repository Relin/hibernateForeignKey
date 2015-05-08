package be.relin.hibernateForeignKey;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import be.relin.hibernateForeignKey.bean.Bool;
import be.relin.hibernateForeignKey.util.HibernateUtil;

public class AppBool {

	public static void main(String[] args) {
		System.out.println("bool in db");
		Session session = HibernateUtil.getSessionFactory().openSession();
 
		session.beginTransaction();
		try {
			Bool b = new Bool();
			b.setTruefasle(false);
			session.save(b);
			
			Bool bret = (Bool) session.get(Bool.class, 1);
			System.out.println(bret.isTruefasle());
			
			session.getTransaction().commit();
		}
		catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		System.out.println("Done");
	}
}
