import java.util.Random;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;
import static spark.Spark.*;
import spark.ModelAndView;
// import spark.template.velocity.VelocityTemplateEngine;
import java.util.Map;

public class Wordpuzzle {

  public static void main(String[] args) {
    /*
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap model = new HashMap();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/newPage", (request, response) -> {
      HashMap model = new HashMap();
      model.put("template", "templates/newPage.vtl");

      <Class> param = request.queryParams("param");
      model.put("param", param);
      <Class> result = someMethod(param);
      model.put("result", result);

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
    */
  }

  public static String[] splitStringByChar (String sentence) {
    String[] charArray = sentence.split("");
    return charArray;
    // I'm still trying to figure out what processes should be separate methods
    // and what should be grouped together. For example, this method is doing a
    // separate process, but I also see no point in separating it because I'm
    // literally just calling the split() method.
  }

}
