package nba.stats.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import nba.stats.models.PasseDecisive;
@Repository
public interface PasseDecisiveRepository extends JpaRepository<PasseDecisive, Integer>{
    
}
