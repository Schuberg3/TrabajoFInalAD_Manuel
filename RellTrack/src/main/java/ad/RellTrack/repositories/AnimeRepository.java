package ad.RellTrack.repositories;

import ad.RellTrack.models.Animes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimeRepository extends JpaRepository<Animes, Integer> {
}
