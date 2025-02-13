package ad.RellTrack.repositories;

import ad.RellTrack.models.Usuario;
import ad.RellTrack.models.UsuarioContenido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioContenidoRepository extends JpaRepository<UsuarioContenido, Integer> {
    List<UsuarioContenido> findByUser(Usuario usuario);
}
