package nba.stats.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import nba.stats.models.Equipe;
@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Integer>{
    
}
