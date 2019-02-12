import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import primeroo.*;

//EJERCICIO 2. Visualiza los datos del señor “ARROYO”

public class Bateria5_EX02_Hibernate {
	public static void main(String[] args) {
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
		String sql = "from Emple as e where e.apellido='ARROYO'";
		Query q = session.createQuery(sql);
		List<Emple> emples = q.list();
		Iterator<Emple> emplesIterator = emples.iterator();
		Emple emple;
		while (emplesIterator.hasNext()) {
			emple = emplesIterator.next();
			System.out.println("Apellido: " + emple.getApellido() + " Salario: " + emple.getSalario());
		}
		session.close();
	}
}
