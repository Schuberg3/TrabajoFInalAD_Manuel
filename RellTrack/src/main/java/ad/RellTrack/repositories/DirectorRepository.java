package ad.RellTrack.repositories;

import ad.RellTrack.models.Directores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Directores, Integer> {
}
