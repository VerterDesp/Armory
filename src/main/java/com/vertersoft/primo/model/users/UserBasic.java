package com.vertersoft.primo.model.users;

public interface UserBasic {

    String getFirstName();
    void setFirstName(String firstName);

    String getLastName();
    void setLastName(String secondName);

    Byte[] getPhoto();
    void setPhoto(Byte[] photo);

    String getPhoneNumber();
    void setPhoneNumber(String phoneNumber);

    String getEmail();
    void setEmail(String email);

    String getPassword();
    void setPassword(String password);
}
