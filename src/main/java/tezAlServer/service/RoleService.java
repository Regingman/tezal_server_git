package tezAlServer.service;

import org.springframework.stereotype.Service;
import tezAlServer.domain.Role;

import java.util.List;
import java.util.Optional;

@Service
public interface RoleService {
    List<Role> findAll();

    Optional<Role> findById(Long id);

    Role save(Role role);

    void deleteById(Long id);
}
