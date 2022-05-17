package com.example.rvcontacts;

public class

    ContactModel {
    private String contactName, contactPhone;

    public ContactModel(String contactName, String contactPhone) {
        this.contactName = contactName;
        this.contactPhone = contactPhone;
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }
}
