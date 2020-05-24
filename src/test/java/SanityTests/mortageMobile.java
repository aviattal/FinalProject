package SanityTests;

import Extensions.verifications;
import Utilities.commonOps;
import Utilities.listeners;
import WorkFlows.mobileFlows;
import WorkFlows.webFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(listeners.class)

public class mortageMobile extends commonOps
{
    @Test(description= "Test01: Verify Mortgage")
    @Description("Test Description: Fill in Mortgage fields and calculate repayment")
    public void test01_verifyRepayment()
    {
        mobileFlows.calculate("1000", "3" , "4");
        verifications.textInElement(mortgaeMain.txt_repayment , "£30.03");
    }
}
