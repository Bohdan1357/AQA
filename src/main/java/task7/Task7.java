package task7;

import org.hibernate.Session;
import java.util.ArrayList;

public class Task7 {
    public static void main(String[] args) {
        Session session = HibernateManager.getSessionFactory().openSession();

        // Create
        session.beginTransaction();

        Profile profile1 = new Profile();
        profile1.setAddress("Kyiv, Ukraine");
        profile1.setPhoneNumber("+380123456789");
        session.save(profile1);

        Data data1 = new Data();
        data1.setName("Oleg");
        data1.setAge(30);
        data1.setProfile(profile1);
        session.save(data1);

        Number number1 = new Number();
        number1.setValue(15);
        number1.setDescription("Lucky Number");
        session.save(number1);

        Number number2 = new Number();
        number2.setValue(23);
        number2.setDescription("Favorite Day");
        session.save(number2);

        data1.setFavoriteNumbers(new ArrayList<>());
        data1.getFavoriteNumbers().add(number1);
        data1.getFavoriteNumbers().add(number2);
        session.update(data1);

        session.getTransaction().commit();

        // Read
        Data readData = session.get(Data.class, data1.getId());
        System.out.println("Read Data: " + readData);

        // Update
        session.beginTransaction();
        readData.setAge(35);
        session.update(readData);
        session.getTransaction().commit();

        // Delete
        session.beginTransaction();
        readData.getFavoriteNumbers().clear();
        session.update(readData);
        session.delete(readData);
        session.getTransaction().commit();

        // Check if deleted
        Data deletedData = session.get(Data.class, data1.getId());
        System.out.println("Deleted Data (should be null): " + deletedData);

        HibernateManager.shutdown();
    }
}