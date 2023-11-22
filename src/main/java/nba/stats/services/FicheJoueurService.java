package nba.stats.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nba.stats.models.FicheJoueur;
import nba.stats.repositories.FicheJoueurRepository;

@Service
public class FicheJoueurService {
    @Autowired
    private FicheJoueurRepository ficheJoueurRepository;

    public List<FicheJoueur> getStats(){
        List<FicheJoueur> fiches = ficheJoueurRepository.getStats();
        return fiches;
    }
    public List<FicheJoueur> getStatsByIdEquipe(String idequipe){
        List<FicheJoueur> fiches = ficheJoueurRepository.getStatsByIdEquipe(Integer.valueOf(idequipe));
        return fiches;
    }
}