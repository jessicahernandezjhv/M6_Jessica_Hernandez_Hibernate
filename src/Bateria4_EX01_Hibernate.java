	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.Transaction;
	import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
	import org.hibernate.cfg.Configuration;

	import primeroo.*;
	/* EJERCICIO 1. Visualiza el apellido y el salario del empleado
	 * con número: 7369 */

	public class Bateria4_EX01_Hibernate {
		public static void main(String[] args) {
			Configuration config = new Configuration().configure();
			SessionFactory sessionFactory = config.buildSessionFactory (
					new StandardServiceRegistryBuilder().configure().build());
			SessionFactory sesion = HibernateUtil.getSessionFactory();
			Session session = sesion.openSession();
			Transaction tx = session.beginTransaction();
			
			Emple emp = new Emple();
			emp = (Emple) session.load(Emple.class,  7369);
			System.out.printf("Número Emp: %s%n", emp.getEmpNo());
			System.out.printf("Apellido: %s%n", emp.getApellido());
			System.out.printf("Salario: %s%n", emp.getSalario());
			
			tx.commit();
			session.close();
			System.exit(0);
		}
	}