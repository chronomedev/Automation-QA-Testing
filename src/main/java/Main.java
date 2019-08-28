/*Automation QA Engineering sample to test a
web application using Selenium library build using maven
Copyright ChronomeDev 2019 */

//import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

//import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
//import java.util.concurrent.TimeUnit; //buat set time out

public class Main{

    // Publik Instance
    public static ChromeDriver driverGogel;
    public static String laman_web = "https://itemku.com/login";
    //public static String laman_web = "https://community.idntimes.com/login";


    public static void ChronomeSplash(){
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("  _____ _                                          _____             \n" +
                " / ____| |                                        |  __ \\            \n" +
                "| |    | |__  _ __ ___  _ __   ___  _ __ ___   ___| |  | | _____   __\n" +
                "| |    | '_ \\| '__/ _ \\| '_ \\ / _ \\| '_ ` _ \\ / _ \\ |  | |/ _ \\ \\ / /\n" +
                "| |____| | | | | | (_) | | | | (_) | | | | | |  __/ |__| |  __/\\ V / \n" +
                " \\_____|_| |_|_|  \\___/|_| |_|\\___/|_| |_| |_|\\___|_____/ \\___| \\_/  ");
    }
    //controller function according test case
    public static void loginTest(String variabel_name, String variabel_name2, String param1, String param2){
        submit_test test2 = new submit_test(driverGogel);

        List<WebElement> listField = test2.ambilField();
        test2.customFieldFill(listField, variabel_name, param1);
        test2.customFieldFill(listField, variabel_name2, param2);//password disini
        //System.out.println("tidak error1");
        test2.sendForm(test2.ambilForm(), 0, true);

    }


    public static void signUpTest(){

    }


/*
    haaa belom tau lagi dah sesuai test case nanti
    TODO?TODO?
*/

//////////////////////////////////////////////////////////////////////////
    //Fungsi Main / Main Function
    public static void main(String[] args){
        ChronomeSplash();
        System.out.println("test after build");

        try{

            System.out.println(System.getProperty("user.dir"));
            //Sesuaikan dengan browser mau yang dipake yang mana setiap engine browser itu berbeda
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\chromedriver.exe");
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ "\\geckodriver.exe");
            FirefoxDriver firefoz = new FirefoxDriver();
            firefoz.get(laman_web);
            driverGogel = new ChromeDriver();
            driverGogel.get(laman_web);
            Thread.sleep(5000);
            loginTest("email", "password_login", "hatachishanzer@gmail.com", "royale007");
            Thread.sleep(5000);

        } catch (Exception e){
            System.out.println("ERROR WAZWUZWUZ:::::");
            e.printStackTrace();
        }

        //driverGogel.quit();
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");

    }
}
