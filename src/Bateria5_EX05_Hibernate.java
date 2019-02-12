import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import primeroo.*;

/* EJERCICIO 5. 5. Muestra el salario medio y el número de 
 * empleados por departamento */

public class Bateria5_EX05_Hibernate {
	public static void main(String[] args) {
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
		String sql = "select e.depart.dnombre, avg(salario), count(apellido) from Emple as e group by e.depart.deptNo";
		Query q = session.createQuery(sql);
		List<?> lista = q.list();
		Iterator<?> iterator = lista.iterator();
		while (iterator.hasNext()) {
			Object[] fila = (Object[]) iterator.next();
			System.out.println("Departamento: " + fila[0] + " Salario medio: " + fila[1] + " Nº Empleados: " + fila[2]);
		}
		session.close();
	}

}
