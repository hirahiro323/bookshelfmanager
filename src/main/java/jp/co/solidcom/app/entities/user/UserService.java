package jp.co.solidcom.app.entities.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

	@Autowired
	UserRepository repository;

	public List<ApplicationUser> findAll() {
		return repository.findAll();
	}

	public Optional<ApplicationUser> findOne(String userId) {
		return repository.findById(userId);
	}

	public ApplicationUser update(ApplicationUser user) {
		return repository.save(user);
	}

	public ApplicationUser create(ApplicationUser user) {
		return repository.save(user);
	}

	public void delete(String id) {
		repository.deleteById(id);
	}

}
