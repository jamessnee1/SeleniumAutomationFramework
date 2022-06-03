package com.webtests.tests;

import com.webtests.ui.PizzaHQ.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PizzaHQTestSuite extends BaseTest {

    @Test
    public void validateMandatoryErrorMessageTest(){
        //Navigate to Contact Page
        PizzaHQMenu menu = new PizzaHQMenu(driver);
        menu.navigateToContactPage();

        //Click Submit
        ContactPage contactPage = new ContactPage(driver);
        contactPage.clickSubmitButton();

        //Verify Correct Error Messages
        String expectedForenameError = "Forename is required";
        String expectedEmailError = "Email is required";
        String expectedMessageError = "Message is required";
        //Forename
        Assertions.assertEquals(expectedForenameError, contactPage.getErrorMessageText("forename-err").trim());
        //Email
        Assertions.assertEquals(expectedEmailError, contactPage.getErrorMessageText("email-err").trim());
        //Message
        Assertions.assertEquals(expectedMessageError, contactPage.getErrorMessageText("message-err").trim());

        //Text Input into Forename
        contactPage.setForeName("Dan");
        //Verify Forename error is not visible/empty
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("forename-err")));

        //Text Input into Email
        contactPage.setEmail("dan@abc.com");
        //Verify email error is not visible/empty
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("email-err")));

        //Text Input into Message
        contactPage.setMessage("Nice Pizza");
        //Verify message error is not visible/empty
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("message-err")));

    }

    @Test
    public void fieldValidationTest(){
        //Navigate to Contact Page
        PizzaHQMenu menu = new PizzaHQMenu(driver);
        menu.navigateToContactPage();

        //Enter input into email field
        ContactPage contactPage = new ContactPage(driver);
        contactPage.setEmail("xxx");

        //Enter input into Telephone field
        contactPage.setTelephone("xxx");

        //Click Submit
        contactPage.clickSubmitButton();

        //Verify correct error messages
        String expectedTelephoneError = "Telephone is invalid";
        String expectedEmailError = "Email is invalid";
        //Email
        Assertions.assertEquals(expectedEmailError, contactPage.getErrorMessageText("email-err").trim());
        //Telephone
        Assertions.assertEquals(expectedTelephoneError, contactPage.getErrorMessageText("telephone-err").trim());

        //Click Clear
        contactPage.clickClearButton();

        WebDriverWait wait = new WebDriverWait(driver,5);
        //Verify email error is not visible/empty
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("email-err")));
        //Verify telephone error is not visible/empty
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("telephone-err")));

    }

    @Test
    public void validateContactSuccessTest(){
        //Navigate to Contact Page
        PizzaHQMenu menu = new PizzaHQMenu(driver);
        menu.navigateToContactPage();

        ContactPage contactPage = new ContactPage(driver);
        //Text Input into Forename
        String name = "Dan";
        contactPage.setForeName(name);

        //Text Input into Email
        contactPage.setEmail("dan@abc.com");

        //Text Input into Message
        contactPage.setMessage("Nice Pizza");

        //Click Submit
        contactPage.clickSubmitButton();

        //Validate popup message text
        String confirmationMessage = "Thanks " + name + ", we appreciate your feedback";
        Assertions.assertEquals(confirmationMessage, contactPage.getPopupMessageText());
    }

    @Test
    public void loginFieldValidationErrorMessageTest(){
        //Click the LOGIN/SIGNUP navigation menu item (it has a user icon)
        PizzaHQMenu menu = new PizzaHQMenu(driver);
        menu.navigateToLoginOrSignupPage();

        //Click the LOGIN button
        LoginSignupForm loginSignupForm = new LoginSignupForm(driver);
        loginSignupForm.clickLoginButton();

        //Verify that the alert message says:
        //Your login was unsuccessful - please try again
        Assertions.assertEquals("Your login was unsuccessful - please try again", loginSignupForm.getErrorMessageText());

        //Click the alert message dismiss icon (a red circle with a white X)
        loginSignupForm.dismissErrorMessage();

        //Verify that the alert message is no longer displayed
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("v-alert__content")));

    }

    @Test
    public void loginProfileValidationTest(){
        //Set data
        String username = "bob";
        String password = "ilovepizza";

        //Click the LOGIN/SIGNUP navigation menu item (it has a user icon)
        PizzaHQMenu menu = new PizzaHQMenu(driver);
        menu.navigateToLoginOrSignupPage();

        //Enter ‘bob’ into the Username field
        LoginSignupForm loginSignupForm = new LoginSignupForm(driver);
        loginSignupForm.setUsername(username);

        //Enter ‘ilovepizza’ into the Password field
        loginSignupForm.setPassword(password);

        //Click the LOGIN button
        loginSignupForm.clickLoginButton();

        //Click the PROFILE navigation menu item (it has a user icon and shows the username ‘BOB’)
        menu.navigateToYourProfilePage();

        //Verify that the header text on the profile page says
        //Welcome bob
        ProfilePage profilePage = new ProfilePage(driver);
        Assertions.assertEquals("Welcome bob", profilePage.getLoggedInMessage(username));

        //Capture the current page URL
        String currentUrl = driver.getCurrentUrl();

        //Hover the mouse over the PROFILE navigation menu item
        //Click the Logout dropdown menu item
        menu.logout();

        //Click the YES button in the Logout confirmation dialog
        ConfirmLogoutDialog confirmLogoutDialog = new ConfirmLogoutDialog(driver);
        confirmLogoutDialog.clickYes();

        //Attempt to navigate to the captured Profile page URL
        driver.get(currentUrl);

        //Verify that you are redirected to the home page
        //Verify that Your Profile button does not exist in menu
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[aria-label='your profile']")));

        //Verify that the Header is present for the Homepage
        Assertions.assertEquals("Welcome to PizzaHQ", driver.findElement(By.tagName("h1")).getText());
    }

    @Test
    public void signupFieldValidationErrorMessagesTest(){

        //Click the LOGIN/SIGNUP navigation menu item (it has a user icon)
        PizzaHQMenu menu = new PizzaHQMenu(driver);
        menu.navigateToLoginOrSignupPage();

        //Click the ‘Not a member? Sign up’ link
        LoginSignupForm loginSignupForm = new LoginSignupForm(driver);
        loginSignupForm.clickSignupButton();

        //Click the SIGN UP button
        SignupForm signupForm = new SignupForm(driver);
        signupForm.clickSignupButton();

        //Verify the error text for the Username, Password and Confirm Password fields:
        //Username is required
        Assertions.assertEquals("Username is required", signupForm.getErrorMessageText("username-err"));
        //Password is required
        Assertions.assertEquals("Password is required", signupForm.getErrorMessageText("password-err"));
        //Please confirm your password
        Assertions.assertEquals("Please confirm your password", signupForm.getErrorMessageText("confirm-err"));

        //Enter ‘abc’ into the Username field
        signupForm.setUsername("abc");
        //Enter ‘abc’ into the Password field
        signupForm.setPassword("abc");
        //Enter ‘def’ into the Confirm Password field
        signupForm.setConfirmPassword("def");
        //Verify the error text for the Username, Password and Confirm Password fields:
        //Username must be minimum of 6 characters
        Assertions.assertEquals("Username must be minimum of 6 characters", signupForm.getErrorMessageText("username-err"));
        //Username must be minimum of 8 characters
        Assertions.assertEquals("Password must be minimum of 8 characters", signupForm.getErrorMessageText("password-err"));
        //Your passwords do not match
        Assertions.assertEquals("Your passwords do not match", signupForm.getErrorMessageText("confirm-err"));

        //Enter ‘donaldtrump’ into the Username field
        signupForm.clearUsername();
        signupForm.setUsername("donaldtrump");
        //Verify the error text for the Username field:
        //Username already exists
        Assertions.assertEquals("Username already exists", signupForm.getErrorMessageText("username-err"));

        //Enter ‘robinhood’ into the Username field
        signupForm.clearUsername();
        signupForm.setUsername("robinhood");
        //Enter ‘letmein2019’ into the Password field
        signupForm.clearPassword();
        signupForm.setPassword("letmein2019");
        //Enter ‘letmein2019 into the Confirm Password field
        signupForm.clearConfirmPassword();
        signupForm.setConfirmPassword("letmein2019");

        //Verify the Username, Password and Confirm Password errors are empty or no longer displayed
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("username-err")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("password-err")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("confirm-err")));

        //Click Sign Up (step was not in requirements)
        signupForm.clickSignupButton();

        //Verify that the snackbar popup message text is
        //‘Thanks robinhood, you can now login.’
        Assertions.assertEquals("Thanks robinhood, you can now login.", signupForm.getPopupMessageText());
    }

    @Test
    public void menuItemKilojoulesAndPriceTest(){


    }

    @Test
    public void newSideDishTest(){

    }

    @Test
    public void veganPizzaSliceTest(){

    }

    @Test
    public void menuItemRatingsTest(){

    }

    @Test
    public void orderCountAndItemSubtotalTest(){


    }
}
