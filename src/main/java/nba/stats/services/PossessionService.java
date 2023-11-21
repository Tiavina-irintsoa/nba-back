package nba.stats.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nba.stats.models.Possession;
import nba.stats.repositories.PossessionRepository;

@Service
public class PossessionService {
    @Autowired
    private PossessionRepository PossessionRepository;

    public List<Possession> list() {
        return PossessionRepository.findAll();
    }

    public Possession insert(Possession Possession) {
        return PossessionRepository.save(Possession);
    }

    public Optional<Possession> findById(String id) {
        return PossessionRepository.findById(Integer.valueOf(id));
    }

    public void deleteById(String id) {
        PossessionRepository.deleteById(Integer.valueOf(id));
    }
}
