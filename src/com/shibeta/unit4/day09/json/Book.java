package com.shibeta.unit4.day09.json;

import java.util.Objects;

public class Book {
    private String id;
    private String name;
    private String info;

    public Book() {
    }

    public Book(String id, String name, String info) {
        this.id = id;
        this.name = name;
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(name, book.name) && Objects.equals(info, book.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, info);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
