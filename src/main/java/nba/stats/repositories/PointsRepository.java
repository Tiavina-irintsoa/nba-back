package nba.stats.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import nba.stats.models.Points;

@Repository
public interface PointsRepository extends JpaRepository<Points, Integer> {

}
