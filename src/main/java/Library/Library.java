package Library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Library {
    private final List<Book> books= new ArrayList<>();

    public List<Book> search(String searchString){
        Book matchingBook=null;
        List<Book> matchingBooks=  new ArrayList<>();
        for(Book b:books){
            if(b.getTitle().toUpperCase().contains(searchString.toUpperCase())
                    ||b.getAuthor().toUpperCase().contains(searchString.toUpperCase())){

                matchingBooks.add(b);
            }
        }
        return matchingBooks;
       // return Arrays.asList(matchingBook);
        //return Arrays.asList(new Book("Lord of the Flies","Fred Perry"));
    }

    public void add(Book book){
        books.add(book);

    }
}
