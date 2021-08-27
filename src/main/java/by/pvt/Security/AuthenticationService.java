
package by.pvt.Security;

import by.pvt.pojo.AppUser;
import by.pvt.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.stream.Collectors;
@Service("authService")
@Transactional
public class AuthenticationService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        AppUser appUser = userRepository.findUserByLogin(userName);
        if(appUser==null){
            throw new UsernameNotFoundException("Username " + userName + " not found");
        }
        return new User(appUser.getUsername(), appUser.getPassword(), appUser.getRoles().stream()
                .map(appRole -> new SimpleGrantedAuthority("ROLE_" + appRole.getRoleName().name()))
                .collect(Collectors.toList()));

    }
}

