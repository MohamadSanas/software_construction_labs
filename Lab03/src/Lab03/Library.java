package Lab03;

import java.util.ArrayList;

class Library{
    private ArrayList<Book> bookList;

    public Library() {
        bookList = new ArrayList<>();
    }

    public void AddBook(Book newBook){
        bookList.add(newBook);
        System.out.println(newBook.getTitle()+" Book added.\n");
    }

    public void removeBook(Book DltBook) {
        if (bookList.remove(DltBook)) {
            System.out.println(DltBook.getTitle()+" Book removed.\n");
        } else {
            System.out.println(DltBook.getTitle()+ " Book not found.\n");
        }
    }

    public void displayBooks() {
        System.out.println("Book List:");
        for (Book book : bookList) {
            book.displayBookDetails();
        }
    }

}