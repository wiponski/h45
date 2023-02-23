package kz.attractor.java.lesson44;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LibraryDataModel {
    private BookData books;
    private CustomerData customers;
    private List<CustomerData> customerDataList = new ArrayList<>();
    private List<BookData> bookDataList = new ArrayList<>();

    public LibraryDataModel() {
        this.customerDataList= FileService.readCustomers();
        this.bookDataList= FileService.readBooks();
        this.books = new BookData(1, LocalDate.now(), "test testetstetext");
        this.customers = new CustomerData(1, "Bill");

    }


    public BookData getBooks() {
        return books;
    }

    public void setBooks(BookData books) {
        this.books = books;
    }

    public CustomerData getCustomers() {
        return customers;
    }

    public void setCustomers(CustomerData customers) {
        this.customers = customers;
    }


    public List<BookData> getBookDataList() {
        return bookDataList;
    }

    public List<CustomerData> getCustomerDataList() {
        return customerDataList;
    }

    public void setBookDataList(List<BookData> bookDataList) {
        this.bookDataList = bookDataList;
    }

    public void setCustomerDataList(List<CustomerData> customerDataList) {
        this.customerDataList = customerDataList;
    }
}
