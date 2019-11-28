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
import org.openqa.selenium.support.ui.ExpectedConditions;
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
    public static String laman_web_default = "https://www.idntimes.com/";
    public static String laman_web = "https://community.idntimes.com/login";
    public static String laman_dashboard = "https://community.idntimes.com/dashboard";


    public static String username_test = "destianputra@gmail.com";
    public static String password_test = "testingimplementasi";
    public static String email_name_field = "email";
    public static String password_name_field = "password";


    public static void ChronomeSplash() {
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("  _____ _                                          _____             \n" +
                " / ____| |                                        |  __ \\            \n" +
                "| |    | |__  _ __ ___  _ __   ___  _ __ ___   ___| |  | | _____   __\n" +
                "| |    | '_ \\| '__/ _ \\| '_ \\ / _ \\| '_ ` _ \\ / _ \\ |  | |/ _ \\ \\ / /\n" +
                "| |____| | | | | | (_) | | | | (_) | | | | | |  __/ |__| |  __/\\ V / \n" +
                " \\_____|_| |_|_|  \\___/|_| |_|\\___/|_| |_| |_|\\___|_____/ \\___| \\_/  ");
    }

    public static void fungsiJsKlik(WebElement elemenWeb) {
        JavascriptExecutor eksekusi = (JavascriptExecutor) driverGogel;
        eksekusi.executeScript("arguments[0].click();", elemenWeb);
    }

    public static void fungsiJsEntryDataElemen(WebElement elemen, String data_masukan) {
        JavascriptExecutor eksekusi = (JavascriptExecutor) driverGogel;
        eksekusi.executeScript("arguments[0].innerHTML ='" + data_masukan + "';", elemen);
    }

    public static void fungsiJs(String source_code) {
        JavascriptExecutor eksekusi = (JavascriptExecutor) driverGogel;
        eksekusi.executeScript(source_code);
    }

    public static boolean tungguLoad(){
        return ((JavascriptExecutor) driverGogel).executeScript("return document.readyState").equals("complete");
    }

    //controller function according test case
    public static void loginTest() {
        driverGogel.get(laman_web);
        submit_test test2 = new submit_test(driverGogel);

        List<WebElement> listField = test2.ambilField();
        System.out.println(listField);
        test2.customFieldFill(listField, email_name_field, username_test);
        test2.customFieldFill(listField, password_name_field, password_test); //password disini
        //System.out.println("tidak error1");
        test2.sendForm(test2.ambilForm(), 0, true);

    }

    public static void logoutTest() {
        List<WebElement> listElemen = driverGogel.findElements(By.cssSelector("a[class='header-icon icon-grey dropdown-toggle']"));
        List<WebElement> menu_user = listElemen.get(1).findElements(By.tagName("li"));
        fungsiJsKlik(listElemen.get(0));
        List<WebElement> tagLink = driverGogel.findElements(By.tagName("a"));
        for (int z = 0; z < tagLink.size(); z++) {
            if (tagLink.get(z).getAttribute("href").equals("https://community.idntimes.com/logout")) {
                tagLink.get(z).click();
                break;
            }
        }
    }


    public static void editorTest(String testCase, String saveAs) {
        loginTest();
        //jalan tes normal

        while (((JavascriptExecutor) driverGogel).executeScript("return document.readyState").equals("complete") != true) {
            System.out.println("belom bos" + ((JavascriptExecutor) driverGogel).executeScript("return document.readyState").equals("complete"));
        }
        List<WebElement> listElemen = driverGogel.findElements(By.tagName("a"));
        System.out.println(listElemen.size());
        for (int z = 0; z < listElemen.size(); z++) {

            if (listElemen.get(z).getAttribute("href").equals("https://community.idntimes.com/dashboard/create-article")) {
                listElemen.get(z).getAttribute("href");
                System.out.println("MASUK WOI NIH ADA HREFNYA COK");
                listElemen.get(z).click();
                break;
            }
        }

        // jalanin test case edit normal

            while (tungguLoad() !=  true) {
                System.out.println("belom bos");
            }
            WebElement judul = driverGogel.findElementByCssSelector("h1[class='app__single-line___2cW5W']");
            fungsiJsEntryDataElemen(judul, "Artikel testing draft");

            WebElement field_execrpt = driverGogel.findElementByCssSelector("p[placeholder='Tulis excerpt di sini...']");
            fungsiJsEntryDataElemen(field_execrpt, "disini abstrak draft");

            String jsScript = "z = document.getElementsByTagName(\"iframe\");\n" +
                    "wew = null;\n" +
                    "for(i = 0;i<z.length;i++){\n" +
                    "    if(z[i].getAttribute(\"title\") == \"Rich Text Area. Press ALT-F9 for menu. Press ALT-F10 for toolbar. Press ALT-0 for help\"){\n" +
                    "        console.log(z[i]);\n" +
                    "        wew = z[i];\n" +
                    "        console.log(i);\n" +
                    "        break;\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "var iframe = document.getElementsByName(\"login_page\")[0];\n" +
                    "var elemensub = wew.contentDocument || wew.contentWindow.document;\n" +
                    "\n" +
                    "subdok = elemensub.getElementsByTagName(\"p\");\n" +
                    "subdok[0].value = \"Testing disini blablablabablbalbalbalbalbalba Agung Agung IDN TIMES\";";
            fungsiJs(jsScript);

        //basis test case mau embed apa standar
        if (testCase.equals("embed")) {
            jsScript = "tombol_embed = document.getElementsByClassName(\"app__btn-action___2JQU-\");\n" +
                    "tombol_embed[7].click();\n" +
                    "tombol_embed[8].click();\n" +
                    "tombol_embed[9].click();\n" +
                    "\n" +
                    "field = document.getElementsByClassName(\"app__input-link___1daUZ\");\n" +
                    "field[0].value = \"https://www.facebook.com/gakusahalaydifacbookgwcoy\";\n" +
                    "field[1].value = \"https://www.instagram.com/\";\n" +
                    "field[2].value = \"https://twitter.com\";";
            fungsiJs(jsScript);
        }
        List<WebElement> tombol = driverGogel.findElements(By.tagName("button"));
        if(saveAs.equals("draft"))

        { // buat jalanin test case draft article aja draft

            for (int z = 0; z < tombol.size(); z++) {
                if (tombol.get(z).getAttribute("title").equals("Save as draft")) {
                    tombol.get(z).click();
                    break;
                }
            }
        } else {
        // buat jalanin test case save article editorial
        for (int z = 0; z < tombol.size(); z++) {
            if (tombol.get(z).getAttribute("title").equals("Submit to Editorial")) {
                tombol.get(z).click();
                break;
            }
        }
    }

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
        driverGogel.get(laman_web_default);
        while (tungguLoad() !=  true) {
            System.out.println("belom bos");
        }

        List<WebElement> listelemen = driverGogel.findElementsByCssSelector("a[class='dropdown-button dropdown-icon-corner'");
        listelemen.get(0).click();

        List<WebElement> list_menu_berita = driverGogel.findElements(By.className("submenu-box"));
        List<WebElement> list_berita = list_menu_berita.get(0).findElements(By.tagName("a"));
        // contoh fuzzy random pilih jawa tengah beritanya
        list_berita.get(3).click();
        ////////masuk halaman berita regional
        while (tungguLoad() !=  true) {
            System.out.println("belom bos");
        }
        String jsScript = "sectionTrending = document.getElementById(\"trending\");\n" +
                "subTreding = document.getElementsByClassName(\"slick-track\");\n" +
                "link = subTreding[0].document.getElementsByTagName(\"a\");\n" +
                "link[0].click();";
        fungsiJs(jsScript);



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
            ///////////////TEST CASE OPS//////////////////////////////////
            //disini sesuaikan ingin melakukan testing apa
            //loginTest();
            //editorTest("embed","draft");
            regionalNewsTest();
            //Thread.sleep(4000);
            //logoutTest();
            //Thread.sleep(4000);

        } catch (Exception e){
            System.out.println("ERROR WAZWUZWUZ:::::");
            e.printStackTrace();
        }

        //driverGogel.quit();
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");

    }
}
