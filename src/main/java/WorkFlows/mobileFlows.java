package WorkFlows;

import Extensions.uiActions;
import Utilities.commonOps;
import io.qameta.allure.Step;

public class mobileFlows extends commonOps
{
    @Step("Fill in Form and Calculate Mortgage")
    public static void calculate (String amount , String term , String rate )
    {
        uiActions.updateText(mortgaeMain.txt_amount, amount);
        uiActions.updateText(mortgaeMain.txt_term, term);
        uiActions.updateText(mortgaeMain.txt_rate, rate);
        uiActions.click(mortgaeMain.btn_calculate);
    }



}
