package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Database
    {
       private String fileName;
       private ArrayList<Record> records = new ArrayList<Record>();

        public Database(String fileName)
        {
            this.fileName = fileName;
        }

        public void readFromFile()
        {

            try {
                File file = new File(fileName);
                Scanner sc = new Scanner(file);
                while (sc.hasNextLine())
                {
                    String line = sc.nextLine();
                    String[] fileData = line.split(",");

                    if (fileName.equals("Books.txt"))
                    {
                    Book b = new Book(fileData[0], fileData[1], fileData[2], fileData[3],Integer.parseInt(fileData[4]));
                    records.add(b);
                    }

                     if (fileName.equals("Librarians.txt")) {
                         LibrarianUser l = new LibrarianUser(fileData[0], fileData[1], fileData[2], fileData[3], fileData[4]);
                         records.add(l);
                     }

                    if (fileName.equals("StudentsBooks.txt"))
                    {
                        String[] date = fileData[2].split("-");
                        String RightDateForm = date[2] + "-" + date[1] + "-" + date[0];
                        //System.out.println(fileData[0]+ fileData[1]+ LocalDate.parse(RightDateForm));
                        StudentBook b = new StudentBook(fileData[0], fileData[1], LocalDate.parse(RightDateForm));
                        records.add(b);
                    }
                }
                sc.close();
            } catch (FileNotFoundException e)
            {
                System.out.println("An error occurred.");
            }
        }



        public ArrayList<Record> returnAllRecords()
        {
            return records;
        }

        public boolean contains(String key)
        {
            for (Record r : records)
            {
                if ((r.getSearchKey()).equals(key))
                {
                    return true;
                }
            }
            return false;
        }

        public Record getRecord(String key)
        {
            for (Record r : records)
            {
                if ((r.getSearchKey()).equals(key))
                {
                    return r;
                }
            }
            System.out.println("User Not Found . Returned null");
            return null;
        }

        public void insertRecord(Record r) // ay kan l no3 hoto fl array b type bta3o
        {
            records.add(r);
        }

        public void deleteRecord (String key)
        {
            int i=0;
            for (Record r : records)
            {
                if ((r.getSearchKey()).equals(key))
                {
                    records.remove(i);
                    return;
                }
                i++;
            }
        }

        public void saveToFile() throws IOException
        {
            FileWriter writer= new FileWriter(fileName);
            for (Record r:records)
                {
                    writer.write(r.lineRepresentation() + "\n");
                }
            writer.close();
        }
    }
