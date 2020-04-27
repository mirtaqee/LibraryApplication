package com.mir.libmgmt.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mir.libmgmt.domain.Book;
import com.mir.libmgmt.repo.BookRepository;

@Service
public class BookService {

	private static final Logger LOGGER = LogManager.getLogger(BookService.class);

	@Autowired
	private BookRepository bookRepository;

	@Transactional
	public List<Book> getAllBooks(Integer libraryId) {
		final List<Book> books = new ArrayList<>();
		bookRepository.findByLibraryId(libraryId).forEach(book -> {
			books.add(book);
			LOGGER.debug("Get all Books - Book Id= " + book.getId());
		});
		LOGGER.debug("No. of Books: " + books.size());
		return books;
	}

	@Transactional
	public boolean addBook(Book book) {
		LOGGER.debug("Add Book Service...");
		return bookRepository.save(book) != null;
	}

	@Transactional
	public boolean updateBook(Book book) {
		LOGGER.debug("Update Book Service...");
		return bookRepository.save(book) != null;
	}

	@Transactional
	public void deleteBook(Integer libraryId, Integer bookId) {
		LOGGER.debug("Delete Book Service...");
		bookRepository.deleteByIdAndLibraryId(libraryId, bookId);
	}

}
