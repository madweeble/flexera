package com.kevinbradley.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PERSON")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PERSON_ID")
    private long id;
    @Column(name="NAME")
    private String name;
    @Column(name="AGE")
    private int age;
    @Column(name="BALANCE")
    private double balance;
    @Column(name="EMAIL")
    private String email;
    @Column(name="ADDRESS")
    private String address;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return String.format("PersonEntity: [name:%s, age:%d, balance:%.2f, email:%s, address:%s]",
                this.name, this.age, this.balance, this.email, this.address);
    }
}
