package ad.RellTrack.repositories;

import ad.RellTrack.models.UsuarioContenido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioContenidoRepository extends JpaRepository<UsuarioContenido, Integer> {
}
