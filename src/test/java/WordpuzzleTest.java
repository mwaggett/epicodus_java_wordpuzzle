import org.fluentlenium.adapter.FluentTest;
import static org.junit.Assert.*;
import org.junit.*;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class WordpuzzleTest extends FluentTest {

  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void splitStringByChar_containsSeparatedChars_true() {
    Wordpuzzle wp = new Wordpuzzle();
    String expValue = "S";
    assertEquals(expValue, wp.splitStringByChar("Short sentence.")[0]);
  }

  @Test
  public void splitStringByChar_okayWithNonLetters_true() {
    Wordpuzzle wp = new Wordpuzzle();
    String expValue = " ";
    assertEquals(expValue, wp.splitStringByChar("Short sentence.")[5]);
  }

  @Test
  public void replaceVowels_vowelBecomesDash_true() {
    Wordpuzzle wp = new Wordpuzzle();
    String expValue = "-";
    String[] charArray = wp.splitStringByChar("Cat dog.");
    assertEquals(expValue, wp.replaceVowels(charArray)[1]);
  }

  @Test
  public void replaceVowels_nonvowelDoesntChange_true() {
    Wordpuzzle wp = new Wordpuzzle();
    String expValue = ".";
    String[] charArray = wp.splitStringByChar("Cat dog.");
    assertEquals(expValue, wp.replaceVowels(charArray)[7]);
  }

  @Test
  public void convertArraytoReadableString_arrayBecomesString_true() {
    Wordpuzzle wp = new Wordpuzzle();
    String expValue = "Short sentence.";
    String[] charArray = wp.splitStringByChar("Short sentence.");
    assertEquals(expValue, wp.convertArraytoReadableString(charArray));
  }

  /*

  ~~INTEGRATION TESTING~~
  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Something");
  }

  @Test
  public void newPage_desiredResult() {
    goTo("starting_page_url");
    fill("#input_id").with("input");
    submit(".btn");
    assertThat(pageSource()).contains("Some result of input");
  }
  */

}
