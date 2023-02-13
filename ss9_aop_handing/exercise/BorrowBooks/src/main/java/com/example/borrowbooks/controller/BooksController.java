package com.example.borrowbooks.controller;

import com.example.borrowbooks.exception.InvalidCodeException;
import com.example.borrowbooks.exception.OutOfBooksException;
import com.example.borrowbooks.model.Books;
import com.example.borrowbooks.model.History;
import com.example.borrowbooks.repository.IBooksRepository;
import com.example.borrowbooks.service.impl.BooksService;
import com.example.borrowbooks.service.impl.HistoryService;
import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BooksController {
    @Autowired
    private BooksService booksService;
    private HistoryService historyService;

    @GetMapping(value = "/show-list")
    public String showList(Model model) {
        List<Books> bookList = booksService.showList();
        History history = new History();
        model.addAttribute("bookList", bookList);
        model.addAttribute("history", history);
        return "/list";
    }

    @GetMapping(value ="/borrow-book/{id}")
    public String borrowBook(@PathVariable("id") int id, RedirectAttributes redirectAttributes) throws OutOfBooksException {
        Integer code = booksService.borrowBooks(id);
        String message;
        if (code != null && code != -1){
            message = "Mượn sách thành công!!";
        } else {
            message = "Mượn sách thất bại!!";
        }
        redirectAttributes.addFlashAttribute("message", message);
        redirectAttributes.addFlashAttribute("code", code);
        return "redirect:/show-list";
    }

    @PostMapping(value = "/return-book")
    public String returnBook(History history, RedirectAttributes redirectAttributes) throws InvalidCodeException {
        boolean check = booksService.returnBooks(history.getCode());
        String message;
        if (check) {
            message = "Trả sách thành công!!";
        } else {
            message = "Trả thất bại, mời nhập lại!";
        }
        redirectAttributes.addFlashAttribute("massage", message);
        return "redirect:/show-list";
    }
}
