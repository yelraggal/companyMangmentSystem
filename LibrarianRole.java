package com.company;
import java.io.IOException;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;

public class LibrarianRole
{
   private BookDatabase booksDatabase =new BookDatabase("Books.txt");
   private StudentBookDatabase sBDatabase=new StudentBookDatabase("StudentsBooks.txt");

    public LibrarianRole()
    {
        booksDatabase.readFromFile();
        sBDatabase.readFromFile();
    }

    public void addBook(String id, String title, String authorName, String publisherName, int quantity) throws IOException {
        booksDatabase.insertRecord(booksDatabase.createRecordFrom(id + ',' + title + ',' + authorName + ',' + publisherName + ',' + Integer.toString(quantity)));
        booksDatabase.saveToFile();
    }

    public Book[] getListOfBooks()
    {
        Book[] user = new Book[booksDatabase.returnAllRecords().size()];
        //user=database.returnAllRecords().toArray(user);
        return booksDatabase.returnAllRecords().toArray(user); // toArray(nameOfTheArray)
    }

    public StudentBook[] getListOfBorrowingOperations()
    {
        StudentBook[]user=new StudentBook[sBDatabase.returnAllRecords().size()];
        return sBDatabase.returnAllRecords().toArray(user);// toArray(arrayName)
    }

    public int borrowBook (String stdentId, String bookId, LocalDate borrowDate) throws IOException
    {
        for (Record record: sBDatabase.returnAllRecords())
        {
            if(((StudentBook)record).getStudentId().equals(stdentId)&&((StudentBook)record).getBookId().equals(bookId))
            {
                //if (((StudentBook)record).getBookId().equals(bookId))
                return 1;
            }
        }
        for (Record record:booksDatabase.returnAllRecords())
        {
            if (((Book) record).getBookId().equals(bookId) && ((Book) record).getQuantity() == 0)
            {
                //if (((Book)record).getQuantity()==0)  this double if is more readable
                return 0;
            }
        }

//        for (Record record: sBDatabase.returnAllRecords())
//        {
//             if(((StudentBook)record).getStudentId().equals(stdentId)&&((StudentBook)record).getBookId().equals(bookId))
//             {
//                //if (((StudentBook)record).getBookId().equals(bookId))
//                    return 1;
//             }
//        }
        // hlf 3l array el fyha books l7d ma 2la2i l ketab w an2s quantity bt3to b wahed
        for (Record record:booksDatabase.returnAllRecords())
        {
            if (((Book)record).getBookId().equals(bookId))
            {
                ((Book) record).setQuantity((((Book) record).getQuantity())-1);
                booksDatabase.saveToFile();//update the file bel array el gdeda el fyha quantity l ketab 2lt b wahed
                //borrowdate lazm tt3dl aknha gya mn file
                String str=String.format(
                        "%02d",borrowDate.getDayOfMonth())+'-'+
                        String.format("%02d",borrowDate.getMonthValue())+
                        '-'+String.format("%04d",borrowDate.getYear());
                sBDatabase.insertRecord(sBDatabase.createRecordFrom(stdentId+','+bookId+','+str));
                sBDatabase.saveToFile();
            }
        }
        return 2;
    }

    private int differenceInDays (String studentID,String bookId,LocalDate returnDate)
    {
        for (Record record: sBDatabase.returnAllRecords())
        {
            if (((StudentBook) record).getBookId().equals(bookId) && ((StudentBook)record).getStudentId().equals(studentID))
            {
               // System.out.println(Math.abs(DAYS.between(returnDate,((StudentBook) record).getBorrowDate())));
                return (int) Math.abs(DAYS.between(returnDate,((StudentBook) record).getBorrowDate()));
            }
        }
        return 0;
    }

    public double returnBook(String studentId,String bookId,LocalDate returnDate) throws IOException
    {
        for (Record record : booksDatabase.returnAllRecords())
        {
            if (((Book) record).getBookId().equals(bookId))
            {
                //System.out.println("hello");
                ((Book) record).setQuantity((((Book) record).getQuantity()) + 1);
                booksDatabase.saveToFile();//update the file bel array el gdeda el fyha quantity l ketab zadt b wahed
            }
        }
        // remove REPRESENTING line in studentBook file bs b3d ma ageb l diff in days w late fee lw mwgod
        double lateFee= (differenceInDays(studentId,bookId,returnDate)-7)*0.5;
        int diffrenceEInDays=differenceInDays(studentId,bookId,returnDate);
        sBDatabase.deleteRecord(studentId+','+bookId);
        sBDatabase.saveToFile();
        if(diffrenceEInDays>7)
        {
            return lateFee;
        }
        return 0;
    }
    public void logout() throws IOException
    {
        booksDatabase.saveToFile();
        sBDatabase.saveToFile();
    }
}
