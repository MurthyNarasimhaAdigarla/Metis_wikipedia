package steps.com;

import Meties.utils.com.Utility;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;


public class Meties_Steps extends Utility {

    @Given("^I want to Open Metis wikipedia page$")
    public void i_want_to_Open_Metis_wikipedia_page() {
        openingBrowser();

    }

    @Given("^I validate headings of content box in Metis wikipedia page$")
    public void i_validate_headings_of_content_box_in_Metis_wikipedia_page() {
        // driver.findElement(By.partialLinkText("Family")).click();
        // in progress

    }

    @When("^I validate hyperlinks in content box in Metis wikipedia page$")
    public void i_validate_hyperlinks_in_content_box_in_Metis_wikipedia_page() {
        validatehyperlinksincontentboxinMetiswikipediapage();

    }

    @When("^I {2}validate pop up$")
    public void i_validate_pop_up() throws Throwable {
        ivalidate_popup();
    }

    @When("^I see family tree on clicking NIKE option$")
    public void i_see_family_tree_on_clicking_NIKE_option() {
        iseefamilytreeonclicking_NIKEoption();

    }
}