package PageObjects.Grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class userListPage
{
    @FindBy(how = How.CSS, using ="input[name='name']")
    public WebElement txt_name;

    @FindBy(how = How.CSS, using ="input[name= 'email']")
    public WebElement txt_email;

    @FindBy(how = How.CSS, using ="input[name ='login']")
    public WebElement txt_login;

    @FindBy(how = How.CSS, using ="input[name ='password']")
    public WebElement txt_password;

    @FindBy(how = How.CSS, using ="button[class='css-1emkf9f-button']")
    public WebElement btn_create;

    @FindBy(how = How.CSS, using ="button[class='css-1o8xzkc-button']")
    public WebElement btn_delete;

    @FindBy(how = How.CSS, using ="div[class='css-njqcnt']")
    public WebElement btn_confirmDelete;
}
