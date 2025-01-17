package Library;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LibraryTest {
    private  static  final Book LORD_OF_THE_FLIES= new Book("Lord of the Flies","Fred Perry");
    private  static  final Book LORD_OF_THE_RINGS= new Book("Lord of the Rings","John Smith");
    private  static  final Book WAR_AND_PEACE= new Book("War and Peace","Lord Bennett");
    private  static  final Book HARRY_POTTER= new Book("Harry Potter","J.K.Rowling");

    private final Library library= new Library();

    @Before
    public void initialize(){
        library.add(LORD_OF_THE_FLIES);
        library.add(LORD_OF_THE_RINGS);
        library.add(WAR_AND_PEACE);
    }
    @Test
    public void searchReturnsTheBook(){
        List<Book> results= library.search("Lord of the Flies");
        assertEquals("matching Book",1,results.size());

        Book book= results.get(0);
        assertEquals(LORD_OF_THE_FLIES,book);
        assertEquals("Lord of the Flies",book.getTitle());
    }

    @Test
    public void testIfBookTitleCaseInSenstive() {
        List<Book> results = library.search("lord of the Flies");
        assertEquals("matching Book", 1, results.size());
    }

    @Test
    public  void searchReturnsBookMatchingTitleOrAuthor(){
        List<Book> results=library.search("lord");
        assertEquals("matching Books", 3,results.size());
        assertTrue(results.contains(LORD_OF_THE_FLIES));
        assertTrue(results.contains(LORD_OF_THE_RINGS));
        assertTrue(results.contains(WAR_AND_PEACE));
        assertFalse(results.contains(HARRY_POTTER));


    }

}
