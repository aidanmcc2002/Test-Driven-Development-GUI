import com.example.cs3318_assigment3.Exceptions.EmailException;
import com.example.cs3318_assigment3.Presenter;
import org.junit.Test;
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
}
