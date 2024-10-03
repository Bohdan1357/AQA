package task4_1;

import java.util.concurrent.Semaphore;

public class SemaphoreThread extends Thread {
    private String threadName;
    private Semaphore semaphore;
    private SemaphoreShared resource;

    public SemaphoreThread(String threadName, Semaphore semaphore, SemaphoreShared resource) {
        this.threadName = threadName;
        this.semaphore = semaphore;
        this.resource = resource;
    }

    @Override
    public void run() {
        try {
            // Спроба отримати дозвіл на доступ до ресурсу
            System.out.println(threadName + " waits");
            semaphore.acquire();

            // Доступ до спільного ресурсу
            resource.accessResource(threadName);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Звільнення дозволу після завершення роботи
            semaphore.release();
            System.out.println(threadName + " released the resource");
        }
    }
}