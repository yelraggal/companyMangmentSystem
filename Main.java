package com.company;
import java.io.*;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class Main
{
//    public static void printTheBorrowingResult(int result, String studentId, String bookId) {
//        switch (result) {
//            case 1 ->
//                    System.out.println("The student with id = " + studentId + " has already borrowed a copy of the book with id = " + bookId + " and hasn't returned it yet.");
//            case 2 ->
//                    System.out.println("The student with id = " + studentId + " has successfully borrowed a copy of the book with id = " + bookId + ".");
//            case 0 ->
//                    System.out.println("All copies of the book with id = " + bookId + " have been borrowed and no copy is left for the student with id = " + studentId);
//        }
//    }
//
//    public static void printTheBorrowingFee(double result, String studentId, String bookId) {
//        System.out.println("The student with id = " + studentId + " should pay a return fee of " + result + " US dollars for the book with id " + bookId);
//
//    }
//
//    public static void test1() throws IOException {
//        System.out.println("Test1:\n------");
//        LibrarianRole librarian = new LibrarianRole();
//        Book[] books = librarian.getListOfBooks();
//        System.out.println("Current number of books = " + books.length);
//        librarian.addBook("B2391", "Fire & Blood", "George R. R. Martin", "Bantam Books", 4);
//        books = librarian.getListOfBooks();
//        System.out.println("Current number of books = " + books.length);
//        StudentBook[] borrowingOperations = librarian.getListOfBorrowingOperations();
//        System.out.println("Current number of ongoing borrowing operations = " + borrowingOperations.length);
//        int result = librarian.borrowBook("5000", "B2398", LocalDate.of(2022, 5, 15));
//        printTheBorrowingResult(result, "5000", "B2398");
//        result = librarian.borrowBook("6000", "B2398", LocalDate.of(2022, 5, 17));
//        printTheBorrowingResult(result, "6000", "B2398");
//        result = librarian.borrowBook("7000", "B2398", LocalDate.of(2022, 5, 18));
//        printTheBorrowingResult(result, "7000", "B2398");
//        result = librarian.borrowBook("6000", "B2398", LocalDate.of(2022, 5, 19));
//        printTheBorrowingResult(result, "6000", "B2398");
//        borrowingOperations = librarian.getListOfBorrowingOperations();
//        System.out.println("Current number of ongoing borrowing operations = " + borrowingOperations.length);
//        librarian.logout();
//    }
//
//    public static void test2() throws IOException {
//        System.out.println("Test2:\n------");
//        LibrarianRole librarian = new LibrarianRole();
//        Book[] books = librarian.getListOfBooks();
//        System.out.println("Current number of books = " + books.length);
//        StudentBook[] borrowingOperations = librarian.getListOfBorrowingOperations();
//        System.out.println("Current number of ongoing borrowing operations = " + borrowingOperations.length);
//        int result = librarian.borrowBook("4000", "B2391", LocalDate.of(2022, 5, 18));
//        printTheBorrowingResult(result, "4000", "B2391");
//        result = librarian.borrowBook("4000", "B2391", LocalDate.of(2022, 5, 19));
//        printTheBorrowingResult(result, "4000", "B2391");
//        result = librarian.borrowBook("4000", "B2398", LocalDate.of(2022, 5, 19));
//        printTheBorrowingResult(result, "4000", "B2398");
//        double fee = librarian.returnBook("5000", "B2398", LocalDate.of(2022, 5, 20));
//        printTheBorrowingFee(fee, "5000", "B2398");
//        fee = librarian.returnBook("6000", "B2398", LocalDate.of(2022, 5, 29));
//        printTheBorrowingFee(fee, "6000", "B2398");
//        result = librarian.borrowBook("8000", "B2399", LocalDate.of(2022, 5, 19));
//        printTheBorrowingResult(result, "8000", "B2399");
//        result = librarian.borrowBook("4000", "B2399", LocalDate.of(2022, 5, 19));
//        printTheBorrowingResult(result, "4000", "B2399");
//        borrowingOperations = librarian.getListOfBorrowingOperations();
//        System.out.println("Current number of ongoing borrowing operations = " + borrowingOperations.length);
//        librarian.logout();
//    }


    public static void test1() throws IOException {
        AdminRole admin = new AdminRole();
        LibrarianUser[] arrayOfLibrarianUsers = admin.getListOfLibrarians();
        System.out.println("Current number of librarian users  = " + arrayOfLibrarianUsers.length);
        admin.addLibrarian("L1100", "Mariam", "mariam@gmail.com", "Alexandria", "01011845684");
        arrayOfLibrarianUsers = admin.getListOfLibrarians();
        System.out.println("Current number of librarian users  = " + arrayOfLibrarianUsers.length);
        System.out.println(arrayOfLibrarianUsers[2].lineRepresentation());
        admin.removeLibrarian("L1400");
        arrayOfLibrarianUsers = admin.getListOfLibrarians();
        System.out.println("Current number of librarian users  = " + arrayOfLibrarianUsers.length);
        System.out.println(arrayOfLibrarianUsers[2].lineRepresentation());
        admin.removeLibrarian("L1600");
        arrayOfLibrarianUsers = admin.getListOfLibrarians();
        System.out.println("Current number of librarian users  = " + arrayOfLibrarianUsers.length);
        System.out.println(arrayOfLibrarianUsers[3].lineRepresentation());
        admin.logout();
    }

     public static void main(String[] args) throws IOException
     {
//
//            AdminRole adminRole=new AdminRole();
//            //add libarian
//            adminRole.addLibrarian("7889","ahmed","ahmedhassan@gmail.com","newyork","0119657565");
//            for (LibrarianUser l: adminRole.getListOfLibrarians()) // mfrod ttb3 l user ahmed l gded
//            {
//                System.out.println(l.lineRepresentation());
//            }
//            adminRole.removeLibrarian("2222");
//            adminRole.removeLibrarian("9999");
//            adminRole.logout();
//            Final file will be
//            8888,youssef,yelraggal09@yahoo.com,alex,012345678
//            1111,tarek,tarekmonib.45@hotmail.com,cairo,0153864775
//            7889,ahmed,ahmedhassan@gmail.com,newyork,0119657565


//        LibrarianRole librarianRole=new LibrarianRole();
//        librarianRole.addBook("D78","MATH 6","Taha","Computer science",0);
//        for (Book book: librarianRole.getListOfBooks())
//        {
//            System.out.println(book.lineRepresentation());
//        }
//        for (StudentBook sB: librarianRole.getListOfBorrowingOperations())
//        {
//            System.out.println(sB.lineRepresentation());
//        }
//        System.out.println(librarianRole.borrowBook("7806","D78",LocalDate.parse("2022-10-27")));
//        System.out.println(librarianRole.borrowBook("7806","S782",LocalDate.parse("2022-10-27")));
//        System.out.println(librarianRole.borrowBook("7806","K234", LocalDate.parse("2022-10-27")));
//
//        System.out.println(librarianRole.returnBook("7806","S782",LocalDate.parse("2022-11-28")));
//        System.out.println(librarianRole.returnBook("7792","K234",LocalDate.parse("2022-10-23")));
//
//        librarianRole.logout();

//        LocalDate l1= LocalDate.parse("2022-10-29");
//        LocalDate l2= LocalDate.parse("2022-11-28");
//        Long k=DAYS.between(l1,l2);
//        System.out.println(Math.abs(k));
         test1();
         System.out.println("------------------------------------------------------------------");
        // test2();

        }

}

