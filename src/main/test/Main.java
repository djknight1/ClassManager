import com.iloooo.utils.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.ContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "classpath:WEB-INF/applicationContext.xml")
@Transactional(transactionManager="transactionManager")
public class Main {
    private static final org.springframework.web.context.ContextLoader ContextLoader = new ContextLoader();

    @Test
    public void main() {
        System.out.println(FileUtils.getFileSuffix("asf.asfsadf.safsadf.doc"));
    }
}
