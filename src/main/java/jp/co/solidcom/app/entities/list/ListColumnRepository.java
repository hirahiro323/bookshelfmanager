package jp.co.solidcom.app.entities.list;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ListColumnRepository extends JpaRepository<ListColumn, Integer> {

	@Query("SELECT b, u  FROM ListColumn b LEFT JOIN b.user u order by b.id")
	public List<ListColumn> findList();

	@Override
	@Query("SELECT b, u  FROM ListColumn b LEFT JOIN b.user u where b.id = :id")
	public Optional<ListColumn> findById(@Param("id") Integer id);
}
