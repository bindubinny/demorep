
package pp1;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Goibibo_test {

	public static void main(String[] args) throws InterruptedException {
		
		//To disable chrome notifications
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.makemytrip.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		driver.manage().window().maximize();
		//click on from city
		driver.findElement(By.id("fromCity")).click();
		//wait for loading the dropdown
		WebDriverWait wait=new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[text()='Bangalore, India']"))));
			
		//select city from dropdown and click
		driver.findElement(By.xpath("//*[text()='Bangalore, India']")).click();
		
		driver.findElement(By.id("toCity")).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[text()='Pune, India']"))));
		driver.findElement(By.xpath("//*[text()='Pune, India']")).click();
			
		//Now the month is April. if you want to select another month you have to click on next arrow and the arrow 
		//is on rightmost of the page. horizontal scroll down is used for that purpose
		while(!driver.findElement(By.className("DayPicker-Month")).getText().contains("May"))
							
			{
			//horizontal scroll
				((JavascriptExecutor)driver).executeScript("window.scrollBy(2000,0)");
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();

		
			}
			//select the day from the list
		List<WebElement>list1=driver.findElements(By.className("DayPicker-Day"));
		int size1=list1.size();
			
		for(int i=0;i<size1;i++)
			{
			
			if(list1.get(i).getText().equals("29"))
				{
							
				list1.get(i).click();
					
				break;

	
			}
			    }
		
		driver.findElement(By.xpath("//span[text()='RETURN']")).click();
			
			
	
	
		while(!driver.findElement(By.className("DayPicker-Month")).getText().contains("June"))
				
			{
			((JavascriptExecutor)driver).executeScript("window.scrollBy(2000,0)");
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
			List<WebElement>list2=driver.findElements(By.className("DayPicker-Day"));
			int size2=list2.size();
			
			for(int i=0;i<size2;i++)
			{
				if(list2.get(i).getText().equals("5"))
				{
					list2.get(i).click();
					
					break;

		         }
			}
			//select travellers. All the travallers(adults, children infants and travel class )are in same class
			driver.findElement(By.xpath("//span[text()='Travellers & CLASS']")).click();
		
			//all rows
			List<WebElement>list3=driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div[1]/div[5]/div[1]/div/ul"));
			
			//total number of rows
			int size3=list3.size();
			
			for(int i=1;i<=size3;i++)
			{
				//all columns in a prticular row
				List<WebElement>list4=driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div[1]/div[5]/div[1]/div/ul["+i+"]/li"));
				
				for(int j=1;j<list4.size();j++)
				{
					
					
			WebElement s=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div[1]/div[5]/div[1]/div/ul["+i+"]/li["+j+"]"));
	        String m=s.getText();
	
	switch(i)
	{
	case 1:
	
		if(j==3)
		{
		s.click();
		break;}
	
	case 2:
	
		if(j==3)
		{
		s.click();
		break;}
	
	case 3:
	
		if(j==2)
		{
		s.click();
		break;}
	
	case 4:
		if(j==2)
		{
		s.click();
		break;}
	}
	
				}}
		
			//click on apply button
			driver.findElement(By.xpath("//button[text()='APPLY']")).click();
			//click on search button
				
			driver.findElement(By.xpath("//a[text()='Search']")).click();	
			
	}}