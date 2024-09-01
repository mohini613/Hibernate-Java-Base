package CRUDopreJavaBase;


	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.Transaction;
	import org.hibernate.cfg.Configuration;

    public class StudCRUD {

	    private SessionFactory factory;
	    public StudCRUD() {
	        factory = new Configuration().configure().buildSessionFactory();
	    }

	    public void createEmployee(CRUD crud) {
	        Session session = factory.openSession();
	        Transaction transaction = null;
	        try {
	            transaction = session.beginTransaction();
	            session.save(crud);
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) transaction.rollback();
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	    }

	    public CRUD readEmployee(int id) {
	        Session session = factory.openSession();
	        CRUD crud = null;
	        try {
	            crud = session.get(CRUD.class, id);
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	        return crud;
	    }

	    public void updateEmployee(CRUD crud) {
	        Session session = factory.openSession();
	        Transaction transaction = null;
	        try {
	            transaction = session.beginTransaction();
	            session.update(crud);
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) transaction.rollback();
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	    }

	    public void deleteEmployee(int id) {
	        Session session = factory.openSession();
	        Transaction transaction = null;
	        try {
	            transaction = session.beginTransaction();
	            CRUD employee = session.get(CRUD.class, id);
	            if (employee != null) {
	                Object crud = null;
					session.delete(crud);
	                transaction.commit();
	            }
	        } catch (Exception e) {
	            if (transaction != null) transaction.rollback();
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	    }
	}


