package SanityTests;

import Extensions.verifications;
import Utilities.commonOps;
import WorkFlows.apiFlows;
import WorkFlows.webFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class grafanaAPI extends commonOps

{
  /*  @Test(description= "Test01: Get Team From Grafana")
    @Description("Test Description: Loging to Grafana Get Team From Grafana")
    public void test01_GetTeam()
    {
        apiFlows.getTeamProperty("teams[0].name");
        verifications.text(apiFlows.getTeamProperty("teams[0].name"), "aviteam");
    }*/


    @Test(description= "Test01: Add Team And Verify")
    @Description("Test Description: Add Team to Grafana And Verify it")
    public void test02_addTeamAndVerify()
    {
        apiFlows.postTeam("AviTeam1" , "Avi@team1.com");
        verifications.text(apiFlows.getTeamProperty("teams[0].name"), "AviTeam1");
    }


    @Test(description= "Test02: Add Team And Verify")
    @Description("Test Description: UpdateTeam in Grafana And Verify it")
    public void test03_updateTeamAndVerify()
    {
        apiFlows.updateTeam("MyTeamAviTeam1" , "Avi@team1.com" , "9");
        verifications.text(apiFlows.getTeamProperty("teams[0].name"), "MyTeamAviTeam1");
    }

    @Test(description= "Test03: Delete Team And Verify")
    @Description("Test Description: Delete Team in Grafana And Verify it")
    public void test04_deleteTeamAndVerify()
    {
        apiFlows.deleteTeam("9");
        verifications.text(apiFlows.getTeamProperty("totalCount"), "0");
    }
}
