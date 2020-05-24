package Extensions;

import Utilities.commonOps;
import io.qameta.allure.Step;
import jdk.jfr.events.ExceptionThrownEvent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.sql.SQLException;

public class dbActions extends commonOps
{
    @Step("Get The Credentials From DB")
    public static void getCredentials(String query)
    {
        try
        {
            rs = stmt.executeQuery(query);
            rs.next();
            System.out.println("##### user is: " + rs.getString(1));
            System.out.println("##### password is: "+ rs.getString(2));
        }
            catch (Exception e)
        {
            System.out.println("Error Occurred while printing table data "+ e);
        }
    }
}
