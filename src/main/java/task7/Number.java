package task7;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "number")
public class Number {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private Integer value;

    @Column
    private String description;

    @ManyToMany(mappedBy = "favoriteNumbers")
    private List<Data> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Data> getUsers() {
        return users;
    }

    public void setUsers(List<Data> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Number{" +
                "id=" + id +
                ", value=" + value +
                ", description='" + description + '\'' +
                '}';
    }
}