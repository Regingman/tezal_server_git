package tezAlServer.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tezAlServer.domain.User;
import tezAlServer.repo.UsersRepo;
import tezAlServer.service.UserService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UsersRepo usersRepo;

    @Override
    public List<User> findAll() {
        return usersRepo.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return usersRepo.findById(id);
    }

    @Override
    public User save(User user) {
        user.setCreateDate(LocalDateTime.now());
        user.setUpdateDate(LocalDateTime.now());
        return usersRepo.save(user);
    }

    @Override
    public void deleteById(Long id) {
        usersRepo.deleteById(id);
    }
}
