package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController
{
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model)
    {
        model.addAttribute("books", bookRepository.findAll()); //we are going to add books from repo to the attribute
                                                                 //on the model called books.
        return "books/list";  //return string Books to the view so it creates a view called Books
    }
}
