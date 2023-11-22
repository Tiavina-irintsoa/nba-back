package nba.stats.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import nba.stats.models.FicheJoueur;
@Repository
public interface FicheJoueurRepository extends JpaRepository<FicheJoueur, Integer>{
    @Query(value="select s from v_statistiques s")
    List<FicheJoueur> getStats();

    @Query(value="select s from v_statistiques s where s.equipe.idEquipe= :idequipe")
    List<FicheJoueur> getStatsByIdEquipe(@Param("idequipe") int  idequipe);

    
}