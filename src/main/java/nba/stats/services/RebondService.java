package nba.stats.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nba.stats.models.Rebond;
import nba.stats.repositories.RebondRepository;

@Service
public class RebondService {
    @Autowired
    private RebondRepository RebondRepository;

    public List<Rebond> list() {
        return RebondRepository.findAll();
    }

    public Rebond insert(Rebond Rebond) {
        return RebondRepository.save(Rebond);
    }

    public Optional<Rebond> findById(String id) {
        return RebondRepository.findById(Integer.valueOf(id));
    }

    public void deleteById(String id) {
        RebondRepository.deleteById(Integer.valueOf(id));
    }
}
