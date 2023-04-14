package ufg.labtime.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ufg.labtime.backend.entity.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {
}
