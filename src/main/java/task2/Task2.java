//V 12: Character Arrays
//Objective: To understand and use arrays with the char type in Java.
//Instructions:
//Declare and initialize an array of chars.
//Use a for loop to print the elements of the array to the console.
//Use a for loop to find the number of vowels in the array.

package task2;

public class Task2 {
    public static void main(String[] args) {
        char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};

        for (int i = 0; i < charArray.length; i++) {
            System.out.print(charArray[i] + " ");
        }

        int vowelCount = 0;
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                    ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                vowelCount++;
            }
        }
        System.out.println("\nNumber of vowels: " + vowelCount);
    }
}