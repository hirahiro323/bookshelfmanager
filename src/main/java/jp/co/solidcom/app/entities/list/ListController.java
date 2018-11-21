package jp.co.solidcom.app.entities.list;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jp.co.solidcom.app.entities.book.Book;
import jp.co.solidcom.app.entities.book.BookService;

@RestController
@ResponseBody
@RequestMapping("/api")
@CrossOrigin(origins = "https://bookshelfmanager-cdf7b.firebaseapp.com")
public class ListController {

	@Autowired
	BookService service;

	@Autowired
	ListColumnService listService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<ListColumn> index() {
		return listService.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Optional<ListColumn> getBook(@PathVariable Integer id) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userId = (String)(auth.getPrincipal());
		System.out.println(userId);
		
		return listService.findOne(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Book postBook(@RequestBody Book book) {
		return service.create(book);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Book putBook(@PathVariable("id") Integer id, @RequestBody Book book) {
		book.setId(id);
		return service.update(book);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBook(@PathVariable Integer id) {
		service.delete(id);
	}

}
