package nba.stats.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nba.stats.models.JoeurEquipeEquipe;
import nba.stats.repositories.JoeurEquipeEquipeRepository;

@Service
public class JoeurEquipeEquipeService {
    @Autowired
    private JoeurEquipeEquipeRepository JoeurEquipeequipeRepository;

    public List<JoeurEquipeEquipe> list() {
        return JoeurEquipeequipeRepository.findAll();
    }

    public JoeurEquipeEquipe insert(JoeurEquipeEquipe JoeurEquipeequipe) {
        return JoeurEquipeequipeRepository.save(JoeurEquipeequipe);
    }

    public Optional<JoeurEquipeEquipe> findById(String id) {
        return JoeurEquipeequipeRepository.findById(Integer.valueOf(id));
    }

    public void deleteById(String id) {
        JoeurEquipeequipeRepository.deleteById(Integer.valueOf(id));
    }
}
