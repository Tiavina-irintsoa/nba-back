package nba.stats.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import nba.stats.models.Possession;

@Repository
public interface PossessionRepository extends JpaRepository<Possession, Integer> {

}
