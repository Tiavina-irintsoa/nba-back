package nba.stats.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import nba.stats.models.JoeurEquipe;

@Repository
public interface JoeurEquipeRepository extends JpaRepository<JoeurEquipe, Integer> {

}
