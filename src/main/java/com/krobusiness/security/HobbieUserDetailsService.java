package com.krobusiness.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.krobusiness.model.entities.UserEntity;
import com.krobusiness.model.repostiory.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Component
public class HobbieUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public HobbieUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
@Override
// userDetails k method me parameter Object object ko string username me badal dya her jga
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("User with username " + username + " was not found."));

        return mapToUserDetails(userEntity);
    }

    private UserDetails mapToUserDetails(UserEntity userEntity) {

        List<GrantedAuthority> authorities = userEntity.getRoles().stream()
                .map(ur -> new SimpleGrantedAuthority("ROLE_" + ur.getRole().name())).collect(Collectors.toList());
        return new User(
                userEntity.getUsername(),
                userEntity.getPassword(),
                authorities
        );
    }
// is method ko coment kya
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
