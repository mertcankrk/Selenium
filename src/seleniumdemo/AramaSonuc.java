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
public class AramaSonuc {

    String Secilecekyer1;
    String Secilecekyer2;
    int r;
    String str = null;
    String fiyatKonum1;
    String fiyatKonum2;
    String sepeteEkle;
    String sepeteYonel;

    public AramaSonuc() {

    }

    AramaSonuc(String str1, String str2, String str3, String str4, String str5, String str6) {
        Secilecekyer1 = str1;
        Secilecekyer2 = str2;
        fiyatKonum1 = str3;
        fiyatKonum2 = str4;
        sepeteEkle = str5;
        sepeteYonel = str6;
    }

    public void UrunSec(int sayi) {
        String tampon = Secilecekyer1 + sayi + Secilecekyer2;
        driver.findElement(By.cssSelector(tampon)).click();
    }

    public int RastgeleIntUret(int limit) {
        r = (int) (Math.random() * limit);
        return r;
    }

    public float FiyatCek() throws InterruptedException {

        Thread.sleep(2000);

        try {
            WebElement Element1 = driver.findElement(By.cssSelector("div.pr-cn-in>:nth-child(1)>:nth-child(1)>:nth-child(1)>:nth-child(3)>:nth-child(1)>:nth-child(1)>:nth-child(2)"));
            //System.out.println(Element1.getAttribute("innerHTML"));
            str = Element1.getAttribute("innerHTML");
        } catch (Exception e) {
            //System.out.println("catche düştü ");
            WebElement Element1 = driver.findElement(By.cssSelector("div.pr-cn-in>:nth-child(1)>:nth-child(1)>:nth-child(1)>:nth-child(3)>:nth-child(1)>:nth-child(1)>:nth-child(1)"));
            // System.out.println(Element1.getAttribute("innerHTML"));
            str = Element1.getAttribute("innerHTML");
        }

        if (str.indexOf(".") == 1) {
            str = str.replace(".", "");
        }
        try {
            str = str.replace(",", ".");
        } catch (Exception e) {
            // System.out.println("catche düştü");
        }

        str = str.substring(0, str.length() - 2);

        //System.out.println(str);
        float fiyat = Float.parseFloat(str);

        //System.out.println("fiyat = "+fiyat);
        Thread.sleep(2000);

        return fiyat;

    }

    public int SepeteEkle() throws InterruptedException {

        try {
            driver.findElement(By.cssSelector(sepeteEkle)).click();
            Thread.sleep(2000);
            return 1;
        } catch (Exception e) {
            
            return 0;
        }

    }

    public void SepeteYonel() throws InterruptedException {
        driver.findElement(By.cssSelector(sepeteYonel)).click();

        Thread.sleep(2000);
    }

}
