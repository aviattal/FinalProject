package PageObjects.Grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class folderPage
{
    @FindBy(how = How.XPATH, using ="/html/body/grafana-app/div/div/div/form/div[1]/div/input")
    public WebElement txt_folderName;

    @FindBy(how = How.CLASS_NAME, using ="btn-primary")
    public WebElement create_btn;

    @FindBy(how = How.CLASS_NAME, using ="css-m2iibx")
    public WebElement box_folder;

}
