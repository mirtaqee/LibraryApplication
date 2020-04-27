package com.mir.libmgmt.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mir.libmgmt.domain.Library;

@Repository
public interface LibraryRepository extends CrudRepository<Library, Integer> {

}
