package com.example.md4_baitapvenha2.model;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBlog;
    private String content;
    private String title;
    @CreationTimestamp
    private LocalDateTime time;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    public Blog() {
    }

    public Blog(Long idBlog, String content, String title, LocalDateTime time, User user, Category category) {
        this.idBlog = idBlog;
        this.content = content;
        this.title = title;
        this.time = time;
        this.user = user;
        this.category = category;
    }

    public Blog(String content, String title, LocalDateTime time, User user, Category category) {
        this.content = content;
        this.title = title;
        this.time = time;
        this.user = user;
        this.category = category;
    }

    public Long getIdBlog() {
        return idBlog;
    }

    public void setIdBlog(Long idBlog) {
        this.idBlog = idBlog;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
