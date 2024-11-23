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
        data.setAge(18);
        data.setName("Oleg");
        Long dataId = (Long) session.save(data);

        Data data1 = new Data();
        data1.setAge(20);
        data1.setName("Anna");
        Long dataId1 = (Long) session.save(data1);

        Data data2 = new Data();
        data2.setAge(25);
        data2.setName("Sam");
        Long dataId2 = (Long) session.save(data2);

        Number number = new Number();
        number.setValue(15);
        number.setDescription("November 13th");
        Long numberId = (Long) session.save(number);

        Number number1 = new Number();
        number1.setValue(23);
        number1.setDescription("September 23th");
        Long numberId1 = (Long) session.save(number1);

        Number number2 = new Number();
        number2.setValue(19);
        number2.setDescription("August 5th");
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
