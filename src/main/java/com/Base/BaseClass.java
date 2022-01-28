package com.Base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import com.utilities.ReadConfig;

public class BaseClass {

	ReadConfig rc = new ReadConfig();

	public String baseURL = rc.getApplication();
	public String username = rc.getUserName();
	public String password = rc.getPassword();
	public static WebDriver driver;

	public static Logger Log = Logger.getLogger(BaseClass.class);

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {

		String logfile = System.getProperty("user.dir")+"/src/main/resources/log4j.properties";
		PropertyConfigurator.configure(logfile);

		Log.info("reading Browser name from properties file");

		if(br.equals("chrome")) {
			Log.info("Chrome browser is Launching");
			System.setProperty("webdriver.chrome.driver",rc.getChromePath());
			driver = new ChromeDriver();		
		}
		
		else if(br.equals("firefox")) {
			Log.info("firefox browser is Launching");
			System.setProperty("webdriver.gecko.driver",rc.getFirePath());
			driver = new FirefoxDriver();		
		}
		else if(br.equals("edge")) {
			Log.info("MS-Edge browser is Launching");
			System.setProperty("webdriver.edge.driver",rc.getEdgePath());
			driver = new EdgeDriver();		
		}

		Log.info("Maximazing browser window");
		driver.manage().window().maximize();
		Log.info("applying waits on driver instance");
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

		Log.info("launching an application");
		driver.get(baseURL);
	}

	public void captureScreen(WebDriver driver,String tname)throws Exception{

		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source,target);
		Log.info("Screenshot taken");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}

