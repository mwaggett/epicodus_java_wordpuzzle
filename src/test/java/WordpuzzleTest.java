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

  /*
  ~~UNIT TESTING~~
  @Test
  public void methodName_whatIsBeingTested_desiredResult() {
    App a = new App();
    <Class> expValue = x;
    assertEquals(expValue, a.methodName(param));
  }

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
