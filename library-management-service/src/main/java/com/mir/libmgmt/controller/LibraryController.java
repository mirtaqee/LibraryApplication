package com.mir.libmgmt.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mir.libmgmt.domain.Library;
import com.mir.libmgmt.model.LibraryDTO;
import com.mir.libmgmt.service.LibraryService;

@RestController
public class LibraryController {

	private static final Logger LOGGER = LogManager.getLogger(LibraryController.class);

	@Autowired
	private LibraryService libraryService;

	@GetMapping(value = "/libraries")
	public List<LibraryDTO> getAllLibraries() {
		LOGGER.debug("Get All Libraries...");
		List<Library> libraryEntities = libraryService.getAllLibraries();
		return convertEntityToDto(libraryEntities);
	}

	private List<LibraryDTO> convertEntityToDto(List<Library> libraryEntities) {
		LibraryDTO libraryDTO = null;
		List<LibraryDTO> libraries = new ArrayList<>();
		for (Library library : libraryEntities) {
			libraryDTO = new LibraryDTO();
			BeanUtils.copyProperties(library, libraryDTO);
			libraries.add(libraryDTO);
		}
		return libraries;
	}

	@GetMapping(value = "/")
	public String pingLibraryService() {
		return "Library service is up!";
	}

}
