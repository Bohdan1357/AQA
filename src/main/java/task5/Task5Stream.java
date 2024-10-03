//Stream:
//a) Generate 10 random objects using a class from a previous task
//b) Sort it using any two fields using stream.
//c) Filter it by any two fields custom filter.
//d) Collect it to List with *main field(s).

package task5;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task5Stream {
    public static void main(String[] args) {
        int n = 10;
        if (args.length > 0){
            n = Integer.parseInt(args[0]);
        }
        // a) Generate 10 random objects
        List<Data> dataList = IntStream.range(0, n)
                .mapToObj(i -> generateRandomData())
                .toList();

        // b) Sort by name and age
        List<Data> sortedDataList = dataList.stream()
                .sorted(Comparator.comparing(Data::getName)
                        .thenComparing(Data::getAge))
                .toList();

        // c) Filter by age and name
        List<Data> filteredDataList = dataList.stream()
                .filter(data -> data.getAge() > 25)
                .filter(data -> data.getName().startsWith("M"))
                .toList();

        // d) Collect it to List only names
        List<String> nameList = dataList.stream()
                .map(Data::getName)
                .toList();

        // Output results
        System.out.println("Generated Data:");
        dataList.forEach(System.out::println);

        System.out.println("\nSorted Data:");
        sortedDataList.forEach(System.out::println);

        System.out.println("\nFiltered Data:");
        filteredDataList.forEach(System.out::println);

        System.out.println("\nCollected Names:");
        nameList.forEach(System.out::println);
    }

    private static Data generateRandomData() {
        Random random = new Random();
        String[] names = {"Michael", "John", "Anna", "Maria", "Bohdan", "Mark", "Jack", "Mary", "Steve", "Dan"};

        Data data = new Data();
        data.setName(names[random.nextInt(names.length)]);
        data.setAge(20 + random.nextInt(15));
        List<Integer> favoriteNumbers = IntStream.range(0, 3)
                .mapToObj(i -> 1 + random.nextInt(100))
                .collect(Collectors.toList());
        data.setFavoriteNumbers(favoriteNumbers);

        return data;
    }
}