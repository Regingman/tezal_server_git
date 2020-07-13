package tezAlServer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tezAlServer.domain.User;

public interface UsersRepo extends JpaRepository<User, Long> {
    User findByFirstName(String Name);
}
