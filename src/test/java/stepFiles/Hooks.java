package stepFiles;

import driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	

    @Before
    public void setUp()
    {
    	System.out.println("Launching the driver");
        Driver.initDriver();  // Initializes WebDriver using your logic
    }

    @After
    public void tearDown()
    {
    	System.out.println("Quiting Driver");
        Driver.quitDriver();  // Cleans up WebDriver after each scenario
    }

}
