//1: Create 3 simple unit tests for Task_2 (modify your code to have 3 different methods in Task_2 solving if needed).
//2. Create testng.xml which should execute your test class. Execute this file
//3. Add a Data provider for each test.
//4. Create a test with parameters loaded from testng.xml.

package task8;

public class Task8newTask2 {

    public int countVowels(char[] charArray) {
        int vowelCount = 0;
        for (char ch : charArray) {
            if (isVowel(ch)) {
                vowelCount++;
            }
        }
        return vowelCount;
    }

    public int getArrayLength(char[] charArray) {
        return charArray.length;
    }

    private boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) != -1;
    }
}