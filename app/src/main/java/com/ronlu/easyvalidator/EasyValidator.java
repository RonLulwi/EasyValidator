package com.ronlu.easyvalidator;

import android.util.Patterns;

public class EasyValidator {
    /**
     Validates an email address string based on the email address pattern provided.
     @param email The email address string to validate.
     @return true if the email address string is valid, false otherwise.
     */
    public static boolean validateEmail(String email){
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    /**
     * @param password The password string to compare.
     * @param confirmation The password string to validate
     * @return true only if password is equals confirmation
     */
    public static boolean confirmPassword(String password, String confirmation){
        return password.equals(confirmation);
    }

    /**
     * @param password The password string to validate.
     * @return PasswordStraight enum class
     *<li> WEAK - for weak password
     *<li> MEDIUM - for medium password
     *<li> STRONG - for strong password
     *<li> INVALID - for invalid password
     */
    public static PasswordStraight estimatePasswordStraight(String password){
        if(validateStrongPassword(password))
            return PasswordStraight.STRONG;
        if(validateMediumPassword(password))
            return PasswordStraight.MEDIUM;
        if(validateWeakPassword(password))
            return PasswordStraight.WEAK;
        return PasswordStraight.INVALID;
    }

    /**
     * @param password The password string to validate.
     * @return true if password straight is weak
     *<li> Must contains between 1 and 7 characters long.
     */
    public static boolean validateWeakPassword(String password){
        return password.matches("^.{1,7}$");
    }

    /**
     * @param password The password string to validate.
     * @return true if password straight is medium
     *<li> Must contain at least one digit.
     *<li> Must contain at least one letter (either uppercase or lowercase).
     *<li> Must be at least 8 characters long.
     */
    public static boolean validateMediumPassword(String password){
        return password.matches("^(?=.*\\d)(?=.*[a-zA-Z]).{8,}$");
    }

    /**
     * @param password The password string to validate.
     * @return true if password straight is strong
     *<li> Must contain at least one digit.
     *<li> Must contain at least one lowercase letter.
     *<li> Must contain at least one uppercase  letter.
     *<li> Must contain at least one special character from.
     *<li> Must not contain whitespace
     *<li> Must be at least 8 characters long.
     */
    public static boolean validateStrongPassword(String password){
        return password.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");
    }

    /**
     * Validates that an input string contains a phone number, in a common format, including country code,
     * area code and phone number. The phone number can be formatted with hyphens or parentheses, and spaces
     * or dots can be used to separate the groups of digits.
     *
     * @param input The input string to validate.
     * @return true if the input string contains a valid phone number, false otherwise.
     *<p> Valid phone numbers:
     *<ul>
     *<li> +1-555-555-5555
     *<li> 555-555-5555
     *<li> (555) 555-5555
     *<li> +44 20 1234 5678
     *<li> +971-4-123-4567
     *<li> 555.555.5555
     *<li> 5555555555
     *<li> 1-800-555-5555
     *<li> 123-456-7890
     * </ul>
     *<p> Invalid phone numbers:
     * <ul>
     *<li> 1234567890 (missing separators)
     *<li> 555-5555 (missing digits in area code or phone number)
     *<li> +999-555-555-5555 (invalid country code)
     *<li> (555)-555-5555 (invalid use of parentheses)
     *<li> 1-800-CALL-NOW (not a numeric phone number)
     *<li> 555-555-55555 (too many digits in last group)
     *<li> +1-5555-555-555 (too many digits in area code)
     *<li> 555+555+5555 (invalid use of plus sign)
     * </ul>
     */
    public static boolean validatePhoneNumber(String input) {
        return input.matches("^\\+?\\d{1,3}?[-.\\s]?\\(?\\d{3}\\)?[-.\\s]?\\d{3}[-.\\s]?\\d{4}$");
    }

    /**
     * Validates that an input string contains a full name, consisting of one or more words
     * separated by whitespace, where each word only contains alphabetic characters and may contain
     * dashes or apostrophes.
     *
     * @param input The input string to validate.
     * @return true if the input string contains a valid full name, false otherwise.
     */
    public static boolean validateFullName(String input) {
        return input.matches("^[a-zA-Z]+([\\s-']+[a-zA-Z]+)*$");
    }

    /**
     Validates an input string based on a regular expression pattern provided as a string argument.
     @param input The input string to validate.
     @param regex The regular expression pattern to use for validation.
     @return true if the input string matches the regex pattern, false otherwise.
     */
    public static boolean customValidator(String input, String regex){
        return input.matches(regex);
    }

    /**
     * Validates that an input string only contains integer digits (0-9).
     * @param input The input string to validate.
     * @return true if the input string contains only integer digits, false otherwise.
     */
    public static boolean validateInt(String input) {
        return input.matches("\\d+");
    }

    /**
     * Validates that an input string only contains alphabetic characters (a-zA-Z).
     * @param input The input string to validate.
     * @return true if the input string contains only alphabetic characters, false otherwise.
     */
    public static boolean validateString(String input) {
        return input.matches("[a-zA-Z]+");
    }

    /**
     * Validates that an input string only contains numeric characters (0-9) and one decimal point.
     * @param input The input string to validate.
     * @return true if the input string contains only numeric characters and one decimal point, false otherwise.
     */
    public static boolean validateDouble(String input) {
        return input.matches("\\d+(\\.\\d+)?");
    }

    /**
     * This method uses regex to validate an age.
     * @param age An integer representing an age.
     * @return True if the age is valid, False otherwise.
     */
    public static boolean validateAge(String age){
        return age.matches("^([1-9]\\d?|1[01]\\d|120)$");
    }


}
