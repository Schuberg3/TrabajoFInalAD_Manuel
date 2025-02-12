package ad.RellTrack.repositories;

import ad.RellTrack.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findUsuarioByNombreIgnoreCase(String nombre);
}
