package org.javaboy.mybatis01.mapper;

import org.javaboy.mybatis01.model.BookUser;

import java.util.List;

public interface BookMapper {
    List<BookUser> getAllBook();
    List<BookUser> getBookByNameOrAuthor(BookUser bookUser1);
    Integer updateBook(BookUser bookUser);
}
