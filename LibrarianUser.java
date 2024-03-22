package com.company;

public class LibrarianUser implements Record
{
   private String librarianId,name,email,address,phoneNumber;

    public LibrarianUser(String librarianId, String name, String email, String address, String phoneNumber)
    {
        this.librarianId = librarianId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String lineRepresentation()
    {
        return
                 librarianId +
                "," + name +
                "," + email +
                "," + address +
                "," + phoneNumber;
    }

    public String getSearchKey() {
        return librarianId;
    }

    public String getLibrarianId() {
        return librarianId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
