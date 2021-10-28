package org.javaboy.mybatis01.model;

import org.apache.ibatis.annotations.Param;

public class BookUser {
    private int id;
    private String name;
    private int author;
    public BookUser(){}

    public BookUser(@Param("id") int id,@Param("name") String name,@Param("author") int author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    @Override
    public String toString() {
        return "BookUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author=" + author +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }
}
