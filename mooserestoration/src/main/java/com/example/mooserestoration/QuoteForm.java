package com.example.mooserestoration;

public class QuoteForm {
    private String name;
    private String email;
    private String phoneNumber;
    private String description;

    public QuoteForm(String Name, String Email, String PhoneNumber, String Description){
        this.name = Name;
        this.email = Email;
        this.phoneNumber = PhoneNumber;
        this.description = Description;
    }
    public String getName(){
        return this.name;
    }
    public String getEmail(){
        return this.email;
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    public String getDescription(){
        return this.description;
    }
}
