package com.example.borrowbooks.service.impl;

import com.example.borrowbooks.exception.InvalidCodeException;
import com.example.borrowbooks.exception.OutOfBooksException;
import com.example.borrowbooks.model.Books;
import com.example.borrowbooks.model.History;
import com.example.borrowbooks.repository.IBooksRepository;
import com.example.borrowbooks.service.IBooksService;
import com.example.borrowbooks.service.IHistoryService;
import org.hibernate.dialect.lock.OptimisticEntityLockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(rollbackFor = Throwable.class)
@Service
public class BooksService implements IBooksService {
    @Autowired
    private IBooksRepository booksRepository;

    @Autowired
    private IHistoryService historyService;

    @Override
    public List<Books> showList() {
        return booksRepository.findAll();
    }

    @Override
    public Integer borrowBooks(int id) throws OutOfBooksException {
        Books books = booksRepository.findById(id).orElse(null);
        if (books == null) {
            return -1;
        }
        if (books.getAmount() == 0) {
            throw new OutOfBooksException("");
        }
        books.setAmount(books.getAmount() - 1);
        int code = (int) Math.floor(((Math.random()) * 89999) + 10000);
        History history = new History();
        history.setBookId(books.getId());
        history.setCode(code);
        historyService.addHistory(history);
        try {
            booksRepository.save(books);
        } catch (IllegalArgumentException | OptimisticEntityLockException e) {
            return null;
        }
        return code;
    }

    @Override
    public boolean returnBooks(int code) throws InvalidCodeException {
        Optional<History> history = historyService.getBooksByCode(code);
        if (history.isPresent()) {
            int bookId = history.get().getBookId();
            Books books = booksRepository.findById(bookId).get();
            books.setAmount(books.getAmount() + 1);
            try {
                booksRepository.save(books);
            } catch (IllegalArgumentException | OptimisticEntityLockException e){
                return false;
            }
            historyService.deleteHistory(code);
            return true;
        } else {
            throw new InvalidCodeException("Code không hợp lệ");
        }
    }
}
