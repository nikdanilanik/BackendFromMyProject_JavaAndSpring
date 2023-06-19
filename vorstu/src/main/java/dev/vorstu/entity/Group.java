package dev.vorstu.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "groups")
@Getter @Setter
public class Group {
    public Group() { }

    public Group(Long id, String name, Long numberOfStudents, String curator) {
        this(name, numberOfStudents, curator);
        this.id = id;
    }
    public Group(String name, Long numberOfStudents, String curator) {
        this.name = name;
        this.numberOfStudents = numberOfStudents;
        this.curator = curator;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Long numberOfStudents;

    private String curator;

}
