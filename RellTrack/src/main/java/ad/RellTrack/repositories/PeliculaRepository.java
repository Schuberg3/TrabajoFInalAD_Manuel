package ad.RellTrack.repositories;

import ad.RellTrack.models.Peliculas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepository extends JpaRepository<Peliculas, Integer> {
}
