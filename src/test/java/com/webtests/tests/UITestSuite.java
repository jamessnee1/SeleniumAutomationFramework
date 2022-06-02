package com.webtests.tests;

import com.webtests.ui.FormsPage;
import com.webtests.ui.Menu;
import com.webtests.ui.PlanetsPage;
import org.junit.jupiter.api.*;


public class UITestSuite extends BaseTestSuite {

    @Test
    public void validateFormErrorsTest(){
        //Create menu object
        Menu menu = new Menu(driver);

        //Navigate to form
        menu.navigateToFormsPage();

        //Submit
        FormsPage formsPage = new FormsPage(driver);
        formsPage.clickSubmitButton();

        String expectedNameError = "Your name is required";
        String expectedEmailError = "Your email is required";
        String expectedAgreeError = "You must agree to continue";

        //Validate Name Error
        Assertions.assertEquals(expectedNameError, formsPage.getErrorMessageText("name-err").trim());
        //Validate Email Error
        Assertions.assertEquals(expectedEmailError, formsPage.getErrorMessageText("email-err").trim());
        //Validate Agree Error
        Assertions.assertEquals(expectedAgreeError, formsPage.getErrorMessageText("agree-err").trim());

        System.out.println("ValidateFormErrorsTest PASSED!");

    }

    @Test
    public void FormTest(){

        //Create menu object
        Menu menu = new Menu(driver);

        //Navigate to form
        menu.navigateToFormsPage();

        //Fill in form
        FormsPage formsPage = new FormsPage(driver);
        String name = "James";
        String email = "James@test.com";
        String state = "VIC";
        String confirmationMessage = "Thanks for your feedback " + name;

        //Name
        formsPage.setName(name);
        //Email
        formsPage.setEmail(email);
        //State
        formsPage.setState(state);
        //Agree button
        formsPage.clickAgreeButton();
        //Submit
        formsPage.clickSubmitButton();
        //Confirmation popup
        Assertions.assertEquals(formsPage.getPopupMessageText(), confirmationMessage);

        System.out.println("FormTest PASSED!");

    }

    @Test
    public void DistanceToJupiterTest(){
        //Create menu and navigate to Planets page
        Menu menu = new Menu(driver);
        menu.navigateToPlanetsPage();

        //Create planets page
        var planetsPage = new PlanetsPage(driver);

        //Get jupiter tile
        var jupiter = planetsPage.findPlanetTileByName("jupiter");

        //Validate distance
        Assertions.assertEquals("778,500,000 km", jupiter.getPlanetDistanceAsString());

        System.out.println("DistanceToJupiterTest PASSED!");
    }

    @Test
    public void PlanetFurthestFromTheSunTest(){
        //Create menu and navigate to Planets page
        Menu menu = new Menu(driver);
        menu.navigateToPlanetsPage();

        //Create planets page
        var planetsPage = new PlanetsPage(driver);

        //Find distance furthest from the sun
        String furthestPlanet = planetsPage.getPlanetFurthestFromSun();
        Assertions.assertEquals("Uranus", furthestPlanet);
        System.out.println("Planet furthest from the sun is " + furthestPlanet + "!");


    }
}
