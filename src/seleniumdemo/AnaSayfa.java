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
public class AnaSayfa {

    String cookies1;
    String cookies2;
    String girisYap;
    String epostaKonum;
    String sifreKonum;
    String butonGirisKonum;
    String girisKontrol;
    String eposta = "mtanserkarakus@gmail.com";
    String sifre = "Deneme123";
    String aramaKutusu;
    String aramaIkonu;
    String aranacakKelime;

    AnaSayfa() {

    }

    AnaSayfa(String str1, String str2, String str3, String str4, String str5, String str6, String str7,String str8,String str9,String str10) {
        cookies1 = str1;
        cookies2 = str2;
        girisYap = str3;
        epostaKonum = str4;
        sifreKonum = str5;
        butonGirisKonum = str6;
        girisKontrol = str7;
        aramaKutusu = str8;
        aramaIkonu = str9;
        aranacakKelime = str10;
                
    }

    public void CloseCookies() throws InterruptedException {
        WebElement we1 = driver.findElement(By.cssSelector(cookies1));
        we1.click();
        Thread.sleep(2000);
        WebElement we2 = driver.findElement(By.cssSelector(cookies2));
        we2.click();
        Thread.sleep(2000);
    }

    public void ClickGirişYap() throws InterruptedException {
        driver.findElement(By.cssSelector(girisYap)).click();
        Thread.sleep(2000);
    }

    public void BilgileriGir() throws InterruptedException {
        WebElement email = driver.findElement(By.cssSelector(epostaKonum));
        email.sendKeys(eposta);

        Thread.sleep(2000);

        WebElement pass = driver.findElement(By.cssSelector(sifreKonum));
        pass.sendKeys(sifre);

        Thread.sleep(2000);

        driver.findElement(By.cssSelector(butonGirisKonum)).click();

        Thread.sleep(4000);
    }

    public int GirisKontrol() throws InterruptedException {
        WebElement Element = driver.findElement(By.cssSelector(girisKontrol));

        if (Element.getAttribute("href").equals("https://www.trendyol.com/Hesabim/#/Siparislerim")) {
            return 1;
        } else {
            return 0;
        }

    }
    
    public void Arama() throws InterruptedException{
        
        
        WebElement search = driver.findElement(By.className(aramaKutusu));
        search.sendKeys(aranacakKelime);

        Thread.sleep(500);
        driver.findElement(By.cssSelector(aramaIkonu)).click();

        Thread.sleep(2000);
        
    }

}
