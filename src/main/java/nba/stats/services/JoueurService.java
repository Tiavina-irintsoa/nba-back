package nba.stats.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nba.stats.models.Joueur;
import nba.stats.repositories.JoueurRepository;

@Service
public class JoueurService {
    @Autowired
    private JoueurRepository joueurRepository;

    public List<Joueur> list(){
        return joueurRepository.findAll();
    }
    public Joueur insert(Joueur joueur){
        return joueurRepository.save(joueur);
    }
    public Optional<Joueur> findById(String id){
        return joueurRepository.findById(Integer.valueOf(id));
    }
    public void deleteById(String id){
        joueurRepository.deleteById(Integer.valueOf(id));
    }
}
