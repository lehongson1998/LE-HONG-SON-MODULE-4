package com.book_library.controller;

import com.book_library.model.Book;
import com.book_library.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class BookController {

    @Autowired
    private IBookService iBookService;

    @GetMapping("")
    public String listBook(@PageableDefault(size = 2)Pageable pageable,
                           Model model,
                           @RequestParam Optional<String> name){
        String keyName = name.orElse("");
        model.addAttribute("bookPage", iBookService.findAllBook(keyName, pageable));
        model.addAttribute("keyName", keyName);
        return "book/list";
    }

    @GetMapping("/info/{id}")
    public String bookInfo(@PathVariable Long id, Model model){
        model.addAttribute("book", iBookService.findById(id));
        return "book/info";
    }

    @PostMapping("/borrow")
    public String borrowBook(@RequestParam Long id, Model model) throws Exception {
        Book book = iBookService.findById(id);
        if (book.getAmount() == 0){
            throw new Exception();
        }else {
            iBookService.borrowBook(id);
            model.addAttribute("book", iBookService.findById(id));
            return "book/info";
        }
    }

    @GetMapping("/giveBack")
    public String giveBackForm(){
        return "book/give";
    }

    @PostMapping("/give")
    public String giveBack(@RequestParam long id) throws Exception {
        Book book = iBookService.findById(id);
        if (book.getAmount() == book.getTotalAmount()){
            throw new Exception();
        }else {
            iBookService.giveBookBack(id);
            return "book/give";
        }
    }

    @ExceptionHandler(value = Exception.class)
    public String errors(){
        return "book/errors";
    }
}
