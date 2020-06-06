package PageObjects.Grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class plusMenuPage
{
    @FindBy(how = How.CSS, using ="a[href='/dashboard/new']")
    public WebElement link_dashboard;

    @FindBy(how = How.CSS, using ="a[href='/dashboards/folder/new']")
    public WebElement link_folder;

    @FindBy(how = How.CSS, using ="a[href='/dashboard/import']")
    public WebElement link_import;


}
