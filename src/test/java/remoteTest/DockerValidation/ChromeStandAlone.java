package remoteTest.DockerValidation;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeStandAlone {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		//WebDriverManager.chromedriver().setup();
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		URL url = new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(url,cap);
		driver.get("http://google.com");
		System.out.println(driver.getTitle());

	}

}
