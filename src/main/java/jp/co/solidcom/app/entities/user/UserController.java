package jp.co.solidcom.app.entities.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
@RequestMapping("/users")
@CrossOrigin(origins = "https://bookshelfmanager-cdf7b.firebaseapp.com")
public class UserController {

	@Autowired
	UserService service;

	private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	@PostMapping("/sign-up")
	public void signUp(@RequestBody User user) {
		user.setUserPassword(bCryptPasswordEncoder.encode(user.getUserPassword()));
		service.create(user);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<User> index() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Optional<User> getBook(@PathVariable String userId) {
		return service.findOne(userId);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User putBook(@PathVariable("id") String id, @RequestBody User user) {
		user.setUserId(id);
		return service.update(user);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable String id) {
		service.delete(id);
	}

}
