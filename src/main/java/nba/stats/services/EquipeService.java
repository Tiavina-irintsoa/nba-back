package nba.stats.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nba.stats.models.Equipe;
import nba.stats.repositories.EquipeRepository;

@Service
public class EquipeService {
    @Autowired
    private EquipeRepository equipeRepository;

    public List<Equipe> list(){
        return equipeRepository.findAll();
    }
    public Equipe insert(Equipe equipe){
        return equipeRepository.save(equipe);
    }
    public Optional<Equipe> findById(String id){
        return equipeRepository.findById(Integer.valueOf(id));
    }
    public void deleteById(String id){
        equipeRepository.deleteById(Integer.valueOf(id));
    }
}
