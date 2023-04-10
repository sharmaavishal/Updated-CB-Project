package com.bezkoder.spring.datajpa.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "FirstName")
    private String firstname;

    @Column(name = "LastName")
    private String lastname;

    @Column(name = "EmailId")
    private String emailid;

    @Column(name = "Password")
    private String password;

    @Column(name = "ContactNo")
    private String contactno;

    public User() {

    }

    public User(String firstname, String lastname, String emailid, String password, String contactno) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.emailid = emailid;
        this.password=password;
        this.contactno=contactno;
    }

    public long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", FirstName=" + firstname + ", LastName=" + lastname + ", EmailId=" + emailid + " Password="  + password + "ContactNo=" +contactno;

    }

}