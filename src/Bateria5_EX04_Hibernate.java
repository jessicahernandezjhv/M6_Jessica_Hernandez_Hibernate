import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import primeroo.*;

/* EJERCICIO 4. Calcula el salario medio de todos los empleados.
 * (Ayuda: busca en el manual de HQL cómo utilizar las funciones
 * de agregación. Verás que es lo mismo que en SQL). */

public class Bateria5_EX04_Hibernate {
	public static void main(String[] args) {
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
		String sql = "select avg(salario) from Emple";
		Query q = session.createQuery(sql);
		List<Double> salarioMedio = q.list();
		Iterator<Double> salarioMedioIterator = salarioMedio.iterator();
		Double salarioMedioValor;
		while (salarioMedioIterator.hasNext()) {
			salarioMedioValor = salarioMedioIterator.next();
			System.out.println("Salario medio: " + salarioMedioValor);
		}
		session.close();
	}
}
