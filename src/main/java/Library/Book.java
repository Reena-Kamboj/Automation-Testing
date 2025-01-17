package Library;

public class Book {
    private  final String title;
    private final String author;


    public Book(String title,String author){
        this.title=title;
        this.author=author;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Book){
            Book b= (Book)o;
            return b.getTitle().equalsIgnoreCase(this.getTitle())
                    && b.getAuthor().equals(this.getAuthor());
        }
        else return false;
    }
}
