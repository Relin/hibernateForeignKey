package be.relin.hibernateForeignKey;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import be.relin.hibernateForeignKey.bean.A;
import be.relin.hibernateForeignKey.bean.B;
import be.relin.hibernateForeignKey.bean.C;
import be.relin.hibernateForeignKey.util.HibernateUtil;

public class AppMix {
	
	public static void main(String[] args) {
		
		System.out.println("Mixing");
		Session session = HibernateUtil.getSessionFactory().openSession();
 
		session.beginTransaction();
		
		try {
			A a = new A();
			B b = new B();
			C c = new C();
			
			a.setNom("popo");
			
			b.setInfo("info");
			
			a.getB().add(b);
			
			c.setInfo("ppp");
			c.setA(a);
			
			session.save(a);
			session.save(c);
			
			session.getTransaction().commit();
		}
		catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		System.out.println("Done");
	
	}

}
