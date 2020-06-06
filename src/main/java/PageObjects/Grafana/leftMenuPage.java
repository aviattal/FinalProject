package PageObjects.Grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class leftMenuPage
{
    @FindBy(how = How.XPATH, using ="//div[@class='sidemenu-item dropdown'][6]")
    public WebElement btn_ServerAdmin;

    @FindBy(how = How.XPATH, using ="/html/body/grafana-app/sidemenu/div[2]/div[1]/a")
    public WebElement btn_plus;

    @FindBy(how = How.CSS, using = "img[src='/avatar/46d229b033af06a191ff2267bca9ae56']")
    public WebElement img_Avatar;
}
