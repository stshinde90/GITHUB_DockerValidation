package remoteTest.DockerValidation;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeTest1 {

	
	@BeforeTest
	public void startDockerScale() throws IOException, InterruptedException
	{
		File fi = new File("output.txt");
		if(fi.delete())
		{
			System.out.println("File Deleted Successfully");
		}
		
		StartDocker st = new StartDocker();
		st.startBatFile();
		
	}
	
	@AfterTest
	public void StopDockerDelete() throws IOException, InterruptedException
	{
		StopDocker sp = new StopDocker();
		sp.stopBatFile();
	}

	@Test
	public void test1() throws MalformedURLException
	{
		// TODO Auto-generated method stub
		//WebDriverManager.chromedriver().setup();
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		URL url = new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(url,cap);
		driver.get("http://google.com");
		System.out.println(driver.getTitle());

	}

}
