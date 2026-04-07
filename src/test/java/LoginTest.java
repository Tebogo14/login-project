import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    private Login login;

    @BeforeEach
    void setUp() {
        login = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
    }

    // --- checkUserName() tests ---

    @Test
    void testUserNameCorrectlyFormatted() {
        // "kyl_1" contains underscore and is 5 characters — valid
        assertTrue(login.checkUserName());
    }

    @Test
    void testUserNameNoUnderscore() {
        Login noUnderscore = new Login("Kyle", "Smith", "kyle1", "Ch&&sec@ke99!", "+27838968976");
        assertFalse(noUnderscore.checkUserName());
    }

    @Test
    void testUserNameTooLong() {
        Login tooLong = new Login("Kyle", "Smith", "kyle_1", "Ch&&sec@ke99!", "+27838968976");
        assertFalse(tooLong.checkUserName());
    }

    // --- checkPasswordComplexity() tests ---

    @Test
    void testPasswordCorrectlyFormatted() {
        assertTrue(login.checkPasswordComplexity());
    }

    @Test
    void testPasswordTooShort() {
        Login shortPwd = new Login("Kyle", "Smith", "kyl_1", "Ch&1!", "+27838968976");
        assertFalse(shortPwd.checkPasswordComplexity());
    }

    @Test
    void testPasswordNoUpperCase() {
        Login noUpper = new Login("Kyle", "Smith", "kyl_1", "ch&&sec@99!", "+27838968976");
        assertFalse(noUpper.checkPasswordComplexity());
    }

    @Test
    void testPasswordNoNumber() {
        Login noNum = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke!!", "+27838968976");
        assertFalse(noNum.checkPasswordComplexity());
    }

    @Test
    void testPasswordNoSpecialCharacter() {
        Login noSpecial = new Login("Kyle", "Smith", "kyl_1", "Cheesecake99", "+27838968976");
        assertFalse(noSpecial.checkPasswordComplexity());
    }

    // --- checkCellPhoneNumber() tests ---

    @Test
    void testCellPhoneCorrectlyFormatted() {
        assertTrue(login.checkCellPhoneNumber());
    }

    @Test
    void testCellPhoneNoInternationalCode() {
        Login noCode = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "0838968976");
        assertFalse(noCode.checkCellPhoneNumber());
    }

    @Test
    void testCellPhoneNumberTooLong() {
        Login tooLong = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+2783896897612345");
        assertFalse(tooLong.checkCellPhoneNumber());
    }

    // --- registerUser() tests ---

    @Test
    void testRegisterUserSuccess() {
        String result = login.registerUser();
        assertEquals("Username successfully captured.\nPassword successfully captured.\nCell phone number successfully added.", result);
    }

    @Test
    void testRegisterUserInvalidUsername() {
        Login badUsername = new Login("Kyle", "Smith", "toolongname", "Ch&&sec@ke99!", "+27838968976");
        assertEquals(
            "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.",
            badUsername.registerUser()
        );
    }

    @Test
    void testRegisterUserInvalidPassword() {
        Login badPassword = new Login("Kyle", "Smith", "kyl_1", "password", "+27838968976");
        assertEquals(
            "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.",
            badPassword.registerUser()
        );
    }

    @Test
    void testRegisterUserInvalidCellPhone() {
        Login badPhone = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "0831234567");
        assertEquals(
            "Cell phone number incorrectly formatted or does not contain international code.",
            badPhone.registerUser()
        );
    }

    // --- loginUser() tests ---

    @Test
    void testLoginUserSuccess() {
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    void testLoginUserWrongPassword() {
        assertFalse(login.loginUser("kyl_1", "wrongpassword"));
    }

    @Test
    void testLoginUserWrongUsername() {
        assertFalse(login.loginUser("wrong", "Ch&&sec@ke99!"));
    }

    // --- returnLoginStatus() tests ---

    @Test
    void testReturnLoginStatusSuccess() {
        assertEquals(
            "Welcome Kyle, Smith it is great to see you again.",
            login.returnLoginStatus("kyl_1", "Ch&&sec@ke99!")
        );
    }

    @Test
    void testReturnLoginStatusFailure() {
        assertEquals(
            "Username or password incorrect, please try again.",
            login.returnLoginStatus("kyl_1", "wrongpassword")
        );
    }
}
