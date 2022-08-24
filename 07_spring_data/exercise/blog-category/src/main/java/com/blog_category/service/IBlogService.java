package com.blog_category.service;

import com.blog_category.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService{
    Page<Blog> findAll(String name, String cName, Pageable pageable);
    Blog findById(Long id);
    void save(Blog blog);
    void remove(Long id);
}
