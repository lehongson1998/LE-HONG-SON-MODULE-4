package com.blog.service.impl;

import com.blog.model.Blog;
import com.blog.repository.IBlogRepository;
import com.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepository.remove(id);
    }
}
