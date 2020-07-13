package tezAlServer.service;

import org.springframework.stereotype.Service;
import tezAlServer.domain.User;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    List<User> findAll();

    Optional<User> findById(Long id);

    User save(User user);

    void deleteById(Long id);
}
