package tezAlServer.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tezAlServer.domain.User;
import tezAlServer.repo.UsersRepo;
import tezAlServer.security.jwt.JwtUser;
import tezAlServer.security.jwt.JwtUserFactory;
import tezAlServer.service.Impl.UserServiceImpl;

@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {

    private final UserServiceImpl userService;
    private final UsersRepo usersRepo;

    @Autowired
    public JwtUserDetailsService(UserServiceImpl userService, UsersRepo usersRepo) {
        this.userService = userService;
        this.usersRepo = usersRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = usersRepo.findByFirstName(username);

        if (user == null) {
            throw new UsernameNotFoundException("User with username: " + username + " not found");
        }

        JwtUser jwtUser = JwtUserFactory.create(user);
        log.info("IN loadUserByUsername - user with username: {} successfully loaded", username);
        return jwtUser;
    }
}