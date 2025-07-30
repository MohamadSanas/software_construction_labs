package Lab03;


import java.util.*;

class GraphBook{
    private Map<Book, List<Book>> adjList ;

    GraphBook(){
        adjList = new HashMap<>();
    }

    public void AddBook(Book newBook){
        adjList.computeIfAbsent(newBook, k -> new ArrayList<>()).add(newBook);

    }

    public void addRecommendation(Book Book1, Book Book2){
        if(adjList.containsKey(Book1)){
            adjList.get(Book1).add(Book2);
        }else{
            List<Book> recomandation = new ArrayList<>();
            recomandation.add(Book2);
            adjList.put(Book1, recomandation);

        }
    }

    public void displayRecommendations(Book book){
        if(adjList.containsKey(book)) {
            System.out.println(adjList.get(book));
        }else{
            System.out.println(book + " does not exist.");
        }

    }

    public void DFS (Book start){
        Set<Book> visited= new HashSet<>();
        dfsHelp(start,visited);


    }

    public void dfsHelp(Book start,Set<Book> visited){
        if(visited.contains(start) || !adjList.containsKey(start)){
            return;
        }

        visited.add(start);

        for (Book next: adjList.get(start)){
            dfsHelp(next,visited);
        }
    }


}


class BookNode{
    Book book;
    BookNode left;
    BookNode right;

    BookNode(Book book){
        this.book = book;
        this.left=null;
        this.right=null;
    }

}

class BookCatalog{
    private BookNode root;

    BookCatalog(){
        this.root=null;
    }

    public void insert (Book book){
        root=insertBook(root,book);

    }

    public BookNode insertBook(BookNode current,Book newBook ){

        if(current==null){
            return new BookNode(newBook);
        }

        int comapre= newBook.compareTo(current.book);

        if(comapre<0){
            current.left=insertBook(current.left,newBook);
            return current;
        }
        else if(comapre>0){
            current.right=insertBook(current.right,newBook);
        }
        else{
            return current;
        }
        return current;
    }

    public BookNode searchBook(Book book){
        if(root==null){
            return null;
        }
        if(root.book==book){
            return root;
        }
        int comapre= book.compareTo(root.book);

        if (comapre >0 ){
            return searchBook(root.right.book);
        }
        else if (comapre < 0){
            return searchBook(root.left.book);
        }
        return root;
    }

    public void inOrdertravasal(BookNode book){
        if(book==null){
            return;
        }
        inOrdertravasal(book.left);
        System.out.print(book.book+"\n");
        inOrdertravasal(book.right);

    }


    public class main{
        public static void main(String[] args){

                    // Create book instances
                    Book book1 = new Book(46454, "Java", "Sanas", true);
                    Book book2 = new Book(12121, "Python", "Anas", true);
                    Book book3 = new Book(34343, "C++", "Zaid", true);
                    Book book4 = new Book(88888, "AI", "Nash", true);

                    // BST: BookCatalog
                    BookCatalog bst = new BookCatalog();
                    bst.insert(book1);
                    bst.insert(book2);
                    bst.insert(book3);
                    bst.insert(book4);

                    System.out.println("In-order Traversal of BST:");
                    bst.inOrdertravasal(bst.root); // root is private, make it public or add a getter

                    // Graph: GraphBook
                    GraphBook graph = new GraphBook();
                    graph.AddBook(book1);
                    graph.AddBook(book2);
                    graph.AddBook(book3);
                    graph.AddBook(book4);

                    // Add recommendation connections
                    graph.addRecommendation(book1, book2);
                    graph.addRecommendation(book1, book3);
                    graph.addRecommendation(book2, book4);

                    System.out.println("\nRecommendations from Book 1:");
                    graph.displayRecommendations(book1);

                    System.out.println("\nDFS starting from Book 1:");
                    graph.DFS(book1);
        }



    }

}