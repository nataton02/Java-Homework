package de.telran.persons_rest.model;

import javax.persistence.*;

@Entity
public class PhoneNumber {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private  Integer id;
    private String codeNumber;
    private String phoneNumber;

    @ManyToOne
    private Person person;

    public PhoneNumber() {
    }

    public PhoneNumber(String codeNumber, String phoneNumber, Person person) {
        this.codeNumber = codeNumber;
        this.phoneNumber = phoneNumber;
        this.person = person;
    }

    public Integer getId() {
        return id;
    }

    public String getCodeNumber() {
        return codeNumber;
    }

    public void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Person getPerson() {
        return person;
    }

}
