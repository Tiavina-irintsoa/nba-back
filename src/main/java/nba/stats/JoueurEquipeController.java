package nba.stats;

import nba.stats.models.JoueurEquipe;
import nba.stats.services.JoueurEquipeService;
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
@RequestMapping("/joueurequipes")
public class JoueurEquipeController {
  @Autowired
  private JoueurEquipeService JoueurequipeService;

  @GetMapping
  public ResponseEntity<Map<String, Object>> list() {
    Map<String, Object> response = Util.getDefaultResponse();
    try {
      response.put("data", JoueurequipeService.list());
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
      Optional<JoueurEquipe> Joueurequipe = JoueurequipeService.findById(id);
      if (Joueurequipe.isPresent()) {
        response.put("data", Joueurequipe.get());
        return new ResponseEntity<>(response, HttpStatus.OK);
      }
      response.put("error", "JoueurEquipe inexistant");
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    } catch (Exception e) {
      response.put("error", e.getMessage());
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping
  public ResponseEntity<Map<String, Object>> insert(
      @RequestBody JoueurEquipe Joueurequipe) {
    Map<String, Object> response = Util.getDefaultResponse();
    try {
      Joueurequipe = JoueurEquipe.copyAndControle(Joueurequipe);
      JoueurEquipe inserted = JoueurequipeService.insert(Joueurequipe);
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
      @RequestBody JoueurEquipe Joueurequipe) {

    Map<String, Object> response = Util.getDefaultResponse();
    try {
      Joueurequipe = JoueurEquipe.copyAndControle(Joueurequipe);
      Optional<JoueurEquipe> to_update = JoueurequipeService.findById(id);
      if (to_update.isPresent()) {
        JoueurEquipe updated = new JoueurEquipe();
        updated.update(Joueurequipe);
        response.put("data", JoueurequipeService.insert(updated));
        return new ResponseEntity<>(response, HttpStatus.OK);
      }
      response.put("error", "JoueurEquipe inexistante");
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
      JoueurequipeService.deleteById(id);
      return new ResponseEntity<>(response, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
