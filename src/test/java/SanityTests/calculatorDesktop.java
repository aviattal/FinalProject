package SanityTests;

import Extensions.verifications;
import Utilities.commonOps;
import WorkFlows.calcFlow;
import WorkFlows.webFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import Utilities.listeners;

public class calculatorDesktop extends commonOps
{

    @Test(description= "Test01: Verify Addistion Command")
    @Description("Test Description: Verify addition command in calculator")
    public void test01_addition()
    {
        calcFlow.calculateAddition();
        verifications.textInElement(calcMain.field_result, "8");
    }


}
