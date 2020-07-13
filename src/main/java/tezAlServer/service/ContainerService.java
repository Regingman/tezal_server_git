package tezAlServer.service;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tezAlServer.domain.Container;

import java.util.List;
import java.util.Optional;

@Service
public interface ContainerService {

    List<Container> findAll();

    Optional<Container> findById(Long id);

    Container save(Container container);

    void deleteById(Long id);

    List<Container> getAllById(Long id, Pageable pageable);

}
