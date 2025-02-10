package ad.RellTrack.repositories;

import ad.RellTrack.models.Generos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepository extends JpaRepository<Generos, Integer> {
}
