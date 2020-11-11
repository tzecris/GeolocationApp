package com.user.project.userApp.entities;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "afm")
    @NotNull
    @Pattern(regexp="(^$|[0-9]{9})", message = "Afm should be 9 characters long!")
    private String afm;
    @Column(name = "first_name")
    @NotBlank(message = "First Name is required!")
    private String firstName;
    @Column(name = "last_name")
    @NotBlank(message = "Last Name is required!")
    private String lastName;
    @Column(name = "age")
    @NotNull(message = "Age is required!")
    private int age;
    @Valid
    @NotNull(message = "Address is required!")
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public String getAfm() {
        return afm;
    }

    public void setAfm(String afm) {
        this.afm = afm;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
