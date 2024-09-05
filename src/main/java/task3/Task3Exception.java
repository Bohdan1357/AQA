//Make up the situation for NullPointerException. Catch it and display the explanation for your custom case.

package task3;

public class Task3Exception {
    public static void main(String[] args) {
        String testObject = null;
        try{
            testObject.toUpperCase();
        }
        catch (NullPointerException e){
            throw new RuntimeException("You need to initialize it first");
        }

    }
}
