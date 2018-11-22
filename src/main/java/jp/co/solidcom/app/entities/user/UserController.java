package jp.co.solidcom.app.entities.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
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

import jp.co.solidcom.security.JwtTokenUtil;

@RestController
@ResponseBody
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	UserService service;
	
	@Autowired
	UserDetailsService detailsService;  

	JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();

	private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	@PostMapping("/signup")
	public void signUp(@RequestBody ApplicationUser user) {
		user.setUserPassword(bCryptPasswordEncoder.encode(user.getUserPassword()));
		service.create(user);
	}

	@PostMapping("/login")
	public ResponseEntity login(@RequestBody ApplicationUser loginUser) throws AuthenticationException {

//		final Authentication authentication = authenticationManager.authenticate(
//				new UsernamePasswordAuthenticationToken(loginUser.getUserId(), loginUser.getUserPassword()));
//		SecurityContextHolder.getContext().setAuthentication(authentication);
		Optional<ApplicationUser> user = service.findOne(loginUser.getUserId());
		;
		if(!bCryptPasswordEncoder.matches(loginUser.getUserPassword(), user.get().getUserPassword())) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		
		final String token = jwtTokenUtil.generateToken(user.get());
		return ResponseEntity.ok(token);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<ApplicationUser> index() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Optional<ApplicationUser> getBook(@PathVariable String userId) {
		return service.findOne(userId);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApplicationUser putBook(@PathVariable("id") String id, @RequestBody ApplicationUser user) {
		user.setUserId(id);
		return service.update(user);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable String id) {
		service.delete(id);
	}

}
