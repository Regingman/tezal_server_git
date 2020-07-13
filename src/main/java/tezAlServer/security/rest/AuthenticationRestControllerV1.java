package tezAlServer.security.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tezAlServer.domain.User;
import tezAlServer.dto.AuthenticationRequestDto;
import tezAlServer.repo.UsersRepo;
import tezAlServer.security.jwt.JwtTokenProvider;
import tezAlServer.service.Impl.UserServiceImpl;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping(value = "/api/v1/auth/")
public class AuthenticationRestControllerV1 {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    private final UserServiceImpl userService;

    private final UsersRepo usersRepo;

    @Autowired
    public AuthenticationRestControllerV1(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserServiceImpl userService, UsersRepo usersRepo) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
        this.usersRepo = usersRepo;
    }

    @PostMapping("login")
    public ResponseEntity login(@RequestBody AuthenticationRequestDto requestDto) {
        try {
            System.out.println("Начало авторизации");

            String username = requestDto.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, requestDto.getPassword()));
            User user = usersRepo.findByFirstName(username);
            System.out.println(user);

            if (user == null) {
                throw new UsernameNotFoundException("User with username: " + username + " not found");
            }
            System.out.println("получение пароля");

            String token = jwtTokenProvider.createToken(username, user.getRoles());

            Map<Object, Object> response = new HashMap<>();
            response.put("id", user.getId());
            response.put("username", username);
            response.put("token", token);
            System.out.println(user + "\n" + username+"\n");

            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }
}