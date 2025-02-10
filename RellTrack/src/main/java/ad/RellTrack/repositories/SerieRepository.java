package ad.RellTrack.repositories;

import ad.RellTrack.models.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SerieRepository extends JpaRepository<Series, Integer> {
}
