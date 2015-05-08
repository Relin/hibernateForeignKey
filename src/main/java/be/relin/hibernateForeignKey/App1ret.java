package be.relin.hibernateForeignKey;

import java.awt.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import be.relin.hibernateForeignKey.bean.Autheur;
import be.relin.hibernateForeignKey.bean.Livre;
import be.relin.hibernateForeignKey.util.HibernateUtil;

public class App1ret {

	public static void main(String[] args) {
		System.out.println("0-1 <=> 0-N  ret");
		Session session = HibernateUtil.getSessionFactory().openSession();
 
		session.beginTransaction();
		
		try {
			Autheur auth = (Autheur) session.get(Autheur.class, 1);
			System.out.println(auth.getAutheur_id() +" - "+ auth.getName());
			
			System.out.println(auth.getLivres().size());
			for (Livre livre : auth.getLivres()) {
				System.out.println(livre.getLivre_id() + " " + livre.getNom());
			}
			
			
			java.util.List<Autheur> lAuth = session.createCriteria(Autheur.class).list();
			System.out.println(lAuth.size());
			for (Autheur autheur : lAuth) {
				System.out.println(autheur.getAutheur_id() + " " + autheur.getName());
			}
			
			session.getTransaction().commit();
		}
		catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		System.out.println("Done");
	}
}
