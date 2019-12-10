//Submit operation class
// @2019 ChronomeDev
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/*Kelas di usahakan seoptimal mungkin dapat sering dipakai methodnya
baik website default atau pun website lain
tapi diutamakan disesuaikan untuk idn times terlebih dahulu*/

public class input_test {

    public ChromeDriver driverGogel;

    public input_test(ChromeDriver driverGogel){
        this.driverGogel = driverGogel;
    }
    public List<WebElement> ambilField(){
        return driverGogel.findElements(By.tagName("input"));
    }

    //general biasanya ada namenya sih biasanya
    public void customFieldFill(List<WebElement> elemen, String name_identifier, String isi_masukan_field){
        for(int z = 0;z<elemen.size();z++){
            if(elemen.get(z).getAttribute("name").equals(name_identifier)){
                elemen.get(z).sendKeys(isi_masukan_field);
                break;
            }
        }
    }





}
