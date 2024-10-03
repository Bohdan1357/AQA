//Create your own custom class, and make an object for it, fill it by some data. Use getDeclaredFields() to print out all the fields of the class and their types. Choose a specific field by name and modify its value using set(). Print out your object before and after changes.

package task4_2;

import java.lang.reflect.Field;

public class PizzaReflection {
    public static void main(String[] args) {
        Pizza pizza = new Pizza("Large", "Pepperoni", 320);

        // Використовуємо рефлексію для отримання полів класу
        Field[] fields = pizza.getClass().getDeclaredFields();

        System.out.println("All fields and their types:");
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println("Field name: " + field.getName() + ", Type: " + field.getType().getName());
        }
        System.out.println("\nBefore changes: " + pizza);

        try {
            // Отримуємо поле "price" за його назвою
            Field priceField = pizza.getClass().getDeclaredField("price");
            priceField.setAccessible(true);

            // Змінюємо значення поля "price"
            priceField.set(pizza, 350);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("After changes: " + pizza);
    }
}
