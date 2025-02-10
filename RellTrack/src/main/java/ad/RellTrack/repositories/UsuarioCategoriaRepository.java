package ad.RellTrack.repositories;

import ad.RellTrack.models.UsuarioCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioCategoriaRepository extends JpaRepository<UsuarioCategoria, Integer> {
}
