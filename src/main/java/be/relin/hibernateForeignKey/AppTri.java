package be.relin.hibernateForeignKey;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import be.relin.hibernateForeignKey.bean.T1;
import be.relin.hibernateForeignKey.bean.T2;
import be.relin.hibernateForeignKey.bean.T3;
import be.relin.hibernateForeignKey.util.HibernateUtil;

public class AppTri {

	public static void main(String[] args) {
		System.out.println("trois tables");
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		try {
			
//			T1 t1 = new T1();
//			T2 t2 = new T2();
//			T3 t3 = new T3();
//			
//			t1.setT1_id(1);
//			t1.setT1_val("segond T1");
//			t2.setT2_id(1);
//			t2.setT2_val("segond T2");
//			t3.setT3_id(1);
//			t3.setT3_val("segond T3");
//			
//			session.save(t2); //saving first the other item on DB to resolve FK probleme
//			session.save(t3); //saving first the other item on DB to resolve FK probleme
//			
//			t1.getT2T3().put(t2, t3);
////			t2.getT1T3().put(t1, t3);
////			t3.getT1T2().put(t1, t2);
//			
//			session.save(t1);
			
			
			T1 t = (T1) session.get(T1.class, 4);
			
			System.out.println(t.getT1_id() + " - " + t.getT1_val());
			
			printMap(t.getT2T3());
			
			Iterator it = t.getT2T3().entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        System.out.println(((T2)pair.getKey()).getT2_val() + " = " + ((T3)pair.getValue()).getT3_val());
		    }
			
			
			session.getTransaction().commit();
			
		}catch (HibernateException e) {
			System.out.println("erreur lors de la sauvegarde");
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		
		System.out.println("Done");
	}
	
	public static void printMap(Map mp) {
	    Iterator it = mp.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        System.out.println(pair.getKey() + " = " + pair.getValue());
	    }
	}
	
	
}
