package nba.stats.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.java.nba.stats.models.Equipe;
import nba.stats.models.FicheJoueur;
@Repository
public interface FicheJoueurRepository extends JpaRepository<FicheJoueur, Integer>{
    @Query(value="select * from v_statistiques")
    List<FicheJoueur> getStats();

    @Query(value="select s from v_statistiques where s.equipe.idequipe= :idequipe")
    List<FicheJoueur> getStatsByIdEquipe(@Param("idequipe") String  idequipe);

    
}