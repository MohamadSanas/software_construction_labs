import java.io.File;
import java.io.IOException;

class  BookCatalogException extends Exception{
    BookCatalogException(String Message){
        super(Message);
    }
}

class InvalidISBNException extends BookCatalogException{
    InvalidISBNException(String message){
        super(message);
    }
}

class DuplicateISBNException extends BookCatalogException{
    DuplicateISBNException (String message){
        super(message);
    }
}

class MalformedBookEntryException extends BookCatalogException{
    MalformedBookEntryException(String message){
        super(message);
    }
}

class InsufficientArgumentsException extends BookCatalogException{
    InsufficientArgumentsException(String message){
        super(message);
    }
}

class InvalidFileNameException extends BookCatalogException{
    InvalidFileNameException(String message){
        super(message);
    }
}

class Book{
    private String BookTitle;
    private String AuthorName;
    private String ISBN;
    private int copies;

    Book(String BookTitle,String AuthorName, String ISBN, int copies){
        this.BookTitle=BookTitle;
        this.copies=copies;
        this.AuthorName=AuthorName;
        this.ISBN=ISBN;
    }
}


public class LibraaryTracker {
    static int validRecords = 0, searchResults = 0, booksAdded = 0, errors = 0;

    static Book Bookdata(String line) throws MalformedBookEntryException, InvalidISBNException {
        String [] parts = line.split(":");
        if(parts.length!=4)
            throw new MalformedBookEntryException("Invalid formate");
        String title =parts[0];
        String author=parts[1];
        String isbn =parts[2];
        String copies=parts[3];

        if(isbn.matches("\\d{13}"))
            throw new InvalidISBNException("invalid isbn");
        int cop=Integer.parseInt(copies);



        return new Book(title,author,isbn,cop);
    }

    public void addBook(){

    }

    public static void main(String [] args) throws InvalidFileNameException {
        try{
            if(args.length<2)
                throw new InsufficientArgumentsException("Argument can not less then 2");
            String filename=args[0];
            if(!filename.endsWith(".txt"))
                throw new InvalidFileNameException("File name is invalid");


            File file = new File(filename);
            if(!file.exists()){
                file.getParentFile().mkdirs();
                file.createNewFile();
            }

        }catch (InsufficientArgumentsException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}