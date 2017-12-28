package by.epam.makarevich.validator;

import org.junit.Assert;
import org.junit.Test;

public class UserValidatorTest {

    @Test
    public void checkRightName() {
        String name = "Карина";
        String regex = "([A-Za-z]|[А-Яа-я]){2,25}";
        Assert.assertTrue(new UserValidator().checkWord(name, regex));
    }

    @Test
    public void checkWrongName() {
        String name = "L11";
        String regex = "([A-Za-z]|[А-Яа-я]){2,25}";
        Assert.assertFalse(new UserValidator().checkWord(name, regex));
    }

    @Test
    public void checkWrongMail() {
        String mail = "L11";
        Assert.assertFalse(new UserValidator().checkEmail(mail));
    }

    @Test
    public void checkRightMail() {
        String mail = "karinamakarevich@gmail.com";
        Assert.assertTrue(new UserValidator().checkEmail(mail));
    }

    @Test
    public void checkRightPassword() {
        String password = "y1LЬAjсQ5Z";
        Assert.assertTrue(new UserValidator().checkPassword(password));
    }

    @Test
    public void checkWrongPassword() {
        String password = "Password";
        Assert.assertFalse(new UserValidator().checkPassword(password));
    }

    @Test
    public void checkRightPasswordEquality() {
        String password = "y1LЬAjсQ5Z";
        String passwordRepetition = "y1LЬAjсQ5Z";
        Assert.assertTrue(new UserValidator().checkPasswordEquality(password, passwordRepetition));
    }

    @Test
    public void checkWrongPasswordEquality() {
        String password = "y1LЬAjсQ5Z";
        String passwordRepetition = "y1LЬAjсlll";
        Assert.assertFalse(new UserValidator().checkPasswordEquality(password, passwordRepetition));
    }
}
