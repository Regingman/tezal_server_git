package tezAlServer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tezAlServer.domain.RawMaterial;

import java.util.List;

public interface RawMaterialsRepo extends JpaRepository<RawMaterial, Long> {
    }
