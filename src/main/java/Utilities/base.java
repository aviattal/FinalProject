package Utilities;

import PageObjects.Grafana.dashboardPage;
import PageObjects.Grafana.folderPage;
import io.restassured.path.json.JsonPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class base
{
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions action;
    public static Screenshot imageScreenShot;
    public static ImageDiffer imgDiff = new ImageDiffer();
    public static ImageDiff diff;
    public static String Platform;

    public static DesiredCapabilities dc = new DesiredCapabilities();

    public static PageObjects.Grafana.loginPage grafanaLogin;
    public static PageObjects.Grafana.mainPage grafanaMain;
    public static PageObjects.Grafana.leftMenuPage grafanaLeftMenu;
    public static PageObjects.Grafana.serverAdminMenuPage grafanaServerAdminMenuPage;
    public static PageObjects.Grafana.serverAdminMainPage grafanaServerAdminMainPage;
    public static PageObjects.Grafana.userListPage grafanaUserListPage;
    public static PageObjects.Grafana.plusMenuPage grafanaPlusMenuPage;
    public static PageObjects.Grafana.folderPage grafanaFolderPage;
    public static dashboardPage grafanaDashboardPage;

    public static PageObjects.Mortgage.mainPage mortgaeMain;
    public static PageObjects.ElectronDemo.mainPage electronMain;
    public static PageObjects.Calculator.mainPage calcMain;

    public static RequestSpecification httpRequest;
    public static Response response;
    public static JSONObject requestParams = new JSONObject();
    public static JsonPath jp;

    public static Connection con;
    public static Statement stmt;
    public static ResultSet rs;



}
