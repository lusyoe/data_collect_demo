import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.infosys.datacollect.Application;
import com.infosys.datacollect.dao.InstanceTypeMapper;
import com.infosys.datacollect.domain.InstanceView;
import com.infosys.datacollect.domain.InstanceType;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class InstanceTypeTest {

    @Autowired
    private InstanceTypeMapper mapper;
    
    
    private static final Logger log = LoggerFactory.getLogger(InstanceTypeTest.class);

    @Test
    public void testSelectAll() throws Exception {
        
        List<InstanceType> all = mapper.selectAll();
        
        for (InstanceType i : all) {
            log.debug("InstanceType: " + i); 
        }
    }
}
