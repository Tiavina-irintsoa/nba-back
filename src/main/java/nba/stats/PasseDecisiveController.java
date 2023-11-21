package nba.stats;

import nba.stats.models.PasseDecisive;
import nba.stats.services.PasseDecisiveService;
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
@RequestMapping("/passeDecisives")
public class PasseDecisiveController {
    @Autowired
    private PasseDecisiveService passeDecisiveService;
    
  @GetMapping
  public ResponseEntity<Map<String, Object>> list() {
    Map<String, Object> response = Util.getDefaultResponse();
    try {
      response.put("data", passeDecisiveService.list());
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
      Optional<PasseDecisive> passeDecisive = passeDecisiveService.findById(id);
      if (passeDecisive.isPresent()) {
        response.put("data", passeDecisive.get());
        return new ResponseEntity<>(response, HttpStatus.OK);
      }
      response.put("error", "PasseDecisive inexistant");
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    } catch (Exception e) {
      response.put("error", e.getMessage());
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping
  public ResponseEntity<Map<String, Object>> insert(
    @RequestBody PasseDecisive passeDecisive
  ) {
    Map<String, Object> response = Util.getDefaultResponse();
    try {
        passeDecisive = PasseDecisive.copyAndControle(passeDecisive);
      PasseDecisive inserted = passeDecisiveService.insert(passeDecisive);
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
    @RequestBody PasseDecisive passeDecisive
  ) {

    Map<String, Object> response = Util.getDefaultResponse();
    try {
        passeDecisive = PasseDecisive.copyAndControle(passeDecisive);
      Optional<PasseDecisive> to_update = passeDecisiveService.findById(id);
      if (to_update.isPresent()) {
        PasseDecisive updated = new PasseDecisive();
        updated.update(passeDecisive);
        response.put("data", passeDecisiveService.insert(updated));
        return new ResponseEntity<>(response, HttpStatus.OK);
      }
      response.put("error", "Passe Decisive inexistante");
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
      passeDecisiveService.deleteById(id);
      return new ResponseEntity<>(response,HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
