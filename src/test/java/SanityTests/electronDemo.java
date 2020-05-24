package SanityTests;

import Extensions.verifications;
import Utilities.commonOps;
import WorkFlows.electronFlow;
import WorkFlows.webFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import Utilities.listeners;


public class electronDemo extends commonOps

{

    @Test(description= "Test01: Verify Screen Resolution ")
    @Description("Test Description: Getting the Resolution from App and verify it")
    public void test01_login()
    {
        electronFlow.getScreenInfo();
        verifications.textInElement(electronMain.field_screen_info , "Your screen is: 1368px x 912px");
    }

    @Test(description= "Test02: Verify Application Version Number ")
    @Description("Test Description: Getting the Version number from App and verify it")
    public void test02_versionVeriffication()
    {
        electronFlow.getAppVersion();
        verifications.textInElement(electronMain.field_version_info , "This app is using Electron version: 4.0.1");
    }
}
