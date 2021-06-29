package com.sparta.gr.springcrudexample.controllers;

import com.sparta.gr.springcrudexample.entites.BookEntity;
import com.sparta.gr.springcrudexample.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.print.Book;

@Controller
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String welcome(Model model){
        model.addAttribute("books", bookService.getAllBooks());
        return "index";
    }

    @PostMapping("/add")
    public String addBook(@RequestParam(name = "title") String title, @RequestParam(name = "author") String author){
        BookEntity bookEntity = new BookEntity();
        bookEntity.setAuthor(author);
        bookEntity.setTitle(title);
        bookService.saveBook(bookEntity);
        return "redirect:/";
    }

    @GetMapping("/register")
    public String showAddPage(BookEntity bookEntity, Model model){
        model.addAttribute("book", bookEntity);
        return "add-form";
    }

    @GetMapping("/edit/{id}")
    public String updateBook(@PathVariable("id") Integer id, Model model){
        model.addAttribute("book", bookService.findBookById(id));
        return "edit";
    }

    @PostMapping("/update/{id}")
    public String updateBook(BookEntity bookEntity){
        bookService.saveBook(bookEntity);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Integer id){
        bookService.deleteBook(id);
        return "redirect:/";
    }
}
