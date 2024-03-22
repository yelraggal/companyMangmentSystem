package com.company;

import java.time.LocalDate;

public class StudentBook implements Record
{
   private String studentId,bookId; // id of student who borrow the book & bookid that will borrow
   private LocalDate borrowDate;


   public StudentBook(String studentId, String bookId, LocalDate borrowDate)
   {
      this.studentId = studentId;
      this.bookId = bookId;
      this.borrowDate = borrowDate;
   }

   public String getStudentId() {
      return studentId;
   }

   public String getBookId() {
      return bookId;
   }

   public LocalDate getBorrowDate() {
      return borrowDate;
   }

   public String lineRepresentation()
   {
   return studentId +
           "," + bookId +
           "," + String.format("%02d",borrowDate.getDayOfMonth())+'-'+String.format("%02d",borrowDate.getMonthValue())+
           '-'+String.format("%04d",borrowDate.getYear());

   }

   public String getSearchKey()
   {
      return studentId+","+bookId;
   }

}
