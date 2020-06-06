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

    @Test(description= "Test01: Verify Addiction Command")
    @Description("Test Description: Verify addition command in calculator")
    public void test01_addition()
    {
        calcFlow.calculateAddition();
        verifications.textInElement(calcMain.field_result, "8");
    }

    @Test(description= "Test02: Verify Subtraction Command")
    @Description("Test Description: Verify subtraction command in calculator")
    public void test02_subtraction()
    {
        calcFlow.calculateSubtraction();
        verifications.textInElement(calcMain.field_result, "2");
    }

    @Test(description= "Test03: Verify Multiply Command")
    @Description("Test Description: Verify multiply command in calculator")
    public void test03_calculateMultiply()
    {
        calcFlow.calculateMultiply();
        verifications.textInElement(calcMain.field_result, "63");
    }

}
