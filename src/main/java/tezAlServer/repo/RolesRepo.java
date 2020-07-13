package tezAlServer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tezAlServer.domain.Role;

public interface RolesRepo extends JpaRepository<Role, Long> {
}
