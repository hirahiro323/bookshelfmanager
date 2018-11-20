package jp.co.solidcom.app.user;

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

	public List<User> findAll() {
		return repository.findAll();
	}

	public Optional<User> findOne(String userId) {
		return repository.findByUserId(userId);
	}

	public User update(User user) {
		return repository.save(user);
	}

	public User create(User user) {
		return repository.save(user);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
