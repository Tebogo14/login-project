/**
 * Login class for the Chat App registration and login feature.
 * Handles user registration validation and login authentication.
 */
public class Login {

    private String username;
    private String password;
    private String cellPhoneNumber;
    private String firstName;
    private String lastName;

    public Login(String firstName, String lastName, String username, String password, String cellPhoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
    }

    /**
     * Checks that the username contains an underscore (_) and is no more than five characters long.
     *
     * @return true if valid, false otherwise
     */
    public boolean checkUserName() {
        return username.contains("_") && username.length() <= 5;
    }

    /**
     * Checks that the password meets the following complexity rules:
     * - At least eight characters long
     * - Contains a capital letter
     * - Contains a number
     * - Contains a special character
     *
     * @return true if valid, false otherwise
     */
    public boolean checkPasswordComplexity() {
        if (password.length() < 8) {
            return false;
        }
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            if (Character.isDigit(c)) hasDigit = true;
            if (!Character.isLetterOrDigit(c)) hasSpecial = true;
        }
        return hasUpper && hasDigit && hasSpecial;
    }

    /**
     * Checks that the cell phone number contains the international country code
     * followed by the number, which is no more than ten characters long.
     *
     * Regex pattern: starts with '+', followed by 1-3 digit country code,
     * followed by up to 10 digit local number.
     *
     * Reference: https://www.oreilly.com/library/view/regular-expressions-cookbook/9781449327453/ch04s03.html
     *
     * @return true if valid, false otherwise
     */
    public boolean checkCellPhoneNumber() {
        return cellPhoneNumber.matches("^\\+[0-9]{1,3}[0-9]{1,10}$");
    }

    /**
     * Registers the user and returns the appropriate status message.
     * Checks username, password, and cell phone number in order.
     *
     * @return registration status message
     */
    public String registerUser() {
        if (!checkUserName()) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if (!checkCellPhoneNumber()) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }
        return "Username successfully captured.\nPassword successfully captured.\nCell phone number successfully added.";
    }

    /**
     * Verifies that the login details entered match the details stored at registration.
     *
     * @param enteredUsername the username entered at login
     * @param enteredPassword the password entered at login
     * @return true if credentials match, false otherwise
     */
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        return username.equals(enteredUsername) && password.equals(enteredPassword);
    }

    /**
     * Returns the appropriate login status message.
     *
     * @param enteredUsername the username entered at login
     * @param enteredPassword the password entered at login
     * @return welcome message on success, error message on failure
     */
    public String returnLoginStatus(String enteredUsername, String enteredPassword) {
        if (loginUser(enteredUsername, enteredPassword)) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        }
        return "Username or password incorrect, please try again.";
    }
}
