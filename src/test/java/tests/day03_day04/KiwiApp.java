package tests.day03_day04;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KiwiPage;
import utils.Driver;
import utils.ReusableMethods;

public class KiwiApp {
    AndroidDriver<AndroidElement> driver= Driver.getAndroidDriver();
    TouchAction action=new TouchAction<>(driver);
    KiwiPage kiwiPage=new KiwiPage();


    /*
    @BeforeTest
    public void setUp() throws MalformedURLException {
      DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        capabilities.setCapability("appPackage", "com.skypicker.main");//Hangi uygulama uzerinde calismak istiyorsak,
        // Apk infodan uyguluma bilgisine ulasabiliriz
        capabilities.setCapability("appActivity", "com.kiwi.android.feature.splash.impl.ui.SplashActivity");
        // Kullanacak oldugumuz uygulamayi belirledikten sonra, o uygulamada hangi sayfadan baslamak istiyorsak
        // onun degerini activities kisminda bularak appActivity degiskenin karsisina parametre olarak giriyoruz
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        // Eger ki bir uygulamada uygulamanin onbellegini her testten sonra sifirlamak istiyor NoRESET FALSE olmalidir !!!!!!!!
        /* Eger ki bir uygulamada uygulamanin onbellegini sifirlamadan gectigimiz adimlarin kaydedilerek 0 dan uygulamanin baslamasini istemiyorsak
         NO_RESET Truee olmalidir !!!!!!!!!


        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }     bu bolume gerek kalmadi cunku driver clasi olusturuldu ..
     */




    @Test
    public void kiwiAppTest() throws InterruptedException {

            // uygulamanin yuklendigi dogrulanir
            Assert.assertTrue(driver.isAppInstalled("com.skypicker.main"));
            // uygulamanin basariyla acildigi dogrulanir

            Assert.assertTrue(kiwiPage.misafirOlarakDevamEt.isDisplayed());
            // misafir olarak devam et e tiklanir
            kiwiPage.misafirOlarakDevamEt.click();
            // ardinda gelecek olan 3 adimada yesil butona basilarak devam edilir
            Thread.sleep(1000);
            kiwiPage.ilkSayfaGecisleri();
            // Trip type,one way olarak secilir
            ReusableMethods.koordinatTiklama(303,624,1000);
            ReusableMethods.koordinatTiklama(535,1444,1000);


            // kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
            ReusableMethods.koordinatTiklama(526,774,1000);
            ReusableMethods.koordinatTiklama(1013,138,1000);
            // kalkis yapilacak ulke/sehir girilir ve sec e tiklanir

            if (driver.isKeyboardShown()){
                driver.getKeyboard().pressKey("istanbul");
            }
            else {
                kiwiPage.fromTextBox.sendKeys("Ankara");
            }
            Thread.sleep(750);
            ReusableMethods.koordinatTiklama(465,288,1000);
            kiwiPage.chooseButton.click();

            // varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
            ReusableMethods.koordinatTiklama(465,912,1000);
            if (driver.isKeyboardShown()){
                driver.getKeyboard().pressKey("nice");
            }
            else {
                kiwiPage.fromTextBox.sendKeys("stockholm");
            }
            Thread.sleep(750);
            ReusableMethods.koordinatTiklama(465,288,1000);
            kiwiPage.chooseButton.click();

            // gidis tarihi eylul ayinin 21 i olarak secilir ve set date e tiklanir
            ReusableMethods.koordinatTiklama(465,1052,1000);
            // 471 ,1371 480,187
            ReusableMethods.screenScroll(471,1371,850,471,187);
            ReusableMethods.screenScrollDown(1000);
            ReusableMethods.koordinatTiklama(685,805,1000);
            // search butonuna tiklanir
            kiwiPage.setDateButton.click();
            Thread.sleep(500);
            kiwiPage.aramaButonu.click();

            // en  ucuz ve aktarmasiz filtrelemeleri yapilir
            ReusableMethods.koordinatTiklama(254,257,500);
            ReusableMethods.koordinatTiklama(502,578,500);
            ReusableMethods.koordinatTiklama(523,257,500);
            ReusableMethods.koordinatTiklama(514,1456,500);
            // gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir
            String fiyatSon= kiwiPage.fiyatSonucu.getText();
            driver.sendSMS("55555555555","Kiwi.com uygulamasindan gelen son fiyat= "+fiyatSon);


        }

    }
