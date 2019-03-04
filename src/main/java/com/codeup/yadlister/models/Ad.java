package com.codeup.yadlister.models;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="ads")
public class Ad {

    @Id @GeneratedValue
    private long id;

    @Column(nullable = false, length = 512)
    private String title;

    @Column(nullable = false, length = 2048)
    private String description;

    @OneToOne
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ad")
    private List<AdImage> images;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "ads_categories",
            joinColumns={@JoinColumn(name = "ad_id")},
            inverseJoinColumns={@JoinColumn(name = "category_id")}
    )
    private List<Category> categories;

    public Ad(long id, String title, String description, User user, List<AdImage> images, List<Category> categories) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.user = user;
        this.images = images;
        this.categories = categories;
    }

    public Ad() {
    }

    public Ad(String title, String description, User user, List<AdImage> images, List<Category> categories) {
        this.title = title;
        this.description = description;
        this.user = user;
        this.images = images;
        this.categories = categories;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<AdImage> getImages() {
        return images;
    }

    public void setImages(List<AdImage> images) {
        this.images = images;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}

