import com.example.cs3318_assigment3.Exceptions.EmailException;
import com.example.cs3318_assigment3.HelloController;
import org.junit.Test;

public class EmailTests {

    @Test(expected = EmailException.class)
    public void emailTest() {
        HelloController cls = new HelloController();
        cls.verifyEmail("test");
    }
}
