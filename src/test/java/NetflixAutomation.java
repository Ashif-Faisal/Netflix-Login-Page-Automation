import javafx.scene.layout.Priority;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Listeners (ITestListener.class)

public class NetflixAutomation {
    public static WebDriver driver;
    static String BaseUrl = "https://www.netflix.com/bd/";


    @BeforeTest
    public static void WebSetup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","H:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get((BaseUrl));
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Thread.sleep(2000);
        Assert.assertTrue(driver.getTitle().contains("Netflix Bangladesh"));
    }


    @Test(priority = 0)
    public static void NetflixLoginPage() throws Exception {
        MyScreenRecorder.startRecording("");

        driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
        Thread.sleep(3000);

        //Blank Email or Phone number and Blank Password
        driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click(); //Blank Email or Phone number and Password
        Thread.sleep(2000);

        //Valid Email or Phone Number and Invalid Password
        driver.findElement(By.xpath("//label[contains(text(),'Email or phone number')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='id_userLoginId']")).sendKeys("ashif.faisal0@gmail.com");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//label[contains(text(),'Password')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='id_password']")).sendKeys("Netflix2345@");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
        Thread.sleep(3000);


        //Invalid Email or Phone Number and Valid Password
        driver.findElement(By.xpath("//label[contains(text(),'Email or phone number')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='id_userLoginId']")).clear();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='id_userLoginId']")).sendKeys("ashif.faisal01@gmail.com");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//label[contains(text(),'Password')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='id_password']")).clear();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='id_password']")).sendKeys("Netflix23@");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
        Thread.sleep(3000);


        //Invalid Email or Phone Number and Invalid Password
        driver.findElement(By.xpath("//label[contains(text(),'Email or phone number')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='id_userLoginId']")).clear();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='id_userLoginId']")).sendKeys("ashif.faisal01@gmail.com");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//label[contains(text(),'Password')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='id_password']")).clear();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='id_password']")).sendKeys("Netflix23456@");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
        Thread.sleep(3000);


        //Valid Email or Phone Number and Valid Password
        driver.findElement(By.xpath("//label[contains(text(),'Email or phone number')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='id_userLoginId']")).clear();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='id_userLoginId']")).sendKeys("ashif.faisal0@gmail.com");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//label[contains(text(),'Password')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='id_password']")).clear();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='id_password']")).sendKeys("Netflix23@");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.getTitle().contains("Netflix Bangladesh"));
        Thread.sleep(3000);

        MyScreenRecorder.stopRecording();
    }


    @AfterTest
    public static void TestCloser(){
        driver.quit();
    }
}
