package main.java.nba.stats.tools;

import java.util.HashMap;
import java.util.Map;

public class Util {

  public static Map<String, Object> getDefaultResponse() {
    Map<String, Object> response = new HashMap<>();
    response.put("error", null);
    response.put("data", null);
    return response;
  }
}
