package nba.stats.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nba.stats.models.PasseDecisive;
import nba.stats.repositories.PasseDecisiveRepository;

@Service
public class PasseDecisiveService {
    @Autowired
    private PasseDecisiveRepository equipeRepository;

    public List<PasseDecisive> list(){
        return equipeRepository.findAll();
    }
    public PasseDecisive insert(PasseDecisive equipe){
        return equipeRepository.save(equipe);
    }
    public Optional<PasseDecisive> findById(String id){
        return equipeRepository.findById(Integer.valueOf(id));
    }
    public void deleteById(String id){
        equipeRepository.deleteById(Integer.valueOf(id));
    }
}
