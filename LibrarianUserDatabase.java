package com.company;


public class LibrarianUserDatabase extends Database
{
    public LibrarianUserDatabase(String fileName)
    {
        super(fileName);
    }

    public LibrarianUser creatRecordFrom(String line)
    {
        String[] data = line.split(",");
        return new LibrarianUser(data[0], data[1], data[2], data[3], data[4]);
    }
}

