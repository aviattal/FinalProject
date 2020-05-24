package Utilities;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class commonOps extends base
{
     static File fxmlFile;
    public static String getData(String nodaName)
    {

        DocumentBuilderFactory dbFactory;
        DocumentBuilder dbBuilder;
        Document doc = null;
        try
        {
            fxmlFile = new File("./Configuration/DataConfig.xml");
            dbFactory = DocumentBuilderFactory.newInstance();
            dbBuilder = dbFactory.newDocumentBuilder();
            doc = dbBuilder.parse(fxmlFile);
            doc.getDocumentElement().normalize();
        }
        catch (Exception e)
        {
            System.out.println("Error Reading XML file: " + e);
        }
        finally
        {
            NodeList element = doc.getElementsByTagName(nodaName);
            return element.item(0).getTextContent().toString();
        }
    }

    public static void  initBrowser(String browserType)
    {
        if(browserType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if (browserType.equalsIgnoreCase("firefox"))
            driver = initFFDriver();
        else if(browserType.equalsIgnoreCase("ie"))
            driver = initIEDriver();
        else
            throw new RuntimeException(("Invalid platform name stated"));
        driver.manage().window().maximize();
        driver.get(getData("url"));
        String timeout = getData("TimeOut");
        Long parsedTimeout = Long.parseLong(timeout);
        driver.manage().timeouts().implicitlyWait(parsedTimeout, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver , Long.parseLong(getData("TimeOut")));
        action = new Actions(driver);
    }

    public static WebDriver initChromeDriver()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }
    public static WebDriver initFFDriver()
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }
    public static WebDriver initIEDriver()
    {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }

    public static void initMobile()
    {
        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("APP_PACKAGE"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("APP_ACTIVITY"));
        try
        {
            driver = new RemoteWebDriver(new URL("http://localhost:4723/wd/hub"), dc);
        }
        catch (Exception e)
        {
            System.out.println("Can not Connect to Appium Server, See Details" + e);
        }
        String timeout = getData("TimeOut");
        Long parsedTimeout = Long.parseLong(timeout);
        driver.manage().timeouts().implicitlyWait(parsedTimeout, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver , Long.parseLong(getData("TimeOut")));

    }

    public static void initAPI()
    {
        RestAssured.baseURI = getData("url_api");
        httpRequest = RestAssured.given().auth().preemptive().basic(getData("user"), getData("password"));
    }

    public static void initElectron()
    {
        System.setProperty("webdriver.chrome.driver","C:/Automation/FullStackfinalProject/electrondriver.exe" );
        //System.setProperty("webdriver.chrome.driver",getData("ElectronDriverPath"));
        ChromeOptions opt = new ChromeOptions();
        //String electronPath = getData("ElectronAppPath");
       // opt.setBinary(electronPath);
        opt.setBinary("C:/Automation/ElectronAPIDemos-win32-ia32/ElectronAPIDemos.exe");
        dc.setCapability("chromeOptions", opt);
    //    dc.setBrowserName("chrome");
        driver = new ChromeDriver(dc);
        String timeout = getData("TimeOut");
        Long parsedTimeout = Long.parseLong(timeout);
        driver.manage().timeouts().implicitlyWait(parsedTimeout, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver , Long.parseLong(getData("TimeOut")));
    }

    public static void initDesktop()
    {
        dc.setCapability("app" , getData("Calculator_App"));
        try
        {
            driver =  new WindowsDriver(new URL (getData("Appium_Server")), dc);

        }
        catch (Exception e)
        {
            System.out.println("Can not Connect to Appium Server, See details" + e ); e.printStackTrace();
        }
        String timeout = getData("TimeOut");
        Long parsedTimeout = Long.parseLong(timeout);
        driver.manage().timeouts().implicitlyWait(parsedTimeout, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver , Long.parseLong(getData("TimeOut")));
    }

    @BeforeClass

    public void startSession()
    {
       // if(PlatformName.equalsIgnoreCase("web"))
        String platform = getData("PlatformName");
        if (platform.equalsIgnoreCase("web")){
            initBrowser(getData("BrowserName"));
        }
        else if (getData("PlatformName").equalsIgnoreCase("mobile"))
          initMobile();
        else if (getData("PlatformName").equalsIgnoreCase("api"))
            initAPI();
        else if (getData("PlatformName").equalsIgnoreCase("electron"))
            initElectron();
        else if (getData("PlatformName").equalsIgnoreCase("desktop"))
            initDesktop();
        else
            throw new RuntimeException(("Invalid platform name stated"));
        managePages.init();
        //manageDB.initConnection(getData("dbURL"), getData("dbUser"),getData("dbPassword"));
        manageDB.initConnection("jdbc:mysql://10.100.102.1:3306/credentials.new_1" ,"root" , "123456");
    }

    @AfterMethod
    public void afterMethod()
    {
        if (getData("PlatformName").equalsIgnoreCase("web"))
        driver.get(getData("url"));
    }

    @AfterClass
    public void closeSession()
    {
        manageDB.closeConnection();
        if (!getData("PlatformName").equalsIgnoreCase("api"))
        driver.quit();

    }
}
