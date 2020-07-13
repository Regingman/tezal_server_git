package tezAlServer.service;

import org.springframework.stereotype.Service;
import tezAlServer.domain.ContainerCategory;

import java.util.List;
import java.util.Optional;

@Service
public interface ContainerCategoryService {

    List<ContainerCategory> findAll();

    Optional<ContainerCategory> findById(Long id);

    ContainerCategory save(ContainerCategory containerCategory);

    void deleteById(Long id);

}
