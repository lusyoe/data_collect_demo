import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.infosys.datacollect.Application;
import com.infosys.datacollect.utils.CommonUtils;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class CommonUtilsTest {

    @Test
    public void testIsEmpty() throws Exception {
        String str = " ";
        boolean result = CommonUtils.isEmpty(str);
        
        assertTrue("str应该为空: " + str, result);
    }
}
