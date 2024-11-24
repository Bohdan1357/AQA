package task8;

import org.testng.Assert;
import org.testng.annotations.*;

public class Task8Test {

    Task8newTask2 task8newTask2;

    @BeforeClass
    void setUp() {
        task8newTask2 = new Task8newTask2();
    }

    @Test(dataProvider = "vowelCountProvider")
    public void testCountVowels(char[] input, int expected) {
        int actual = task8newTask2.countVowels(input);
        System.out.println("Actual vowel count: " + actual);
        Assert.assertEquals(actual, expected, "Vowel count does not match");
    }

    @DataProvider(name = "vowelCountProvider")
    public Object[][] vowelCountProvider() {
        return new Object[][]{
                {new char[]{'a', 'b', 'c', 'e'}, 2},
                {new char[]{'x', 'y', 'z'}, 0},
                {new char[]{'A', 'E', 'I', 'O', 'U'}, 5}
        };
    }

    @Test(dataProvider = "arrayLengthProvider")
    public void testGetArrayLength(char[] input, int expected) {
        int actual = task8newTask2.getArrayLength(input);
        System.out.println("Actual array length: " + actual);
        Assert.assertEquals(actual, expected, "Array length does not match");
    }

    @DataProvider(name = "arrayLengthProvider")
    public Object[][] arrayLengthProvider() {
        return new Object[][]{
                {new char[]{'a', 'b', 'c'}, 3},
                {new char[]{}, 0},
                {new char[]{'a', 'b', 'c', 'd', 'e'}, 5}
        };
    }

    @Test
    @Parameters({"testArray"})
    public void testWithParameters(String testArray) {
        char[] input = testArray.toCharArray();
        int actualLength = task8newTask2.getArrayLength(input);
        System.out.println("Array length: " + actualLength);
        Assert.assertTrue(actualLength > 0, "Array length should be greater than zero");
    }
}