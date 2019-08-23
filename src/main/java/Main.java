
import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main{


    public static ChromeDriver driverGogel;

    public static void main(String[] args){
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("test after build");
        System.out.println(System.getProperty("user.dir"));
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\chromedriver.exe");
        driverGogel = new ChromeDriver();
        driverGogel.get("http://www.mojohaus.org/exec-maven-plugin/");
        //driverGogel.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement objek_elemen = driverGogel.findElement(By.tagName("html"));

        List<WebElement> listElemen = driverGogel.findElementsByClassName("container-fluid");
        List<WebElement> list_gambar = driverGogel.findElements(By.tagName("img"));

        for(int z = 0;z<list_gambar.size();z++){
            if(list_gambar.get(z).getAttribute("href") != null){
                System.out.println("Tidak null NOHHHH "+ list_gambar.get(z).getAttribute("href"));
            } else {
                System.out.println("VALUE TEST NULLL");
            }
        }


//        for(int z=0;z<listElemen.size();z++){
//            System.out.println("DEBUGGG SETIAP ELEMEN ISI INNER HTML:::" + listElemen.get(z).getAttribute("innerHTML"));
//        }
        System.out.println(objek_elemen.getAttribute("innerHTML"));
        driverGogel.close();


    }


}
