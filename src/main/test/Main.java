import com.iloooo.controller.AjaxController;
import com.iloooo.utils.UpdateFileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.annotation.ApplicationScope;

import javax.servlet.ServletContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml" )
@Transactional(transactionManager="transactionManager")
public class Main {
    private static final org.springframework.web.context.ContextLoader ContextLoader = new ContextLoader();

    @Test
    public void main() {
        System.out.println(UpdateFileUtils.getFileSuffix("asf.asfsadf.safsadf.doc"));
    }
}
