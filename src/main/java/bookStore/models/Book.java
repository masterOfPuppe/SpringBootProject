package bookStore.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/* To say that this is a resources you should use Entity.
   Each entity should be have an @Id property.
   If you use @Generated for @Id, the system every time
   will generate a new Id.*/

@Entity
public class Book implements Serializable {

    public Book() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Id
    private long id;
    private String title;
    private String author;
    private double price;

}
