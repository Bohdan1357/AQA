//General:
//        Implement OneToOne, OneToMany, and ManyToMany relations in your models from the previous task.(Task_6)
//        Test it by CRUD.

package task7;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Task7 {
    public static void main(String[] args) {
        // Створення SessionFactory та сесії
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Data.class)
                .addAnnotatedClass(Hobby.class)
                .addAnnotatedClass(Number.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // Створення нових об'єктів Number
            Number number1 = new Number();
            number1.setValue(7);
            Number number2 = new Number();
            number2.setValue(11);

            // Створення списку Number
            List<Number> numbers = new ArrayList<>();
            numbers.add(number1);
            numbers.add(number2);

            // Збереження об'єктів Number
            session.beginTransaction();
            session.save(number1);
            session.save(number2);
            session.getTransaction().commit();

            // Створення нових об'єктів Hobby
            Hobby hobby1 = new Hobby();
            hobby1.setName("Football");
            Hobby hobby2 = new Hobby();
            hobby2.setName("Reading");

            // Створення списку Hobby
            List<Hobby> hobbies = new ArrayList<>();
            hobbies.add(hobby1);
            hobbies.add(hobby2);

            // Створення об'єкта Data
            Data data = new Data();
            data.setName("John Doe");
            data.setAge(30);
            data.setHobbies(hobbies);
            data.setFavoriteNumbers(numbers);

            // Збереження об'єкта Data
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.save(data);  // Збереження Data, тепер посилання на Number збережено
            session.getTransaction().commit();

            System.out.println("Data saved successfully: " + data);
        } finally {
            factory.close();
        }
    }
}
