package task5;

import java.io.Serializable;
import java.util.List;

//{
//  "name": "Michael",
//  "age": 28,
//  "favoriteNumbers": [7, 13, 19]
//}
public class Data implements Serializable {
    String name;
    Integer age;
    List<Integer> favoriteNumbers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Integer> getFavoriteNumbers() {
        return favoriteNumbers;
    }

    public void setFavoriteNumbers(List<Integer> favoriteNumbers) {
        this.favoriteNumbers = favoriteNumbers;
    }

    @Override
    public String toString() {
        return "Data{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", favoriteNumbers=" + favoriteNumbers +
                '}';
    }
}