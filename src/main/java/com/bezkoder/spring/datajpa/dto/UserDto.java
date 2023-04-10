package com.bezkoder.spring.datajpa.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserDto {

        private long id;


        @NotEmpty
        @Size(min = 2, message = "user name should have at least 2 characters")
        private String firstName;


        @NotEmpty
        @Size(min = 2, message = "user name should have at least 2 characters")
        private String lastName;

        @NotEmpty
        @Email
        private String emailId;

        @NotEmpty
        @Size(min = 8, message = "password should have at least 8 characters")
        private String password;

    @NotEmpty
    @Size(min = 10, message = "contactno should have at least 10 digits")
    private String contactNo;


        public UserDto() {

        }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }
}

