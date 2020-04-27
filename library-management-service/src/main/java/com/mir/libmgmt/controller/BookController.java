package com.mir.libmgmt.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mir.libmgmt.domain.Book;
import com.mir.libmgmt.domain.Library;
import com.mir.libmgmt.model.BookDTO;
import com.mir.libmgmt.service.BookService;

@RestController
public class BookController {

	private static final Logger LOGGER = LogManager.getLogger(BookController.class);

	@Autowired
	private BookService bookService;

	@GetMapping(value = "/libraries/{libraryId}/books")
	public List<BookDTO> getAllLibraryBooks(@PathVariable(value = "libraryId") Integer libraryId) {
		LOGGER.debug("Get Library Books for library Id = " + libraryId);
		List<Book> bookEntities = bookService.getAllBooks(libraryId);
		return convertEntityToDto(bookEntities);
	}

	@PostMapping(value = "/libraries/{libraryId}/books")
	public boolean addLibraryBook(@PathVariable(value = "libraryId") Integer libraryId,
			final @RequestBody @Valid BookDTO bookDto) {
		LOGGER.debug("Add Library Book for library Id = " + libraryId);
		Book book = new Book();
		BeanUtils.copyProperties(bookDto, book);
		book.setLibraryId(new Library(libraryId));
		boolean status = bookService.addBook(book);
		return status;
	}

	@PutMapping(value = "/libraries/{libraryId}/books")
	public boolean updateLibraryBook(@PathVariable(value = "libraryId") Integer libraryId,
			final @RequestBody @Valid BookDTO bookDto) {
		LOGGER.debug("Edit Library Book for library Id = " + libraryId);
		Book book = new Book();
		BeanUtils.copyProperties(bookDto, book);
		book.setLibraryId(new Library(libraryId));
		boolean status = bookService.updateBook(book);
		return status;
	}

	@DeleteMapping(value = "/libraries/{libraryId}/books/{bookId}")
	public String deleteLibraryBook(@PathVariable(value = "libraryId") Integer libraryId,
			@PathVariable(value = "bookId") Integer bookId) {
		LOGGER.debug("Delete Library Book for library Id = " + libraryId);
		Book book = new Book();
		book.setLibraryId(new Library(libraryId));
		bookService.deleteBook(libraryId, bookId);
		return "Deleted";
	}

	private List<BookDTO> convertEntityToDto(List<Book> bookEntities) {
		BookDTO bookDTO = null;
		List<BookDTO> books = new ArrayList<>();
		for (Book library : bookEntities) {
			bookDTO = new BookDTO();
			BeanUtils.copyProperties(library, bookDTO);
			books.add(bookDTO);
		}
		return books;
	}
}
