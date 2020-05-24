package WorkFlows;

import Extensions.uiActions;
import Utilities.commonOps;
import io.qameta.allure.Step;

public class electronFlow extends commonOps
{
    @Step("Get Screen Info Resolution")
    public static void getScreenInfo()
    {
        uiActions.click(electronMain.btn_info);
        uiActions.click(electronMain.btn_demo_toggle);
        uiActions.click(electronMain.btn_screen_info);
        uiActions.click(electronMain.field_screen_info);
    }

    @Step("Get Application Info Version")
    public static void getAppVersion()
    {
        //uiActions.click(electronMain.btn_info);
        uiActions.click(electronMain.btn_version_toggle);
        uiActions.click(electronMain.btn_vesion_info);
        uiActions.click(electronMain.field_version_info);
    }


}
