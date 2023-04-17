package ufg.labtime.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ufg.labtime.backend.entity.Usuario;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findByFullNameContaining(String fullName);

    List<Usuario> findBySocialNameContaining(String socialName);

    List<Usuario> findByEmailContaining(String email);
}
