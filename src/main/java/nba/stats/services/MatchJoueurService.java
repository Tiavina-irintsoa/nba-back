package nba.stats.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nba.stats.models.MatchJoueur;
import nba.stats.repositories.MatchJoueurRepository;

@Service
public class MatchJoueurService {
    @Autowired
    private MatchJoueurRepository MatchJoueurRepository;

    public List<MatchJoueur> list(){
        return MatchJoueurRepository.findAll();
    }
    public MatchJoueur insert(MatchJoueur MatchJoueur){
        return MatchJoueurRepository.save(MatchJoueur);
    }
    public Optional<MatchJoueur> findById(String id){
        return MatchJoueurRepository.findById(Integer.valueOf(id));
    }
    public void deleteById(String id){
        MatchJoueurRepository.deleteById(Integer.valueOf(id));
    }
}
