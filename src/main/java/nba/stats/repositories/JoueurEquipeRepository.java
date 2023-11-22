package nba.stats.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nba.stats.models.JoueurEquipe;

@Repository
public interface JoueurEquipeRepository extends JpaRepository<JoueurEquipe, Integer> {

}
