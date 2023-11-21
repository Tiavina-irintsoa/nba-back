package nba.stats.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import nba.stats.models.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer> {

}
