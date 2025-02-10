package ad.RellTrack.repositories;

import ad.RellTrack.models.Temporadas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemporadaRepository extends JpaRepository<Temporadas, Integer> {
}
