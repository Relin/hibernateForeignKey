package be.relin.hibernateForeignKey;

import org.hibernate.Session;

import be.relin.hibernateForeignKey.bean.Aaaa;
import be.relin.hibernateForeignKey.bean.Bbbb;
import be.relin.hibernateForeignKey.util.HibernateUtil;

public class App3 {
	
	public static void main(String[] args) {
		System.out.println("0-N <=> 0-N");
		Session session = HibernateUtil.getSessionFactory().openSession();
 
		session.beginTransaction();
		
		Aaaa a1 = new Aaaa();
		//a1.setAaaa_id(101);
		a1.setNom("aaaa1");
		
		Aaaa a2 = new Aaaa();
		//a2.setAaaa_id(102);
		a2.setNom("aaaa2");
		
		Bbbb b1 = new Bbbb();
		//b1.setBbbb_id(101);
		b1.setInfo("bbbb1");
		
		Bbbb b2 = new Bbbb();
		//b2.setBbbb_id(102);
		b2.setInfo("bbbb2");
		
		
		a1.getBbs().add(b1);
		a1.getBbs().add(b2);
		
		a2.getBbs().add(b1);
		a2.getBbs().add(b2);
		
		session.save(a1);
		session.save(a2);
		
		session.getTransaction().commit();
		
		System.out.println("Done");
	}
}
