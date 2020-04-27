package com.mir.libmgmt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mir.libmgmt.domain.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

	@Query(value = "SELECT * FROM BOOK B WHERE B.LIBRARY_ID = ?1", nativeQuery = true)
	List<Book> findByLibraryId(@Param("libraryId") Integer libraryId);

	@Modifying
	@Query(value = "DELETE FROM BOOK WHERE ID=:id AND LIBRARY_ID =:libraryId", nativeQuery = true)
	void deleteByIdAndLibraryId(@Param("libraryId") Integer libraryId, @Param("id") Integer id);

}
