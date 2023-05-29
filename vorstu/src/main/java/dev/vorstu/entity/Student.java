package dev.vorstu.entity;

import javax.persistence.*;

@Entity
@Table(name="students")
public class Student {

    public Student() { }

    public Student(Long id, String fio, String group, String curator, String phoneNumber, String phoneNumberOfParents) {
        this(fio, group, curator, phoneNumber, phoneNumberOfParents);
        this.id = id;
    }
    public Student(String fio, String group, String curator, String phoneNumber, String phoneNumberOfParents) {
        this.fio = fio;
        this.group = group;
        this.curator = curator;
        this.phoneNumber = phoneNumber;
        this.phoneNumberOfParents = phoneNumberOfParents;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "fio")
    private String fio;
    @Column(name = "group_of_students")
    private String group;
    @Column(name = "curator_of_student")
    private String curator;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "phoneNumberOfParents")
    private String phoneNumberOfParents;

    public Long getId() { return id; }
    public void setId(Long id) {this.id = id;}

    public String getFio() {
        return fio;
    }
    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getGroup() {
        return group;
    }
    public void setGroup(String group) {
        this.group = group;
    }

    public  String getCurator() { return  curator; }
    public void setCurator(String curator) { this.curator = curator; }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public  String getPhoneNumberOfParents() { return phoneNumberOfParents; }
    public void setPhoneNumberOfParents(String phoneNumberOfParents) { this.phoneNumberOfParents = phoneNumberOfParents; }

}