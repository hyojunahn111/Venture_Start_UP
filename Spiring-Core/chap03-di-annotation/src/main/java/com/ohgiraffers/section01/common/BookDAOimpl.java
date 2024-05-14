package com.ohgiraffers.section01.common;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("bookDAO")
public class BookDAOimpl implements BookDAO{

    private Map<Integer, BookDTO> bookList;

    public BookDAOimpl(){
        bookList = new HashMap<>();
        bookList.put(1, new BookDTO(1, 123456, "아이야", "그래야", "포레북", new Date()));
        bookList.put(2, new BookDTO(2, 876554, "일일", "둘둘", "삼삼", new Date()));
    }

    @Override
    public List<BookDTO> selectBookList() {
        return new ArrayList<>(bookList.values());
    }

    @Override
    public BookDTO selectOneBook(int sequence) {
        return bookList.get(sequence);
    }
}
