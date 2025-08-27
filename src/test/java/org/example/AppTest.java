package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class AppTest
{
    @Test
     void when_length_of_thePassword_is7_return_false(){
        assertFalse(App.hasMinLength("1234567", 8));
    }

    @Test
    void when_length_of_thePassword_is8_return_true(){
        assertTrue(App.hasMinLength("12345678", 8));
    }

    @Test
    void when_length_of_thePassword_isMoreThan8_return_true(){
        assertTrue(App.hasMinLength("123456789", 8));
    }

    @Test
    void when_Password_isEmptyString_return_false() {
        assertFalse(App.hasMinLength("", 8));
    }



    @Test
    void when_thePassword_Has_No_Number_shouldReturnFalse() {
        assertFalse(App.containsNumber("abcdefdf"));
    }

    @Test
    void when_thePassword_Has_One_Number_shouldReturnTrue() {
        assertTrue(App.containsNumber("abc1def"));
    }

    @Test
    void when_thePassword_Has_Multiple_Numbers_shouldReturnTrue() {
        assertTrue(App.containsNumber("a1b2c3"));
    }

    @Test
    void when_thePassword_Isonly_Numbers_shouldReturnTrue() {
        assertTrue(App.containsNumber("123456"));
    }

    @Test
    public void unicode_Digits_Ignored() {
        assertFalse(App.containsNumber("abc١٢٣"));
    }

    @Test
    void when_thePassword_Contains_OnlyLowercase_shouldReturnFalse() {
        assertFalse(App.containsUpperAndLower("abcdef"));
    }

    @Test
    void when_thePassword_Contains_OnlyUppercase_shouldReturnFalse() {
        assertFalse(App.containsUpperAndLower("ABCDEF"));
    }

    @Test
    void when_thePassword_Contains_UpperAndLowerCase_shouldReturnTrue() {
        assertTrue(App.containsUpperAndLower("AbCdEf"));
    }

    @Test
    public void when_OneUpperOnly_ReturnFalse() {
        assertFalse(App.containsUpperAndLower("A"));
    }

    @Test
    public void when_OneLowerOnly_ReturnFalse() {
        assertFalse(App.containsUpperAndLower("z"));
    }

    @Test
    void testIfCommonPassword_whenExactMatch_shouldReturnTrue() {
        assertTrue(App.isCommonPassword("password"));
        assertTrue(App.isCommonPassword("Passwort1"));
        assertTrue(App.isCommonPassword("12345678"));
        assertTrue(App.isCommonPassword("Aa345678"));
    }

    @Test
    void testIfCommonPassword_whenNotInList_shouldReturnFalse() {
        assertFalse(App.isCommonPassword("Here_We_G0"));
    }

    @Test
    void testIsValid_whenAllCriteriaMet_shouldReturnTrue() {
        assertTrue(App.isValid("Abcd1234"));
    }

    @Test
    void testIsValid_whenTooShort_shouldReturnFalse() {
        assertFalse(App.isValid("Abc123"));
    }

    @Test
    void testIsValid_whenMissingDigit_shouldReturnFalse() {
        assertFalse(App.isValid("Abcdefgh"));
    }

    @Test
    void testIsValid_whenMissingUppercaseOrLowercase_shouldReturnFalse() {
        assertFalse(App.isValid("abcdef12"));
        assertFalse(App.isValid("ABCDEF12"));
    }

    @Test
    void testIsValid_whenCommonPassword_shouldReturnFalse() {
        assertFalse(App.isValid("Password"));
        assertFalse(App.isValid("12345678"));
    }

    @Test
    void testIsValid_whenEmptyOrNull_shouldReturnFalse() {
        assertFalse(App.isValid(""));
        assertFalse(App.isValid(null));
    }

}
