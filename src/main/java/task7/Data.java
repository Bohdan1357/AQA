package task7;

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

    @OneToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @ManyToMany
    @JoinTable(
            name = "data_number",
            joinColumns = @JoinColumn(name = "data_id"),
            inverseJoinColumns = @JoinColumn(name = "number_id")
    )
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

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
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
                ", profile=" + profile +
                ", favoriteNumbers=" + favoriteNumbers +
                '}';
    }
}