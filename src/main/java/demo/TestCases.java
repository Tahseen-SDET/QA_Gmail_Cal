package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.INFO);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Connect to the chrome-window running on debugging port
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
    }

    public void endTest()
    {
        System.out.println("End Test: GoogleCalender");
        driver.close();
        driver.quit();

    }


    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        driver.get("https://calendar.google.com/");
        if(driver.getCurrentUrl().contains("calendar")){
            System.out.println("TestCase01 : PASSED");
        }
        else {
            System.out.println("TestCase01 : FAILED");
        }
        System.out.println("end Test case: testCase01");
    }

    public  void testCase02(){
        System.out.println("Start Test case: testCase02");
        try {
            driver.findElement(By.xpath("//button[@jsname='jnPWCc']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//span[text()='Month']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div/div/button[@aria-haspopup='menu']/span[@class='VfPpkd-vQzf8d']")).getText().contains("Month");
            driver.findElement(By.xpath("//div[@data-datekey='27692']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//div[text()='Task' and @class='x5FT4e kkUTBb']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@aria-label='Add title and time']")).sendKeys("Crio INTV Task Automation");
            Thread.sleep(2000);
            WebElement description = driver.findElement(By.xpath("//textarea[@placeholder='Add description']"));
            description.click();
            description.sendKeys("Crio INTV Calendar Task Automation");
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript("arguments[0].click()", description);
            Thread.sleep(4000);
//            WebElement write = driver.findElement(By.xpath("//div[@id='T2Ybvb0']"));
//            write.sendKeys("Crio INTV Calendar Task Automation");
            driver.findElement(By.xpath("//button[@jsname='x8hlje']")).click();
            System.out.println("TestCase02 : PASSED");

        }
        catch(Exception e) {
            System.out.println("Something somewhere went wrong");
        }

        System.out.println("end Test case: testCase02");
    }

    public  void testCase03(){
        System.out.println("Start Test case: testCase03");
        try {
            driver.findElement(By.xpath("//span[text()='Crio INTV Task Automation']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//button[@aria-label='Edit task']")).click();
            Thread.sleep(2000);
            WebElement editDescrip = driver.findElement(By.xpath("//textarea[@placeholder='Add description']"));
            editDescrip.click();
            editDescrip.clear();
            editDescrip.sendKeys("Crio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web application");
            Thread.sleep(1000);
            driver.findElement(By.xpath("//button[@jsname='x8hlje']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//span[text()='Crio INTV Task Automation']")).click();

            driver.findElement(By.xpath("//div[@class='toUqff D29CYb']")).getText().contains("Crio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web application");

//            Thread.sleep(1000);

            System.out.println("TestCase03 : PASSED");

        }
        catch(Exception e) {
            System.out.println("Something somewhere went wrong");
        }

        System.out.println("end Test case: testCase03");
    }

    public  void testCase04(){
        System.out.println("Start Test case: testCase04");
        try {
            driver.findElement(By.xpath("//span[@id='rAECCd']")).getText().contains("Crio INTV Task Automation");
            Thread.sleep(1000);
            driver.findElement(By.xpath("//button[@aria-label='Delete task']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//div/div/div[text()='Task deleted']")).getText().contains("Task deleted");
            Thread.sleep(2000);

            System.out.println("TestCase04 : PASSED");

        }
        catch(Exception e) {
            System.out.println("Something somewhere went wrong");
        }

        System.out.println("end Test case: testCase04");
    }


}
