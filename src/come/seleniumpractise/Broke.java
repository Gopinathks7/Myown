package come.seleniumpractise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Broke 
{
	WebDriver driver; int invalidcount=0;
	@Test
	public  void  getInvalidLinks()
	{
		String key="webdriver.chrome.driver";
		String value="E:\\BrowserDrivers\\chromedriver.exe";
		System.setProperty(key,value);
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.ndtv.com");
List<WebElement> linka = driver.findElements(By.tagName("a"));
int count=linka.size();
System.out.println("The number is ==>"+count+"  ");
for(WebElement link:linka)
{
	if (link != null) 
	{
	String url = link.getAttribute("href");
	System.out.println("The url pressent is "+url);
	
		if (url != null && !url.contains("javascript"))
		{
			verifyURLStatus(url);
		}
		else 
		{
			invalidcount++;
		}
	}
}

	}
@Test
public void verifyURLStatus(String URL) {

	HttpClient client = HttpClientBuilder.create().build();
	HttpGet request = new HttpGet(URL);
	try {
		HttpResponse response = client.execute(request);
		// verifying response code and The HttpStatus should be 200 if not,
		// increment invalid link count
		////We can also check for 404 status code like response.getStatusLine().getStatusCode() == 404
		if (response.getStatusLine().getStatusCode() != 200)
			invalidcount++;
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}
}

}
				

