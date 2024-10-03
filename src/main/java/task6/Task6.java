// Install MySQL server (or any SQL like db)
//Make at least two tables (Entities from the previous task or any additional if needed)
//Make models for those Entities (from Task_5)
//Setup Hibernate for those Entities and local DB
//Check basic CRUD (create, read, update, and delete the BD records using Hibernate)
//Generate a few rows into all tables


package task6;

import org.hibernate.Session;

public class Task6 {
    public static void main(String[] args) {
        Session session = HybernateManager.getSessionFactory().openSession();
        // Create
        Data data = new Data();
        data.setAge(42);
        data.setName("Bohdan");
        Long id = (Long) session.save(data);
        // Read
        Data readData = session.get(Data.class, id);
        System.out.println(readData);
        // Update
        session.beginTransaction();
        data.setAge(43);
        session.update(data);
        session.getTransaction().commit();
        // Delete
        session.delete(readData);

        readData = session.get(Data.class, id);
        System.out.println(readData);
        HybernateManager.shutdown();
    }
}
