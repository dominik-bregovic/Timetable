import java.io.File;
/*
 * HibernateSupport
 * For save/deletion operations between POJOs and DB-tables
 * Author:       Muesluem Atas
 * Last Change:  12.08.2021
 */

import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.service.*;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class HibernateSupport {
	private static SessionFactory sessionFactory;
	
	static {
		System.out.println("HibernateSupport: Constructor");
		init();
	}
	
	private static void init() {
		//TODO: specify path of the hibernate.cfg.xml file in the next line
		String path = "C:/Users/domin/IdeaProjects/Programmieren/Timetable/src/main/resources/hibernate.cfg.xml";
		File configFile = new File(path);
		Configuration configuration = new Configuration();
			
		//TODO: add all classes you want to annotate
		configuration.addAnnotatedClass(Administrator.class);
		configuration.addAnnotatedClass(Assistant.class);
		configuration.addAnnotatedClass(Student.class);
		configuration.addAnnotatedClass(Subject.class);
		configuration.addAnnotatedClass(Room.class);
		configuration.addAnnotatedClass(Schedule.class);

		configuration.configure(configFile);

		new SchemaExport(configuration).create(true,true);

		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).buildServiceRegistry();
		try {
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
	}
	
	private static Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
		
	public static void beginTransaction() {
		getCurrentSession().beginTransaction();
	}
		
	public static void commitTransaction() {
		getCurrentSession().getTransaction().commit();
	}
		
	public static boolean commit(Object obj) {
		try {
			getCurrentSession().saveOrUpdate(obj);
		}
		catch (HibernateException e) {
			return false;
		}
		return true;
	}
	
	public static <T> void deleteObject(Object obj){
		getCurrentSession().delete(obj);
	}

}
