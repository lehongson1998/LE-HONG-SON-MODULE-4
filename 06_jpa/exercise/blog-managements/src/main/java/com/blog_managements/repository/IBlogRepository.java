package com.blog_managements.repository;

import com.blog_managements.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IBlogRepository extends JpaRepository<Blog, Long> {
//    @Query("SELECT e FROM Blog e")
//    Page<Blog> findCustomers(Pageable pageable);
}
