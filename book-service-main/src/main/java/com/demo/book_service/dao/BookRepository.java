package com.demo.book_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.book_service.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

}
