package nba.stats;

import nba.stats.models.Points;
import nba.stats.services.PointsService;
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
@RequestMapping("/Points")
public class PointsController {
  @Autowired
  private PointsService PointsService;

  @GetMapping
  public ResponseEntity<Map<String, Object>> list() {
    Map<String, Object> response = Util.getDefaultResponse();
    try {
      response.put("data", PointsService.list());
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
      Optional<Points> Points = PointsService.findById(id);
      if (Points.isPresent()) {
        response.put("data", Points.get());
        return new ResponseEntity<>(response, HttpStatus.OK);
      }
      response.put("error", "Points inexistant");
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    } catch (Exception e) {
      response.put("error", e.getMessage());
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping
  public ResponseEntity<Map<String, Object>> insert(
      @RequestBody Points Points) {
    Map<String, Object> response = Util.getDefaultResponse();
    try {
      Points = Points.copyAndControle(Points);
      Points inserted = PointsService.insert(Points);
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
      @RequestBody Points Points) {

    Map<String, Object> response = Util.getDefaultResponse();
    try {
      Points = Points.copyAndControle(Points);
      Optional<Points> to_update = PointsService.findById(id);
      if (to_update.isPresent()) {
        Points updated = new Points();
        updated.update(Points);
        response.put("data", PointsService.insert(updated));
        return new ResponseEntity<>(response, HttpStatus.OK);
      }
      response.put("error", "Points inexistante");
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
      PointsService.deleteById(id);
      return new ResponseEntity<>(response, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
