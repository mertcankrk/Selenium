/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seleniumdemo;

import java.io.File;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Mert
 */
public class SeleniumDemo {

    protected static String ChromePath = "C:\\Users\\Mert\\Downloads\\chromedriver.exe";

    protected static ChromeDriverService service;

    protected static WebDriver driver;

    protected static WebDriverWait wait;

    public static void main(String[] args) throws InterruptedException {

        Setup();

        driver.get("https://www.trendyol.com/");
        driver.manage().window().maximize();

        Thread.sleep(2000);

        AnaSayfa AnaSayfa = new AnaSayfa(
                "div.fancybox-skin>:nth-child(2)",
                "span.vn-close",
                "div.icon-container>:nth-child(1)",
                "div.email>:nth-child(2)",
                "div.password>:nth-child(3)",
                "div.submit-button-container>a",
                "div.icon-container>:nth-child(1)",
                "search-box",
                "div.search-box-container>:nth-child(2)",
                "bilgisayar"
        );

        AramaSonuc AramaSonuc = new AramaSonuc(
                "div.prdct-cntnr-wrppr>:nth-child(",
                ")>:nth-child(1)",
                "div.pr-cn-in>:nth-child(1)>:nth-child(1)>:nth-child(1)>:nth-child(3)>:nth-child(1)>:nth-child(1)>:nth-child(2)",
                "div.pr-cn-in>:nth-child(1)>:nth-child(1)>:nth-child(1)>:nth-child(3)>:nth-child(1)>:nth-child(1)>:nth-child(1)",
                "div.add-to-bs-tx",
                "div.user-navigation-container>:nth-child(1)>:nth-child(3)>:nth-child(1)"
        );

        Sepet Sepet = new Sepet(
                "div.pb-basket-item-actions>:nth-child(2)",
                "div.pb-basket-item-actions>:nth-child(1)>:nth-child(1)>:nth-child(3)",
                "div.pb-basket-item-actions>:nth-child(1)>:nth-child(1)>:nth-child(2)",
                "i.i-trash",
                "div.left>:nth-child(2)>:nth-child(1)",
                "div.emptyBasketInfoBox>:nth-child(1)>:nth-child(1)>:nth-child(1)"
                
        );

        AnaSayfa.CloseCookies();
        AnaSayfa.ClickGirişYap();
        AnaSayfa.BilgileriGir();

        if (AnaSayfa.GirisKontrol() == 1) {
            System.out.println("Giriş Başarıyla Yapıldı");
        } else {
            System.out.println("Giriş Yapılamadı");
        }

        AnaSayfa.Arama();
        AramaSonuc.UrunSec(AramaSonuc.RastgeleIntUret(24));

        float fiyat = AramaSonuc.FiyatCek();

        int tampon = AramaSonuc.SepeteEkle();

        if (tampon == 1) {

            AramaSonuc.SepeteYonel();
            float fiyat2 = Sepet.FiyatCek();
            
            if(fiyat==fiyat2){
                System.out.println("Fiyatlar eşit");
            }else{
                System.out.println("Fiyatlar eşit değil");
            }

            Sepet.AdetArttır();
            int adet = Sepet.AdetKontrol();
            
            if(adet == 2){
                System.out.println("2. ürün başarıyla eklenmiştir");
            }else{
                System.out.println("2. ürün eklenememiştir.");
            }
                
            Sepet.UrunSil();
                    
            
            if(Sepet.SepetKontrol()==true){
                 System.out.println("Sepet Başarıyla Boşaltılmıştır.");
            }else{
                 System.out.println("Sepet Boşaltılamamıştır");
            }
    
        } else {
            System.out.println("Sepete Eklenememiştir");
        }


    }

    public static void Setup() { 
        service = new ChromeDriverService.Builder().
                usingDriverExecutable(new File(ChromePath)).
                usingAnyFreePort().
                build();
        try {
            service.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.setProperty("webdriver.chrome.driver", ChromePath);
        driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
        wait = new WebDriverWait(driver, 15);

    }

    public static void Stop() {
        driver.quit();
        service.stop();
    }

}
