package nba.stats;

import nba.stats.models.Rebond;
import nba.stats.services.RebondService;
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
@RequestMapping("/Rebonds")
public class RebondController {
  @Autowired
  private RebondService RebondService;

  @GetMapping
  public ResponseEntity<Map<String, Object>> list() {
    Map<String, Object> response = Util.getDefaultResponse();
    try {
      response.put("data", RebondService.list());
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
      Optional<Rebond> Rebond = RebondService.findById(id);
      if (Rebond.isPresent()) {
        response.put("data", Rebond.get());
        return new ResponseEntity<>(response, HttpStatus.OK);
      }
      response.put("error", "Rebond inexistant");
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    } catch (Exception e) {
      response.put("error", e.getMessage());
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping
  public ResponseEntity<Map<String, Object>> insert(
      @RequestBody Rebond Rebond) {
    Map<String, Object> response = Util.getDefaultResponse();
    try {
      Rebond = Rebond.copyAndControle(Rebond);
      Rebond inserted = RebondService.insert(Rebond);
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
      @RequestBody Rebond Rebond) {

    Map<String, Object> response = Util.getDefaultResponse();
    try {
      Rebond = Rebond.copyAndControle(Rebond);
      Optional<Rebond> to_update = RebondService.findById(id);
      if (to_update.isPresent()) {
        Rebond updated = new Rebond();
        updated.update(Rebond);
        response.put("data", RebondService.insert(updated));
        return new ResponseEntity<>(response, HttpStatus.OK);
      }
      response.put("error", "Rebond inexistante");
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
      RebondService.deleteById(id);
      return new ResponseEntity<>(response, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
