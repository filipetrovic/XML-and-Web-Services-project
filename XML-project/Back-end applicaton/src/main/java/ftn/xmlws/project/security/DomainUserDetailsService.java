//package ftn.xmlws.project.security;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import ftn.xmlws.project.beans.User;
//import ftn.xmlws.project.repository.UserRepository;
//
//@Component
//public class DomainUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//	
//	@Override
//	@Transactional
//	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
//		Optional<User> userByUsernameFromDatabase = userRepository.findOneByUsername(username);
//        return userByUsernameFromDatabase.map(user -> createSpringSecurityUser(user)).orElseThrow(() ->
//                new UsernameNotFoundException("User " + username + " was not found in the " +
//                        "database"));
//	}
//	
//    private org.springframework.security.core.userdetails.User createSpringSecurityUser(User user) {
//  
//        List<GrantedAuthority> grantedAuthorities = user.getAuthorities().stream()
//                .map(authority -> new SimpleGrantedAuthority(authority.getName()))
//                .collect(Collectors.toList());
//        return new org.springframework.security.core.userdetails.User(user.getUsername(),
//                user.getPassword(),
//                grantedAuthorities);
//    }
//
//}
