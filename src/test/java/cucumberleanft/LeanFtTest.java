package cucumberleanft;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import com.hp.lft.sdk.*;


import unittesting.*;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"com.hp.lft.report.CucumberReporter"},
                 features = "src/test/java/cucumberleanft")
public class LeanFtTest extends UnitTestClassBase {

    public LeanFtTest() {
        //Change this constructor to private if you supply your own public constructor
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        instance = new LeanFtTest();
        globalSetup(LeanFtTest.class);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        globalTearDown();
    }
    
    @Before
    public static void setUpBefore() throws Exception {

    }

    @After
    public static void tearDownAfter() throws Exception {

    }

    @Test
    public void test() throws GeneralLeanFtException {
    }
}