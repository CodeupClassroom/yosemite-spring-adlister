package com.codeup.yadlister.quotes;
import javax.persistence.*;

@Entity
@Table(name="quotes")
public class Quote {
    @Id @GeneratedValue
    private long id;

    @Column(nullable = false, length = 512)
    private String quote;

    @Column(nullable = false, length = 256)
    private String author;

    public Quote(long id, String quote, String author) {
        this.id = id;
        this.quote = quote;
        this.author = author;
    }

    public Quote() {

    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
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
}
