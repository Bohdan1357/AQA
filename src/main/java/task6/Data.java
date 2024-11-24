package task6;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "data")
public class Data {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Integer age;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "data_id")
    private List<Number> favoriteNumbers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<Number> getFavoriteNumbers() {
        return favoriteNumbers;
    }

    public void setFavoriteNumbers(List<Number> favoriteNumbers) {
        this.favoriteNumbers = favoriteNumbers;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", favoriteNumbers=" + favoriteNumbers +
                '}';
    }
}