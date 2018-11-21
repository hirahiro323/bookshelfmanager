package jp.co.solidcom.app.entities.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	@Modifying
	@Query(value = "DELETE FROM Books b where b.book_id = :id", nativeQuery = true)
	public void deleteBookById(@Param("id") int id);
}
