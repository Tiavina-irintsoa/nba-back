package nba.stats.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nba.stats.models.Match;
import nba.stats.repositories.MatchRepository;

@Service
public class MatchService {
    @Autowired
    private MatchRepository MatchRepository;

    public List<Match> list(){
        return MatchRepository.findAll();
    }
    public Match insert(Match Match){
        return MatchRepository.save(Match);
    }
    public Optional<Match> findById(String id){
        return MatchRepository.findById(Integer.valueOf(id));
    }
    public void deleteById(String id){
        MatchRepository.deleteById(Integer.valueOf(id));
    }
}
