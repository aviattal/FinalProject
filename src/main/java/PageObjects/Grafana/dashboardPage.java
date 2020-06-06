package PageObjects.Grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class dashboardPage
{
    @FindBy(how = How.XPATH, using ="//*[@id=\"panel-1\"]/div/div/div[2]/div[1]/div[2]/a")
    public WebElement btn_chooseVisual;

    @FindBy(how = How.XPATH, using ="//*[@id=\"panel-1\"]/div/div/div[2]/div[1]/div[1]/a")
    public WebElement btn_addQuery;
}
