package nba.stats.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import nba.stats.models.Rebond;

@Repository
public interface RebondRepository extends JpaRepository<Rebond, Integer> {

}
