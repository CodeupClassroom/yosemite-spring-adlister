package com.codeup.yadlister.models;
import javax.persistence.*;

@Entity
@Table(name="ads")
public class Ad {
    @Id @GeneratedValue
    private long id;

    @Column(nullable = false, length = 512)
    private String title;

    @Column(nullable = false, length = 2048)
    private String description;

    public Ad(long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Ad() {
    }

    public Ad(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
