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



class Book{
    private int id;
    private String title;
    private String author;
    private boolean available;


    Book(int id,String title,String author,boolean available) {
        this.id = id;
        this.title=title;
        this.author=author;
        this.available=available;
    }

    public void displayBookDetails(){
        System.out.println("ID: "+id);
        System.out.println("Title: "+ title);
        System.out.println("Author: "+author);
        System.out.println("Availability: "+available);
        System.out.println();
    }

    public void  setTitle(String title){
        this.title=title;
    }

    public String getTitle(){
        return title;
    }
}

public class main {
    public static void main(String []args){
        Book book1 = new Book(837475, "Python Programming", "Sanas M.M.", true);
        Book book2 = new Book(673428, "Database System", "Riyasaath M.", false);
        Book book3 = new Book(755400, "Power of Money", "Aakil A.A", true);


        book1.displayBookDetails();
        book2.displayBookDetails();
        book3.displayBookDetails();


        Book aliasBook = book1;

        // changing the  book1 title by using aliasBook
        aliasBook.setTitle("Advanced Python Programming");

        // Displaying the book details using both references
        System.out.println("Details using book1 reference: ");
        book1.displayBookDetails();

        System.out.println("Details using aliasBook reference:");
        aliasBook.displayBookDetails();

        /* Explanation:
         Both references that are book1 and aliasBook point to the same object in memory.
         So, any changes made through one of that, reference are pointing same details when accessed via the other reference.
         This is called  aliasing.
         */

        Library myLibrary =new Library();

        //add Books to myLibrary
        myLibrary.AddBook(book1);
        myLibrary.AddBook(book2);
        myLibrary.AddBook(book3);

        //Display all book from library
        myLibrary.displayBooks();

        //remove book from library
        myLibrary.removeBook(book1);

        myLibrary.displayBooks();





    }
}
