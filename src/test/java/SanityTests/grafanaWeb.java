package SanityTests;

import Extensions.uiActions;
import Utilities.commonOps;
import WorkFlows.webFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Extensions.verifications;
import Utilities.listeners;
import javax.swing.text.Utilities;

@Listeners(listeners.class)
public class grafanaWeb extends commonOps
{
    @Test(description= "Test01: Login to Grafana")
    @Description("Test Description: Loging to Grafana Web Appliccation")
    public void test01_login()
    {
        webFlows.login(getData("user"), getData("password"));
        verifications.textInElement(grafanaMain.txt_mainHeading, "Welcome to Grafana");
    }
    @Test(description= "Test02: Verify Default Users")
    @Description("Test Description: Verifies the Default Number of Users (Should be 1)")
    public void test02_verifyDefaultUsers()
    {
        uiActions.mouseOverElements(grafanaLeftMenu.btn_ServerAdmin, grafanaServerAdminMainPage.link_users);
        verifications.numOfElements(grafanaServerAdminMainPage.rows , 1);
    }

    @Test(description= "Test03: Add and Verify Users")
    @Description("Test Description: Add a New User and Verify the Number of Users is 2")
    public void test03_addAndverifyUsers()
    {
        uiActions.mouseOverElements(grafanaLeftMenu.btn_ServerAdmin, grafanaServerAdminMainPage.link_users);
        webFlows.createUser("avi" , "avi@gmail.com" ,"aaa" , " 123456" );
        verifications.numOfElements(grafanaServerAdminMainPage.rows , 2);
     }
    @Test(description= "Test04: Delete Last User and Verify Users")
    @Description("Test Description: Delete Last Created User and Verify the Number os Users is 1")
    public void test04_deleteAndVerifyUsers()
    {
        uiActions.mouseOverElements(grafanaLeftMenu.btn_ServerAdmin, grafanaServerAdminMainPage.link_users);
        webFlows.deleteLastUser();
        verifications.numOfElements(grafanaServerAdminMainPage.rows , 1);
    }
    @Test(description= "Test05: verify Avatar")
    @Description("Test Description: Verify Grafana's default (admin) avatar")
    public void test05_verifyAvatar()
    {
        verifications.visualElement(grafanaLeftMenu.img_Avatar, "grafanaAvatar");

    }
    @Test(description= "Test06: verify new folder doesn't have dashboard")
    @Description("Test Description: verify new folder doesn't have dashboard")
    public void test06_verifyNewFolder()
    {
        uiActions.mouseOverElements(grafanaLeftMenu.btn_plus, grafanaPlusMenuPage.link_folder);
        uiActions.updateText(grafanaFolderPage.txt_folderName, "test_folder7");
        uiActions.click(grafanaFolderPage.create_btn);
        verifications.text(grafanaFolderPage.box_folder.getText(),"This folder doesn't have any dashboards yet" );
    }

    @Test(description= "Test07: verify creation of dashboard and visual")
    @Description("Test Description: verify creation of dashboard and visual")
    public void test07_verifyDashBoard()
    {
        uiActions.mouseOverElements(grafanaLeftMenu.btn_plus, grafanaPlusMenuPage.link_dashboard);
        uiActions.click(grafanaDashboardPage.btn_chooseVisual);
        verifications.text(grafanaNewDashboardPage.txt_headerVisual.getText(),"Visualization");


    }
}


