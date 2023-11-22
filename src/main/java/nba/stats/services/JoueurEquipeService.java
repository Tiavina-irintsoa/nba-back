package nba.stats.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nba.stats.models.JoueurEquipe;
import nba.stats.repositories.JoueurEquipeRepository;

@Service
public class JoueurEquipeService {
    @Autowired
    private JoueurEquipeRepository JoueurEquipeRepository;

    public List<JoueurEquipe> list() {
        return JoueurEquipeRepository.findAll();
    }

    public JoueurEquipe insert(JoueurEquipe JoueurEquipe) {
        return JoueurEquipeRepository.save(JoueurEquipe);
    }

    public Optional<JoueurEquipe> findById(String id) {
        return JoueurEquipeRepository.findById(Integer.valueOf(id));
    }

    public void deleteById(String id) {
        JoueurEquipeRepository.deleteById(Integer.valueOf(id));
    }
}
