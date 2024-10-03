//Create a generic method that takes an instance of a class that implements a specific interface, and calls a method on that interface using interface and invoke().

package task4_3;

import java.lang.reflect.Method;

public class GenericMethod {
    public static <T> void invokePrint(T obj, Class<?> interfaceClass, String methodName) {
        try {
            // Перевіряємо, чи клас obj реалізує вказаний інтерфейс
            if (interfaceClass.isInstance(obj)) {
                Method method = interfaceClass.getMethod(methodName);

                method.invoke(obj);
            } else {
                System.out.println("The object does not implement the specified interface.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        GenericBook book = new GenericBook("Atomic Habits");

        invokePrint(book, Printable.class, "print");
    }
}