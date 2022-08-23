package com.blog.model;

import javax.persistence.*;

@Entity
@Table(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "blog_name")
    private String blogName;
    @Column(name = "author")
    private String authorName;
    @Column(name = "blog_content", columnDefinition = "text")
    private String blogContent;
    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "account", nullable = false)
    private User users;

    public Blog() {
    }

    public Blog(Long id, String blogName, String authorName, String blogContent) {
        this.id = id;
        this.blogName = blogName;
        this.authorName = authorName;
        this.blogContent = blogContent;
    }



    public User getUser() {
        return users;
    }

    public void setUser(User user) {
        this.users = user;
    }

    public Blog(Long id, String blogName, String authorName, String blogContent, User user) {
        this.id = id;
        this.blogName = blogName;
        this.authorName = authorName;
        this.blogContent = blogContent;
        this.users = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }
}
