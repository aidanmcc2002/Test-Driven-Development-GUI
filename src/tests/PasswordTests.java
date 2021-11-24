import com.example.cs3318_assigment3.Exceptions.SpecialCharException;
import com.example.cs3318_assigment3.HelloController;
import org.junit.Test;
import com.example.cs3318_assigment3.Exceptions.LengthException;
import com.example.cs3318_assigment3.Exceptions.LetterException;
import com.example.cs3318_assigment3.Exceptions.DigitException;
import com.example.cs3318_assigment3.Exceptions.SpecialCharException;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordTests {

    /* Test to see if the Length Exception is thrown */
    @Test
    public void lengthTest() {
        LengthException thrown = Assertions.assertThrows(LengthException.class,() ->{
            HelloController cls = new HelloController();
            cls.verifyPassword("short");
        },"Please Ensure Password is Longer than 7 Chars");
        Assertions.assertEquals("Please Ensure Password is Longer than 7 Chars",thrown.getMessage());
    }

    @Test
    public void digitTest(){
        DigitException thrown = Assertions.assertThrows(DigitException.class,() ->{
            HelloController cls = new HelloController();
            cls.verifyPassword("password");
        },"Please Ensure Password Contains a Number");
        Assertions.assertEquals("Please Ensure Password Contains a Number",thrown.getMessage());

    }

    @Test
    public void letterTest() {
        LetterException thrown = Assertions.assertThrows(LetterException.class,() ->{
            HelloController cls = new HelloController();
            cls.verifyPassword("12345678");
        },"Please Ensure Password Contains a letter");
        Assertions.assertEquals("Please Ensure Password Contains a letter",thrown.getMessage());

    }

    @Test
    public void specialCharTest(){
        SpecialCharException thrown = Assertions.assertThrows(SpecialCharException.class,() ->{
            HelloController cls = new HelloController();
            cls.verifyPassword("passwo12345");
        },"Please Ensure Password Contains one of these chars ' ^ & @ ! ' ");
        Assertions.assertEquals("Please Ensure Password Contains one of these chars ' ^ & @ ! ' ",thrown.getMessage());
    }

    @Test
    public void successPassTest() throws DigitException, LengthException, LetterException, SpecialCharException {
        HelloController cls = new HelloController();
        Boolean result = cls.verifyPassword("password123*4!");
        assertTrue(result);
    }
}
