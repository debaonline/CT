package scenarios;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import spec.SpecDefinition;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BaseScenario {

    // Use the application driver
    WebDriver driver;
    PageStore pageStore;

    SpecDefinition user ;



    @BeforeMethod
    public void setup(){
        // initialize driver
        pageStore = new PageStore();
        user = new SpecDefinition(pageStore);

        //launch the application under test
        driver = pageStore.getDriver();
        driver.get("http://www.cleartrip.com/");

        given(user).choosesToDoAFlightSearch();
    }

    @AfterMethod
    public void teardown(){
        //close the browser
        pageStore.destroy();

    }


    public String tomorrow(){
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 1);
        return new SimpleDateFormat("dd/MM/yyyy").format(c.getTime());
    }

    public String dayAfterTomorrow(){
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 2);
        return new SimpleDateFormat("dd/MM/yyyy").format(c.getTime());
    }


    protected <T extends SpecDefinition> T given(T dsl) {
        return dsl;
    }

    protected <T extends SpecDefinition> T when(T dsl) {
        return dsl;
    }

    protected <T extends SpecDefinition> T then(T dsl) {
        return dsl;
    }

    protected <T extends SpecDefinition> T and(T dsl) {
        return dsl;
    }
}
