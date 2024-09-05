// Make TreeMap from the result array and perform the following operations: a) Add a key-value pair to the map; b) Remove a key-value pair from the map; c) Check if a key is in the map; d) Find the value associated with a given key; e) Print all the keys and values in the map;

package task3;

import java.util.TreeMap;

public class Task3TreeMap {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            treeMap.put(arr[i], i);
        }

        treeMap.put(6, 52);
        System.out.println("Додали пару ключ-значення (6, 52): " + treeMap);

        treeMap.remove(2);
        System.out.println("Видалили елемент з ключем '2': " + treeMap);

        if (treeMap.containsKey(6)) {
            System.out.println("Такий ключ існує");
        }
        else {
            System.out.println("Такий ключ відсутній");
        }

        if (treeMap.containsKey(3)) {
            int value = treeMap.get(3);
            System.out.println("Значення ключа 3: " + value);
        }
        else {
            System.out.println("Ключ 3 відсутній");
        }

        System.out.println("Всі пари ключ-значення в мапі: " + treeMap);
    }
}
