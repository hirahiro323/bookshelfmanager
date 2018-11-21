package jp.co.solidcom.app.entities.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	@Override
	@Modifying
	@Query(value = "DELETE FROM users where user_id = :id", nativeQuery = true)
	public void deleteById(@Param("id") String id);

}
