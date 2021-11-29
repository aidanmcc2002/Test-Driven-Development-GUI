import com.example.cs3318_assigment3.Exceptions.*;
import com.example.cs3318_assigment3.Presenter;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordTests {

    @Test
    public void fieldTest(){
        EmptyFieldException thrown = Assertions.assertThrows(EmptyFieldException.class,() ->{
            Presenter cls = new Presenter();
            cls.verifyPassword("");
        },"Please input something into password field");
        Assertions.assertEquals("Please input something into password field",thrown.getMessage());
    }
    /* Test to see if the Length Exception is thrown */
    @Test
    public void lengthTest() {
        LengthException thrown = Assertions.assertThrows(LengthException.class,() ->{
            Presenter cls = new Presenter();
            cls.verifyPassword("short");
        },"Please Ensure Password is Longer than 7 Chars");
        Assertions.assertEquals("Please Ensure Password is Longer than 7 Chars",thrown.getMessage());
    }

    @Test
    public void digitTest(){
        DigitException thrown = Assertions.assertThrows(DigitException.class,() ->{
            Presenter cls = new Presenter();
            cls.verifyPassword("password");
        },"Please Ensure Password Contains a Number");
        Assertions.assertEquals("Please Ensure Password Contains a Number",thrown.getMessage());

    }

    @Test
    public void letterTest() {
        LetterException thrown = Assertions.assertThrows(LetterException.class,() ->{
            Presenter cls = new Presenter();
            cls.verifyPassword("12345678");
        },"Please Ensure Password Contains a letter");
        Assertions.assertEquals("Please Ensure Password Contains a letter",thrown.getMessage());

    }

    @Test
    public void specialCharTest(){
        SpecialCharException thrown = Assertions.assertThrows(SpecialCharException.class,() ->{
            Presenter cls = new Presenter();
            cls.verifyPassword("passwo12345");
        },"Please Ensure Password Contains one of these chars ' ^ & @ ! ' ");
        Assertions.assertEquals("Please Ensure Password Contains one of these chars ' ^ & @ ! ' ",thrown.getMessage());
    }

    @Test
    public void successPassTest() throws DigitException, LengthException, LetterException, SpecialCharException, EmptyFieldException {
        Presenter cls = new Presenter();
        Boolean result = cls.verifyPassword("password123*4!");
        assertTrue(result);
    }
}
