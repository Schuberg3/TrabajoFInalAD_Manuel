package ad.RellTrack.repositories;

import ad.RellTrack.models.Actores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actores, Integer> {
}
