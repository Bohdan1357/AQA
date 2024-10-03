package task6;

import javax.persistence.*;

@Entity
@Table

public class Data {
//<data>
//  <name>Michael</name>
//  <age>28</age>
//  <favoriteNumbers>
//  <number>7</number>
//  <number>13</number>
//  <number>19</number>
//  </favoriteNumbers>
//</data>
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    private Integer age;
//private List<Number> favoriteNumbers

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

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
