/*Automation QA Engineering sample to test a
web application using Selenium library build using maven
Copyright ChronomeDev 2019 */

//import com.gargoylesoftware.htmlunit.BrowserVersion;
//import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import java.util.ArrayList;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
//import java.util.concurrent.TimeUnit; //buat set time out

public class Main {

    // Publik Instance
    public static ChromeDriver driverGogel;
    //public static String laman_web = "https://itemku.com/login";
    public static String laman_web = "https://community.idntimes.com/login";
    public static String laman_dashboard = "https://community.idntimes.com/dashboard";


    public static void ChronomeSplash() {
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("  _____ _                                          _____             \n" +
                " / ____| |                                        |  __ \\            \n" +
                "| |    | |__  _ __ ___  _ __   ___  _ __ ___   ___| |  | | _____   __\n" +
                "| |    | '_ \\| '__/ _ \\| '_ \\ / _ \\| '_ ` _ \\ / _ \\ |  | |/ _ \\ \\ / /\n" +
                "| |____| | | | | | (_) | | | | (_) | | | | | |  __/ |__| |  __/\\ V / \n" +
                " \\_____|_| |_|_|  \\___/|_| |_|\\___/|_| |_| |_|\\___|_____/ \\___| \\_/  ");
    }

    public static void fungsiJs(WebElement elemenWeb){
        JavascriptExecutor eksekusi = (JavascriptExecutor)driverGogel;
        eksekusi.executeScript("arguments[0].click();", elemenWeb);
    }
    //controller function according test case
    public static void loginTest(String variabel_name, String variabel_name2, String param1, String param2) {
        driverGogel.get(laman_web);
        submit_test test2 = new submit_test(driverGogel);

        List<WebElement> listField = test2.ambilField();
        System.out.println(listField);
        test2.customFieldFill(listField, variabel_name, param1);
        test2.customFieldFill(listField, variabel_name2, param2); //password disini
        //System.out.println("tidak error1");
        test2.sendForm(test2.ambilForm(), 0, true);

    }

    public static void logoutTest() {
        //driverGogel.get(laman_dashboard);
        //List<WebElement> listElemen = driverGogel.findElements(By.cssSelector("ul[class='primary-submenu pull-right']"));
        List<WebElement> listElemen = driverGogel.findElements(By.cssSelector("a[class='header-icon icon-grey dropdown-toggle']"));

        JavascriptExecutor jsjalan = (JavascriptExecutor)driverGogel;
        //listElemen.get(1).click();
        List<WebElement> menu_user = listElemen.get(1).findElements(By.tagName("li"));
        fungsiJs(listElemen.get(0));
        List<WebElement> tagLink = driverGogel.findElements(By.tagName("a"));
        for(int z= 0 ;z<tagLink.size();z++){
            if(tagLink.get(z).getAttribute("href").equals("https://community.idntimes.com/logout")){
                tagLink.get(z).click();
                break;
            }
        }
    }





    public static void editorTest(){

    }
    public static void promoArticleTest(){

    }

    public static void pendingArticleTest(){

    }

    public static void publishedArticleTest(){

    }

    public static void rejectedArticleTest(){

    }

    public static void userSettingsTest(){

    }

    public static void newsTest(){

    }

    public static void regionalNewsTest(){

    }

    public static void hypeArticleTest(){

    }

    public static void quizTest(){

    }

    public static void communityArticleTest(){

    }

    public static void searchBoxTest(){

    }

    public static void useInfoTest(){

    }




/*
    haaa belom tau lagi dah sesuai test case nanti

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
            //buat maximize
            ChromeOptions opsiArgumen = new ChromeOptions();
            opsiArgumen.addArguments("--start-maximized");
            driverGogel = new ChromeDriver(opsiArgumen);

            loginTest("email", "password", "destianputra@gmail.com", "testingimplementasi");
            Thread.sleep(4000);
            logoutTest();
            //Thread.sleep(4000);

        } catch (Exception e){
            System.out.println("ERROR WAZWUZWUZ:::::");
            e.printStackTrace();
        }

        //driverGogel.quit();
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");

    }
}
