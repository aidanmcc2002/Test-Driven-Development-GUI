import com.example.cs3318_assigment3.Exceptions.EmailException;
import com.example.cs3318_assigment3.Exceptions.SpecialCharException;
import com.example.cs3318_assigment3.HelloController;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class EmailTests {

    @Test
    public void emailTest() {
        EmailException thrown = Assertions.assertThrows(EmailException.class,() ->{
            HelloController cls = new HelloController();
            cls.verifyEmail("test");
        },"Please Ensure Valid Email Inputted");
        Assertions.assertEquals("Please Ensure Valid Email Inputted",thrown.getMessage());
    }
}
