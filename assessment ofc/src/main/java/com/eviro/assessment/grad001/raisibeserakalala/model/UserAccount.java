package com.eviro.assessment.grad001.raisibeserakalala.model;


import javax.persistence.*;

/**
 * @author JavaSolutionsGuide
 *
 */
@Entity
@Table(name ="AccountProfile")
public class UserAccount {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column(name="Account_holder_name")
    private String name;

    @Column(name="Account_holder_surname")
    private String surname;

    @Column(name="httpImageLink")
    private String imagelink;

    public UserAccount() {

    }
    public UserAccount(String name, String surname, String imagelink) {
        this.name = name;
        this.surname = surname;
        this.imagelink = imagelink;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getImagelink() {
        return imagelink;
    }

    public void setImagelink(String imagelink) {
        this.imagelink = imagelink;
    }


    @Override
    public String toString() {
        return "Account Profile [id=" + id + ", name=" + name + ", surname=" + surname + ", http image link=" + imagelink + "]";
    }
}
