import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.infosys.datacollect.Application;
import com.infosys.datacollect.service.InstanceService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class InstanceTest {

    @Autowired
    private MockMvc mock;

    @Autowired
    private InstanceService service;

    private static final Logger log = LoggerFactory.getLogger(InstanceTest.class);

    @Test
    public void testSelectAll() throws Exception {

        log.info("testing selectAll()....");

        List all = service.findAll(1);

        assertNotNull("failure - List is null", all);
    }

    @Test
    public void testAddInstance() throws Exception {
        log.info("testing testAddInstance()....");
    }

    @Test
    public void testFindOne() throws Exception {
        String url = "/v1/instance/current/1";
        mock.perform(get(url))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content()
                    .string(containsString("test")));
    }
    
    
}
