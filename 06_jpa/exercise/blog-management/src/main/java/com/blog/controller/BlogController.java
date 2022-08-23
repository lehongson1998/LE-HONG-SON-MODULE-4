package com.blog.controller;

import com.blog.model.Blog;
import com.blog.model.User;
import com.blog.service.IBlogService;
import com.blog.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private IUserService iUserService;

    @GetMapping("/")
    public String formLogin(Model model){
        model.addAttribute("users", new User());
        return "/user/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model){
        User user1 = iUserService.login(user);
        if (user1 != null){
            model.addAttribute("msg", "login success");
            model.addAttribute("blogList", blogService.findAll());
            return "/blog/list";
        }else {
            return "/user/login";
        }
    }

    @GetMapping("/list")
    public String listBlog(Model model){
        model.addAttribute("blogList", blogService.findAll());
        return "/blog/list";
    }

    @GetMapping("/view-blog/{id}")
    public ModelAndView viewBlog(@PathVariable long id){
        ModelAndView modelAndView = new ModelAndView("/blog/info");
        Blog blog = blogService.findById(id);
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

    @GetMapping("/showFormCreate")
    public ModelAndView formCreateBlog(){
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("create")
    public ModelAndView createBlog(@ModelAttribute Blog blog){
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        blogService.save(blog);
        return modelAndView;
    }

    @GetMapping("/edit-blog/{id}")
    public ModelAndView formEditBlog(@PathVariable long id){
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        Blog blog = blogService.findById(id);
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView editBlog(@ModelAttribute Blog blog){
        ModelAndView modelAndView = new ModelAndView("/blog/list");
        blogService.save(blog);
        modelAndView.addObject("message", "edit success");
        modelAndView.addObject("blogList", blogService.findAll());
        return modelAndView;
    }

    @PostMapping("/delete-blog/{id}")
    public String deleteBlog(@PathVariable long id, Model model){
        blogService.remove(id);
        model.addAttribute("message", "delete success");
        List<Blog> blogList = blogService.findAll();
        model.addAttribute("blogList", blogList);
        return "/blog/list";
    }
}
