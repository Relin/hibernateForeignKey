package be.relin.hibernateForeignKey;

import org.hibernate.Session;

import be.relin.hibernateForeignKey.bean.Detail;
import be.relin.hibernateForeignKey.bean.Personne;
import be.relin.hibernateForeignKey.util.HibernateUtil;

public class App2 {
	
	public static void main(String[] args) {
		System.out.println("0-1 <=> 1-1");
		Session session = HibernateUtil.getSessionFactory().openSession();
 
		session.beginTransaction();
		
		Personne perso = new Personne();
		//auth.setPersonne_id(100);
		perso.setNom("Raphael");
		
		Detail det = new Detail();
		//det.setDetail_id(100);
		det.setInfo("Dev");
		
		perso.setDetail(det);
		det.setPersonne(perso);
		
		session.save(perso);
		
		//---------------------------------------
		
		Personne perso1 = new Personne();
		//auth.setPersonne_id(100);
		perso1.setNom("Polo");
		
		Personne perso2 = new Personne();
		//auth.setPersonne_id(100);
		perso2.setNom("Lopo");
		
		Detail det2 = new Detail();
		//det.setDetail_id(100);
		det2.setInfo("Bingo");
		
		perso2.setDetail(det2);
		det2.setPersonne(perso2);
		
		session.save(perso1);
		session.save(perso2);
		
		
		session.getTransaction().commit();
		
		System.out.println("Done");
	}
}
