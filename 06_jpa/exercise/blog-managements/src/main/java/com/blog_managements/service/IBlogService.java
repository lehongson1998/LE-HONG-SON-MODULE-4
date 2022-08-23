package com.blog_managements.service;

import com.blog_managements.model.Blog;

import java.util.List;

public interface IBlogService{
    List<Blog> findAll();
    Blog findById(Long id);
    void save(Blog blog);
    void remove(Long id);
}
