package com.company;

public class BookDatabase extends Database
{
    public BookDatabase(String fileName)
    {
        super(fileName);
    }
    public Book createRecordFrom (String line)
    {
        String[] data = line.split(",");
        return new Book(data[0],data[1],data[2],data[3],Integer.parseInt(data[4]));
    }
}