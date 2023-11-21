package nba.stats.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nba.stats.models.Points;
import nba.stats.repositories.PointsRepository;

@Service
public class PointsService {
    @Autowired
    private PointsRepository PointsRepository;

    public List<Points> list() {
        return PointsRepository.findAll();
    }

    public Points insert(Points Points) {
        return PointsRepository.save(Points);
    }

    public Optional<Points> findById(String id) {
        return PointsRepository.findById(Integer.valueOf(id));
    }

    public void deleteById(String id) {
        PointsRepository.deleteById(Integer.valueOf(id));
    }
}
