package jp.co.solidcom.app.book;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookService {

	@Autowired
	BookRepository repository;

	public List<Book> findAll() {
		return repository.findAll();
	}

	public Optional<Book> findOne(Integer id) {
		return repository.findById(id);
	}

	public Book create(Book book) {
		return repository.save(book);
	}

	public Book update(Book book) {
		return repository.save(book);
	}

	public void delete(Integer id) {
		repository.deleteBookById(id);
	}

}
