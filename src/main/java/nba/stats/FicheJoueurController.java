package nba.stats;

import java.util.Map;

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
            response.put("data", service.getStatsByIdEquipe());
            return new ResponseEntity<>(response, HttpStatus.OK);
            } catch (Exception e) {
            response.put("error", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
