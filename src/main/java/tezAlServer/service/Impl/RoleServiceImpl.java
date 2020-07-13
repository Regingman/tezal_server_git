package tezAlServer.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tezAlServer.domain.Role;
import tezAlServer.repo.RolesRepo;
import tezAlServer.service.RoleService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RolesRepo rolesRepo;

    @Override
    public List<Role> findAll() {
        return rolesRepo.findAll();
    }

    @Override
    public Optional<Role> findById(Long id) {
        return rolesRepo.findById(id);
    }

    @Override
    public Role save(Role container) {
        container.setCreateDate(LocalDateTime.now());
        container.setUpdateDate(LocalDateTime.now());
        return rolesRepo.save(container);
    }

    @Override
    public void deleteById(Long id) {
        rolesRepo.deleteById(id);
    }
}
