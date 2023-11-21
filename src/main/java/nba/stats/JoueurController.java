package nba.stats;

import nba.stats.models.Joueur;
import nba.stats.services.JoueurService;
import nba.stats.tools.Util;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/joueurs")
public class JoueurController {
  @Autowired
  private JoueurService joueurService;

  @GetMapping
  public ResponseEntity<Map<String, Object>> list() {
    Map<String, Object> response = Util.getDefaultResponse();
    try {
      response.put("data", joueurService.list());
      return new ResponseEntity<>(response, HttpStatus.OK);
    } catch (Exception e) {
      response.put("error", e.getMessage());
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/hello")
  public String hello() {
    return "Hello";
  }

  @GetMapping("/{id}")
  public ResponseEntity<Map<String, Object>> findById(
      @PathVariable("id") String id) {
    Map<String, Object> response = Util.getDefaultResponse();
    try {
      Optional<Joueur> joueur = joueurService.findById(id);
      if (joueur.isPresent()) {
        response.put("data", joueur.get());
        return new ResponseEntity<>(response, HttpStatus.OK);
      }
      response.put("error", "Joueur inexistant");
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    } catch (Exception e) {
      response.put("error", e.getMessage());
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping
  public ResponseEntity<Map<String, Object>> insert(
      @RequestBody Joueur joueur) {
    Map<String, Object> response = Util.getDefaultResponse();
    try {
      joueur = Joueur.copyAndControle(joueur);
      Joueur inserted = joueurService.insert(joueur);
      response.put("data", inserted);

      return new ResponseEntity<>(response, HttpStatus.CREATED);
    } catch (Exception e) {
      response.put("error", e.getMessage());
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<Map<String, Object>> update(
      @PathVariable("id") String id,
      @RequestBody Joueur joueur) {

    Map<String, Object> response = Util.getDefaultResponse();
    try {
      joueur = Joueur.copyAndControle(joueur);
      Optional<Joueur> to_update = joueurService.findById(id);
      if (to_update.isPresent()) {
        Joueur updated = new Joueur();
        updated.update(joueur);
        response.put("data", joueurService.insert(updated));
        return new ResponseEntity<>(response, HttpStatus.OK);
      }
      response.put("error", "Joueur inexistant");
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    } catch (Exception e) {
      response.put("error", e.getMessage());
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Map<String, Object>> deleteById(@PathVariable("id") String id) {
    Map<String, Object> response = Util.getDefaultResponse();
    try {
      joueurService.deleteById(id);
      return new ResponseEntity<>(response, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
