package com.mir.libmgmt.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mir.libmgmt.domain.Library;
import com.mir.libmgmt.repo.LibraryRepository;

@Service
public class LibraryService {

	private static final Logger LOGGER = LogManager.getLogger(BookService.class);

	@Autowired
	private LibraryRepository repository;

	public List<Library> getAllLibraries() {
		final List<Library> libraries = new ArrayList<>();
		repository.findAll().forEach(library -> libraries.add(library));
		LOGGER.debug("No. of Libraries: " + libraries.size());
		return libraries;
	}

}
