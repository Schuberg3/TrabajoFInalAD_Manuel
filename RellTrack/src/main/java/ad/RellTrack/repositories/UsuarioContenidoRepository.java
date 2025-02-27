package ad.RellTrack.repositories;

import ad.RellTrack.models.Contenido;
import ad.RellTrack.models.Usuario;
import ad.RellTrack.models.UsuarioContenido;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioContenidoRepository extends JpaRepository<UsuarioContenido, Integer> {
    List<UsuarioContenido> findByUser(Usuario usuario);
    boolean existsByUserAndContent(Usuario user, Contenido content);

    @Transactional
    @Modifying
    @Query("DELETE FROM UsuarioContenido uc WHERE uc.id.userId = :userId AND uc.id.contentId = :contentId")
    void deleteByUserIdAndContentId(Integer userId, Integer contentId);
}
