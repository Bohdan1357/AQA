/* Array Sum: Write a Java program that takes an array of integers and calculates their sum. Your program should prompt the user to enter the array size and the elements of the array, and then output the sum of the array.
*/

package task3;

import java.util.Scanner;

public class Task3ArraySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введіть кількість чисел у масиві: ");
        int size = sc.nextInt();

        int[] arr = new int[size];

        System.out.println("Введіть числа: ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += arr[i];
        }
        System.out.println("Сума чисел: " + sum);
    }
}
