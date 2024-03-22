package com.company;

import java.io.IOException;

public class AdminRole
{
   private LibrarianUserDatabase database = new LibrarianUserDatabase("Librarians.txt");

    public AdminRole()
    {
        database.readFromFile();
    }

    public void addLibrarian (String librarianld,String name,String email,String address,String phoneNumber) throws IOException {
        database.insertRecord(database.creatRecordFrom(librarianld+','+name+','+email+','+address+','+phoneNumber));
        database.saveToFile();
    }

    public LibrarianUser[] getListOfLibrarians() // we have records in array list we need to convert array list to array
    {
      //database.readFromFile(); 5leto ye2ra awl ma anady 3l constructor
      LibrarianUser[] user=new LibrarianUser[database.returnAllRecords().size()];
     // user=database.returnAllRecords().toArray(user);
      return database.returnAllRecords().toArray(user); // toArray(nameOfTheArray)

    }

    public void removeLibrarian(String key) throws IOException {
        database.deleteRecord(key);
        database.saveToFile();
    }

    public void logout() throws IOException
    {
     database.saveToFile();
    }

}
