import com.example.cs3318_assigment3.Exceptions.EmailException;
import com.example.cs3318_assigment3.Exceptions.EmptyFieldException;
import com.example.cs3318_assigment3.Exceptions.LengthException;
import com.example.cs3318_assigment3.Model;
import com.example.cs3318_assigment3.Presenter;
import org.junit.Test;
import javafx.scene.control.Label;
import org.junit.jupiter.api.Assertions;

public class EmailTests {

    @Test
    public void emailTest() {
        EmailException thrown = Assertions.assertThrows(EmailException.class,() ->{
            Presenter cls = new Presenter();
            cls.verifyEmail("test");
        },"Please Ensure Valid Email Inputted");
        Assertions.assertEquals("Please Ensure Valid Email Inputted",thrown.getMessage());
    }

    @Test
    public void emailFieldTest(){
        EmptyFieldException thrown = Assertions.assertThrows(EmptyFieldException.class,() ->{
            Presenter cls = new Presenter();
            cls.verifyEmail("");
        },"Please input something into email field");
        Assertions.assertEquals("Please input something into email field",thrown.getMessage());
    }
    }

