package be.relin.hibernateForeignKey;

import org.hibernate.Session;

import be.relin.hibernateForeignKey.bean.Autheur;
import be.relin.hibernateForeignKey.bean.Livre;
import be.relin.hibernateForeignKey.util.HibernateUtil;


public class App {
	public static void main(String[] args) {
		System.out.println("0-1 <=> 0-N");
		Session session = HibernateUtil.getSessionFactory().openSession();
 
		session.beginTransaction();
		
		Autheur auth = new Autheur();
		auth.setAutheur_id(100);
		auth.setName("polo");
		session.save(auth);
		
		Livre livre = new Livre();
		livre.setLivre_id(100);
		livre.setNom("Boss");
		livre.setFk_auth(auth);
		auth.getLivres().add(livre);
		session.save(livre);
		
		session.getTransaction().commit();
		
		System.out.println("Done");
	}
}
