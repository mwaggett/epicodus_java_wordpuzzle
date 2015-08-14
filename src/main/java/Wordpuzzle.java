import java.util.Random;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;
import java.lang.*;
import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import java.util.Map;

public class Wordpuzzle {

  public static void main(String[] args) {

    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap model = new HashMap();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/puzzle", (request, response) -> {
      HashMap model = new HashMap();
      model.put("template", "templates/puzzle.vtl");

      String input = request.queryParams("input");
      model.put("input", input);

      String[] inputArray = splitStringByChar(input);
      String[] puzzleArray = replaceVowels(inputArray);
      String puzzle = convertArraytoReadableString(puzzleArray);
      model.put("puzzle", puzzle);

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }

  public static String[] splitStringByChar(String sentence) {
    String[] charArray = sentence.split("");
    return charArray;
    // I'm still trying to figure out what processes should be separate methods
    // and what should be grouped together. For example, this method is doing a
    // separate process, but I also see no point in separating it because I'm
    // literally just calling the split() method.
  }

  public static String[] replaceVowels(String[] charArray) {
    Integer count = 0;
    for (String character : charArray) {
      if (character.equals("a") || character.equals("e") || character.equals("i")
          || character.equals("o") || character.equals("u") || character.equals("A")
          || character.equals("E") || character.equals("I") || character.equals("O")
          || character.equals("U")) {
        charArray[count] = "-";
      }
      count += 1;
    }
    return charArray;
  }

  public static String convertArraytoReadableString(String[] charArray) {
    StringBuilder puzzleBuild = new StringBuilder();
    for (Integer i = 0; i < charArray.length; i++) {
      puzzleBuild.append(charArray[i]);
    }
    String puzzle = puzzleBuild.toString();
    System.out.println(puzzle);
    return puzzle;
  }

}
