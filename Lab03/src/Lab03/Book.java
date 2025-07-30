package Lab03;

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

    public int compareTo(Book otherBook) {
        // We use the title as the key for comparison in the BST
        return this.title.compareTo(otherBook.title);
    }


}
