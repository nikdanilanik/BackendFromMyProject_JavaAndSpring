package dev.vorstu.entity;

import javax.persistence.*;

@Entity
@Table(name="students")
public class Student {

    public Student() { }

    public Student(Long id, String fio, Group group, String phoneNumber, String phoneNumberOfParents) {
        this(fio, group, phoneNumber, phoneNumberOfParents);
        this.id = id;
    }
    public Student(String fio, Group group, String phoneNumber, String phoneNumberOfParents) {
        this.fio = fio;
        this.group = group;
        this.phoneNumber = phoneNumber;
        this.phoneNumberOfParents = phoneNumberOfParents;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "fio")
    private String fio;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "phoneNumberOfParents")
    private String phoneNumberOfParents;

    public Long getId() { return id; }
    public void setId(Long id) {this.id = id;}

    public String getFio() { return fio; }
    public void setFio(String fio) { this.fio = fio;
    }

    public Group getGroup() { return group; }
    public void setGroup(Group group) { this.group = group; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public  String getPhoneNumberOfParents() { return phoneNumberOfParents; }
    public void setPhoneNumberOfParents(String phoneNumberOfParents) { this.phoneNumberOfParents = phoneNumberOfParents; }

}