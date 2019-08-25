/*Automation QA Engineering sample to test a
web application using Selenium library build using maven
Copyright ChronomeDev 2019 */

//import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

//import java.util.ArrayList;
import java.util.List;
//import java.util.concurrent.TimeUnit; //buat set time out

public class Main{

    // Publik Instance
    public static ChromeDriver driverGogel;


    public static void ChronomeSplash(){
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("  _____ _                                          _____             \n" +
                " / ____| |                                        |  __ \\            \n" +
                "| |    | |__  _ __ ___  _ __   ___  _ __ ___   ___| |  | | _____   __\n" +
                "| |    | '_ \\| '__/ _ \\| '_ \\ / _ \\| '_ ` _ \\ / _ \\ |  | |/ _ \\ \\ / /\n" +
                "| |____| | | | | | (_) | | | | (_) | | | | | |  __/ |__| |  __/\\ V / \n" +
                " \\_____|_| |_|_|  \\___/|_| |_|\\___/|_| |_| |_|\\___|_____/ \\___| \\_/  ");
    }

    //Fungsi Main / Main Function
    public static void main(String[] args){
        ChronomeSplash();
        System.out.println("test after build");

        try{

            System.out.println(System.getProperty("user.dir"));
            //Sesuaikan dengan browser mau yang dipake yang mana setiap engine browser itu berbeda
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\chromedriver.exe");
            driverGogel = new ChromeDriver();
            driverGogel.get("https://www.facebook.com/");

            List<WebElement> field_input = driverGogel.findElements(By.tagName("input"));

            for(int z = 0;z<field_input.size();z++){
                if(field_input.get(z).getAttribute("data-testid") !="" && field_input.get(z).getAttribute("data-testid")!=null){
                    if(field_input.get(z).getAttribute("data-testid").equals("royal_email")){
                        field_input.get(z).sendKeys("");
                    } else if(field_input.get(z).getAttribute("data-testid").equals("royal_pass")){
                        field_input.get(z).sendKeys("");
                    }
                }
            }

            driverGogel.findElement(By.id("login_form")).submit();
            System.out.println(driverGogel.findElement(By.tagName("html")).getAttribute("innerHTML"));
            //driverGogel.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            //driverGogel.close();

        } catch (Exception e){
            System.out.println("ERROR WAZWUZWUZ");
            System.out.println(e);
        }
        driverGogel.quit();
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");

    }
}
