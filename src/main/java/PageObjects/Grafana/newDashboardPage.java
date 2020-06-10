package PageObjects.Grafana;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class newDashboardPage
{
    @FindBy(how = How.CLASS_NAME, using ="toolbar__heading")
    public WebElement txt_headerVisual;

}
