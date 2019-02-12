import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import primeroo.*;

/* EJERCICIO 3. Visualiza los nombres de los empleados junto 
 * con el departamento al que pertenecen. (Ayuda: consulta en
 * el manual de HQL cómo realizar un JOIN. Observarás que es 
 * muy parecido a SQL) */

public class Bateria5_EX03_Hibernate {
	public static void main(String[] args) {
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
		String sql = "from Emple as e join Depart as d on e.depart.deptNo = d.deptNo";
		Query q = session.createQuery(sql);
		List<?> filas = q.list();
		Iterator<?> filasIterator = filas.iterator();
		Emple emple;
		Depart depart;
		while (filasIterator.hasNext()) {
			Object[] fila = (Object[]) filasIterator.next();
			emple = (Emple)fila[0];
			depart = (Depart)fila[1];
			System.out.println("Apellido: " + emple.getApellido() + " Depart: " + depart.getDnombre());
		}
		session.close();

	}
}
