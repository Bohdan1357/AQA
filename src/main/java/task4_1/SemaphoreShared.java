package task4_1;

public class SemaphoreShared {
    public void accessResource(String threadName) {
        System.out.println(threadName + " has accessed the resource");
        try {
            // Імітація роботи з ресурсом
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
