package com.blog.repository;

import com.blog.model.Blog;

public interface IBlogRepository extends IGeneralRepository<Blog> {
    void save(Blog blog);
}
