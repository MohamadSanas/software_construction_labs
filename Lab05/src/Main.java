import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


class BookCatalogException extends Exception{
     BookCatalogException(String message){
        super(message);
    }
}

class InvalidISBNException extends BookCatalogException{
    InvalidISBNException(String message){
        super(message);
    }
}

class DuplicateISBNException extends BookCatalogException{
    DuplicateISBNException(String message){
        super(message);
    }
}

class MalformedBookEntryException extends BookCatalogException{
    MalformedBookEntryException(String message){
        super(message);
    }
}

class InsufficientArgumentsException  extends BookCatalogException {
    InsufficientArgumentsException(String message) {
        super(message);
    }
}

class InvalidFileNameException   extends BookCatalogException {
    InvalidFileNameException (String message) {
        super(message);
    }
}

class Book{

    private String BookTitle;
    private String ISBN;
    private String Name;
    private int copies ;

    Book(String BookTitle,String Name,String ISBN,int copies) throws MalformedBookEntryException, InvalidISBNException {
        if(BookTitle.isEmpty()||Name.isEmpty()||ISBN.isEmpty()||copies<0)
            throw new MalformedBookEntryException("Your entry have a empty field");

        if (!ISBN.matches("\\d{13}"))
            throw new InvalidISBNException("ISBN number is not valid");

        this.BookTitle=BookTitle;
        this.copies=copies;
        this.ISBN=ISBN;
        this.Name=Name;

    }
}

class Catalog{
    int validRec;
    int booksAdded;
    int NumErrors;
    int NumSearchRslt;

}


public class Main {
    public static void main(String[] args) {
        try {
            String line;
            BufferedReader reader = new BufferedReader(new FileReader("Catalog.txt"));
            while((line=reader.readLine())!=null){
                System.out.println(line);
            }
            reader.close();
        }catch (IOException e){
            System.out.println(e);

























        }


    }
}