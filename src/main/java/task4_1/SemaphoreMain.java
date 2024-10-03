// Use a Semaphore to allow only a limited number of threads to access a shared resource at the same time.

package task4_1;

import java.util.concurrent.Semaphore;

public class SemaphoreMain {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        SemaphoreShared resource = new SemaphoreShared();

        // Створюємо кілька потоків
        Thread t1 = new SemaphoreThread("Thread 1", semaphore, resource);
        Thread t2 = new SemaphoreThread("Thread 2", semaphore, resource);
        Thread t3 = new SemaphoreThread("Thread 3", semaphore, resource);
        Thread t4 = new SemaphoreThread("Thread 4", semaphore, resource);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
