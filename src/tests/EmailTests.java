import com.example.cs3318_assigment3.Exceptions.EmailException;
import com.example.cs3318_assigment3.Exceptions.EmptyFieldException;
import com.example.cs3318_assigment3.Presenter;
import com.example.cs3318_assigment3.View;
import javafx.scene.control.Label;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class EmailTests {
    private Label label;
    @Test
    public void emailTest() {
        EmailException thrown = Assertions.assertThrows(EmailException.class,() ->{
            Presenter cls = new Presenter();
            cls.verifyEmail("test", label);
        },"Please Ensure Valid Email Inputted");
        Assertions.assertEquals("Please Ensure Valid Email Inputted",thrown.getMessage());
    }

    @Test
    public void emailFieldTest(){
        EmptyFieldException thrown = Assertions.assertThrows(EmptyFieldException.class,() ->{
            Presenter cls = new Presenter();
            cls.verifyEmail("",label);
        },"Please input something into email field");
        Assertions.assertEquals("Please input something into email field",thrown.getMessage());
    }
    }

