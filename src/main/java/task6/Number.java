package task6;

import javax.persistence.*;

@Entity
@Table
public class Number {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private Integer value;
    @Column
    private String description;
}
