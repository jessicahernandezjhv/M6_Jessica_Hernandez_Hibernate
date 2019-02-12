import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import java.util.Set;
import java.util.Iterator;
import primeroo.*;
	
/* EJERCICIO 3. Para modificar un objeto, igual que para borrarlo, 
 * primero hemos de cargarlo, a continuación realizamos la modificaciones
 * y, por último, utilizamos el método update(). Realiza un programa
 * que modifique el salario y el departamento del empleado 7369, 
 * sumando 1000 al salario y asignándole el departamento 30.*/

public class Bateria4_EX03_Hibernate {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sessionFactory = cfg.buildSessionFactory (
				new StandardServiceRegistryBuilder().configure().build() ) ;
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		
		Depart dep = new Depart();
		Emple emp = new Emple();
		try {
			dep = session.load(Depart.class, 30);
		} catch ( ObjectNotFoundException o ) {
			System.out.println("El departamento no existe");
		}
		try {
			emp = session.load(Emple.class, 7369);
		} catch ( ObjectNotFoundException o ) {
			System.out.println("El empleado no existe");
		}
		
		emp.setSalario(emp.getSalario() + 1000);
		emp.setDepart(dep);
		
		session.update(emp);
		tx.commit();
		session.close();
		System.exit(0);
}
}
