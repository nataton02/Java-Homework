package de.telran.persons_rest.dto;

public class PhoneNumberDto {
    public Integer id;
    public String codeNumber;
    public String phoneNumber;
    public int personId;

    public PhoneNumberDto() {
    }

    public PhoneNumberDto(Integer id, String codeNumber, String phoneNumber, int personId) {
        this.id = id;
        this.codeNumber = codeNumber;
        this.phoneNumber = phoneNumber;
        this.personId = personId;
    }

    public Integer getId() {
        return id;
    }

    public String getCodeNumber() {
        return codeNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getPersonId() {
        return personId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }
}
