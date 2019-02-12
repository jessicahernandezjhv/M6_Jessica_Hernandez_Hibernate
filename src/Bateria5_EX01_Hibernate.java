import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import primeroo.*;

/* EJERCICIo 1. Visualiza el apellido y salario de los empleados 
 * del departamento 20. (Ayuda: la consulta HQL necesaria es: 
 * “from Emple as e where e.depart.deptNo=20”) */

public class Bateria5_EX01_Hibernate {
	public static void main(String[] args) {
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
		
		Query q = session.createQuery("from Emple as e where e.depart.deptNo=20");
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
