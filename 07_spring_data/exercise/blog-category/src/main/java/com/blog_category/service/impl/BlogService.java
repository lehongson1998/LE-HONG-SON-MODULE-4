package com.blog_category.service.impl;

import com.blog_category.repository.IBlogRepository;
import com.blog_category.model.Blog;
import com.blog_category.repository.IBlogRepository;
import com.blog_category.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(String name, String cName, Pageable pageable) {
        return blogRepository.findByBlogNameContainingAndCategory_CategoryNameContaining(name, cName, pageable);
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepository.delete(findById(id));
    }
}
