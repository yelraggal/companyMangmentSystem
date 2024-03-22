package com.company;
import java.time.LocalDate;

public class StudentBookDatabase extends Database
{
    public StudentBookDatabase(String fileName)
    {
        super(fileName);
    }

    public StudentBook createRecordFrom(String line) //lazm ab3tlha zy l file.... day month year separted by
    {  // lazm a5tserha m3 l READ FROM FILE FUNCTION
        String[] data = line.split(",");
        String[] dateData = data[2].split("-");
        String RightDateForm = dateData[2] + '-' + dateData[1] + '-' + dateData[0];
        StudentBook b = new StudentBook(data[0], data[1], LocalDate.parse(RightDateForm));
        return new StudentBook(data[0], data[1], LocalDate.parse(RightDateForm));
    }
}