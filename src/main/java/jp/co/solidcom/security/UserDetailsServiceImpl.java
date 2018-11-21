package jp.co.solidcom.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jp.co.solidcom.app.entities.user.UserRepository;
import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

		Optional<jp.co.solidcom.app.entities.user.User> user = userRepository.findById(userId);
		if (user == null) {
			throw new UsernameNotFoundException(userId);
		}

		//"pass" is encrypted password
		String pass = user.get().getUserPassword();

		List<String> role = new ArrayList();
		role.add(user.get().isAdminFlag() //
					? "ROLE_ADMIN" //
					: "ROLE_USER"); //

		return new User(userId,user.get().getUserPassword(),emptyList());
	}

}