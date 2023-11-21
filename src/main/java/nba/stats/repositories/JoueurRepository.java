package main.java.nba.stats.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import main.java.nba.stats.models.Joueur;
@Repository
public interface JoueurRepository extends JpaRepository<Joueur, Integer>{
    
}
