import com.iloooo.utils.CONSTANTS;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.ContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(inheritLocations=true,locations = "/WEB-INF/applicationContext.xml")
@Transactional(transactionManager="transactionManager")
public class Main {
    private static final org.springframework.web.context.ContextLoader ContextLoader = new ContextLoader();
    @Value("jdbc.password")public String aaa;

    @Test
    public void main() {
        System.out.println(aaa);

    }
}
