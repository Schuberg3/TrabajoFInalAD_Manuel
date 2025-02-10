package ad.RellTrack.repositories;

import ad.RellTrack.models.Studios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudioRepository extends JpaRepository<Studios, Integer> {
}
