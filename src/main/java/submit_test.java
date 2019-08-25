//Submit operation class
// @2019 ChronomeDev


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class submit_test extends input_test {


    public submit_test(ChromeDriver driverGogel) {
        super(driverGogel);
    }

    public void clickForm(){

    }

    public List<WebElement> ambilForm(){
        return driverGogel.findElements(By.tagName("form"));
    }

    //ambi sendform
    public void sendForm(List<WebElement> list_form, int index_form){
        //System.out.println("WOI::::");
        list_form.get(index_form).submit();
    }


}
