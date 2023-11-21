package nba.stats;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nba.stats.services.FicheJoueurService;
import nba.stats.tools.Util;


@RequestMapping("/stats")
@RestController
public class FicheJoueurController {
    @Autowired
    private FicheJoueurService service;

     @GetMapping
    public ResponseEntity<Map<String, Object>> getStats() {
        Map<String, Object> response = Util.getDefaultResponse();
        try {
        response.put("data", service.getStats());
        return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
        response.put("error", e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{idequipe}")
    public ResponseEntity<Map<String, Object>> getStatsByIdEquipe( @PathVariable("idequipe") String idequipe) {
        Map<String, Object> response = Util.getDefaultResponse();
            try {
            response.put("data", service.getStatsByIdEquipe(idequipe));
            return new ResponseEntity<>(response, HttpStatus.OK);
            } catch (Exception e) {
            response.put("error", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
