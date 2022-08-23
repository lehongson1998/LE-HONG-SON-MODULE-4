package com.blog.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    private String account;
    private String password;
    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Blog> blogs = new ArrayList<>();

    public User() {
    }

    public User(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
}
