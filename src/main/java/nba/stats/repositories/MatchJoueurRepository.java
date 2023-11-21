package nba.stats.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import nba.stats.models.MatchJoueur;

@Repository
public interface MatchJoueurRepository extends JpaRepository<MatchJoueur, Integer> {

}
