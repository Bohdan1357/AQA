package task6;

import org.hibernate.Session;

public class Task6 {
    public static void main(String[] args) {
        Session session = HybernateManager.getSessionFactory().openSession();

        // Create
        session.beginTransaction();

        // Adding Data
        Data data1 = new Data();
        data1.setAge(18);
        data1.setName("Oleg");
        Long dataId1 = (Long) session.save(data1);

        Data data2 = new Data();
        data2.setAge(20);
        data2.setName("Anna");
        Long dataId2 = (Long) session.save(data2);

        Data data3 = new Data();
        data3.setAge(25);
        data3.setName("Sam");
        Long dataId3 = (Long) session.save(data3);

        // Adding Numbers
        Number number1 = new Number();
        number1.setValue(15);
        number1.setDescription("November 13th");
        Long numberId1 = (Long) session.save(number1);

        Number number2 = new Number();
        number2.setValue(23);
        number2.setDescription("September 23rd");
        Long numberId2 = (Long) session.save(number2);

        session.getTransaction().commit();

        // Read
        Data readData1 = session.get(Data.class, dataId1);
        Data readData2 = session.get(Data.class, dataId2);
        Data readData3 = session.get(Data.class, dataId3);

        System.out.println("Read Data:");
        System.out.println(readData1);
        System.out.println(readData2);
        System.out.println(readData3);

        Number readNumber1 = session.get(Number.class, numberId1);
        Number readNumber2 = session.get(Number.class, numberId2);

        System.out.println("Read Number:");
        System.out.println(readNumber1);
        System.out.println(readNumber2);

        // Update
        session.beginTransaction();
        readData1.setAge(43);
        session.update(readData1);
        session.getTransaction().commit();

        // Delete
        session.beginTransaction();
        session.delete(readData3);
        session.getTransaction().commit();

        // Check if deleted
        Data deletedData = session.get(Data.class, dataId3);
        System.out.println("Deleted Data (should be null): " + deletedData);

        HybernateManager.shutdown();
    }
}
