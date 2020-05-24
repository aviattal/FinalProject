package PageObjects.ElectronDemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class mainPage
{
    /*@FindBy(how = How.ID, using ="button-windows")
    public WebElement btn_windows;*/

    @FindBy(how = How.ID, using ="button-app-sys-information")
    public WebElement btn_info;

    @FindBy(how = How.ID, using ="screen-info-demo-toggle")
    public WebElement btn_demo_toggle;

    @FindBy(how = How.ID, using ="app-version-demo-toggle")
    public WebElement btn_version_toggle;

    @FindBy(how = How.ID, using ="screen-info")
    public WebElement btn_screen_info;

    @FindBy(how = How.ID, using ="version-info")
    public WebElement btn_vesion_info;

    @FindBy(how = How.ID, using ="got-screen-info")
    public WebElement field_screen_info;

    @FindBy(how = How.ID, using ="got-version-info")
    public WebElement field_version_info;


}
