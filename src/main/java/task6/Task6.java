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
        session.beginTransaction();
        Data data = new Data();
        data.setAge(42);
        data.setName("Bohdan");
        Long dataId = (Long) session.save(data);

        Data data1 = new Data();
        data1.setAge(29);
        data1.setName("Alice");
        Long dataId1 = (Long) session.save(data1);

        Data data2 = new Data();
        data2.setAge(22);
        data2.setName("Greg");
        Long dataId2 = (Long) session.save(data2);

        Number number = new Number();
        number.setValue(13);
        number.setDescription("Friday 13th");
        Long numberId = (Long) session.save(number);

        Number number1 = new Number();
        number1.setValue(24);
        number1.setDescription("August 24th");
        Long numberId1 = (Long) session.save(number1);

        Number number2 = new Number();
        number2.setValue(5);
        number2.setDescription("November 5th");
        Long numberId2 = (Long) session.save(number2);

        session.getTransaction().commit();

        // Read
        Data readData = session.get(Data.class, dataId);
        Data readData1 = session.get(Data.class, dataId1);
        Data readData2 = session.get(Data.class, dataId2);

        System.out.println(readData);
        System.out.println(readData1);
        System.out.println(readData2);

        Number readNumber = session.get(Number.class, numberId);
        Number readNumber1 = session.get(Number.class, numberId1);
        Number readNumber2 = session.get(Number.class, numberId2);

        System.out.println(readNumber);
        System.out.println(readNumber1);
        System.out.println(readNumber2);

        // Update
        session.beginTransaction();
        data.setAge(43);
        session.update(data);
        session.getTransaction().commit();

        // Delete
        session.delete(readData2);

        readData2 = session.get(Data.class, dataId2);
        System.out.println(readData2);
        HybernateManager.shutdown();
    }
}
