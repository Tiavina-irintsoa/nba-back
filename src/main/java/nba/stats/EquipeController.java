package nba.stats;

import nba.stats.models.Equipe;
import nba.stats.services.EquipeService;
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
@RequestMapping("/equipes")
public class EquipeController {
    @Autowired
    private EquipeService equipeService;
    
  @GetMapping
  public ResponseEntity<Map<String, Object>> list() {
    Map<String, Object> response = Util.getDefaultResponse();
    try {
      response.put("data", equipeService.list());
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
    @PathVariable("id") String id
  ) {
    Map<String, Object> response = Util.getDefaultResponse();
    try {
      Optional<Equipe> equipe = equipeService.findById(id);
      if (equipe.isPresent()) {
        response.put("data", equipe.get());
        return new ResponseEntity<>(response, HttpStatus.OK);
      }
      response.put("error", "Equipe inexistant");
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    } catch (Exception e) {
      response.put("error", e.getMessage());
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping
  public ResponseEntity<Map<String, Object>> insert(
    @RequestBody Equipe equipe
  ) {
    Map<String, Object> response = Util.getDefaultResponse();
    try {
        equipe = Equipe.copyAndControle(equipe);
      Equipe inserted = equipeService.insert(equipe);
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
    @RequestBody Equipe equipe
  ) {

    Map<String, Object> response = Util.getDefaultResponse();
    try {
        equipe = Equipe.copyAndControle(equipe);
      Optional<Equipe> to_update = equipeService.findById(id);
      if (to_update.isPresent()) {
        Equipe updated = new Equipe();
        updated.update(equipe);
        response.put("data", equipeService.insert(updated));
        return new ResponseEntity<>(response, HttpStatus.OK);
      }
      response.put("error", "Equipe inexistante");
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    } catch (Exception e) {
      response.put("error", e.getMessage());
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Map<String,Object>> deleteById(@PathVariable("id") String id) {
    Map<String, Object> response = Util.getDefaultResponse();
    try {
      equipeService.deleteById(id);
      return new ResponseEntity<>(response,HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
