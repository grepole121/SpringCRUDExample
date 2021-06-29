package com.sparta.gr.springcrudexample.repositories;

import com.sparta.gr.springcrudexample.entites.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer> {

}
