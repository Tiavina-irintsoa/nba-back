package nba.stats;

import nba.stats.models.Possession;
import nba.stats.services.PossessionService;
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
@RequestMapping("/possessions")
public class PossessionController {
  @Autowired
  private PossessionService PossessionService;

  @GetMapping
  public ResponseEntity<Map<String, Object>> list() {
    Map<String, Object> response = Util.getDefaultResponse();
    try {
      response.put("data", PossessionService.list());
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
      Optional<Possession> Possession = PossessionService.findById(id);
      if (Possession.isPresent()) {
        response.put("data", Possession.get());
        return new ResponseEntity<>(response, HttpStatus.OK);
      }
      response.put("error", "Possession inexistant");
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    } catch (Exception e) {
      response.put("error", e.getMessage());
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping
  public ResponseEntity<Map<String, Object>> insert(
      @RequestBody Possession Possession) {
    Map<String, Object> response = Util.getDefaultResponse();
    try {
      Possession = Possession.copyAndControle(Possession);
      Possession inserted = PossessionService.insert(Possession);
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
      @RequestBody Possession Possession) {

    Map<String, Object> response = Util.getDefaultResponse();
    try {
      Possession = Possession.copyAndControle(Possession);
      Optional<Possession> to_update = PossessionService.findById(id);
      if (to_update.isPresent()) {
        Possession updated = new Possession();
        updated.update(Possession);
        response.put("data", PossessionService.insert(updated));
        return new ResponseEntity<>(response, HttpStatus.OK);
      }
      response.put("error", "Possession inexistant");
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
      PossessionService.deleteById(id);
      return new ResponseEntity<>(response, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
