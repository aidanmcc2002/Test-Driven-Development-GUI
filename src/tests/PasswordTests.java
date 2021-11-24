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
    @Test(expected = LengthException.class)
    public void lengthTest() {
        LengthException thrown = Assertions.assertThrows(LengthException.class,() ->{
            HelloController cls = new HelloController();
            cls.verifyPassword("short");
        },"Please Ensure Password is Longer than 7 Chars");
        Assertions.assertEquals("Please Ensure Password is Longer than 7 Chars",thrown.getMessage());
    }

    @Test(expected = LetterException.class)
    public void letterTest() throws DigitException, LengthException {
        HelloController cls = new HelloController();
        cls.verifyPassword("12345678");
    }

    @Test(expected = DigitException.class)
    public void digitTest() throws DigitException, LengthException {
        HelloController cls = new HelloController();
        cls.verifyPassword("password");
    }

    @Test(expected = SpecialCharException.class)
    public void specialCharTest() throws DigitException, LengthException {
        HelloController cls = new HelloController();
        cls.verifyPassword("passwo12345");
    }

    @Test
    public void successPassTest() throws DigitException, LengthException {
        HelloController cls = new HelloController();
        Boolean result = cls.verifyPassword("password1234!");
        assertTrue(result);
    }
}
