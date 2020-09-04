/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seleniumdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static seleniumdemo.SeleniumDemo.driver;

/**
 *
 * @author Mert
 */
public class Sepet {

    String fiyatKonum;
    String arttırKonum;
    String mevcutKonum;
    String ikonKonum;
    String silKonum;
    String sepetKonum;

    public Sepet(String str1, String str2, String str3, String str4, String str5, String str6) {
        fiyatKonum = str1;
        arttırKonum = str2;
        mevcutKonum = str3;
        ikonKonum = str4;
        silKonum = str5;
        sepetKonum = str6;

    }

    public float FiyatCek() {

        WebElement Element = driver.findElement(By.cssSelector(fiyatKonum));

        String str = null;
        str = Element.getAttribute("innerHTML");
        // System.out.println("str2 ilk sefer = "+str2);
        try {
            int tampon2 = str.indexOf("</span>");
            if (tampon2 != -1) {
                str = str.substring(tampon2 + 7, str.length());
            }

        } catch (Exception e) {

        }

        if (str.indexOf(".") == 1) {
            str = str.replace(".", "");
        }
        try {
            str = str.replace(",", ".");
        } catch (Exception e) {
            // System.out.println("catche düştü2");
        }

        str = str.replace("TL", "");
        //System.out.println("str2 = "+str2); 

        float fiyat = Float.parseFloat(str);
        return fiyat;

    }

    public void AdetArttır() throws InterruptedException {
        Thread.sleep(2000);

        driver.findElement(By.cssSelector(arttırKonum)).click();
        
             Thread.sleep(2000);

    }

    public int AdetKontrol() {
        WebElement Element3 = driver.findElement(By.cssSelector(mevcutKonum));
        int value = Integer.valueOf(Element3.getAttribute("value"));
        if (value == 2) {
            return 2;
        } else {
            return 1;
        }
    }

    public void UrunSil() throws InterruptedException {
        Thread.sleep(2000);

        driver.findElement(By.cssSelector(ikonKonum)).click();

        Thread.sleep(2000);

        WebElement cookies3 = driver.findElement(By.cssSelector(silKonum));

        cookies3.click();

        Thread.sleep(2000);
    }

    public boolean SepetKontrol() {

        WebElement Element = driver.findElement(By.cssSelector(sepetKonum));
        //System.out.println(Element4.getAttribute("innerHTML"));

        String kontrol = Element.getAttribute("innerHTML");

        if (kontrol.equals("Sepetinizde ürün bulunmamaktadır.")) {
           
            return true;
        } else {
           
            return false;
        }

        
    }

}
