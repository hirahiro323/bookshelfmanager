package jp.co.solidcom.security;

import static java.util.Collections.emptyList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jp.co.solidcom.app.entities.user.ApplicationUser;
import jp.co.solidcom.app.entities.user.UserRepository;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
    private UserRepository applicationUserRepository;
	
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        ApplicationUser applicationUser = applicationUserRepository.findByUserId(userId);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(userId);
        }
        return new User(applicationUser.getUserId(), applicationUser.getUserPassword(), emptyList());
    }
}
