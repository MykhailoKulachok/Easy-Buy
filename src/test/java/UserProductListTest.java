/**
 * Created by misha on 04.06.2016.
 */
import com.devcolibri.EasyBuy.dao.ProductDao;
import com.devcolibri.EasyBuy.entity.Product;
import com.devcolibri.EasyBuy.service.UserProductListBean;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import com.devcolibri.EasyBuy.config.*;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {Initializer.class,
        WebAppConfig.class})
public class UserProductListTest {

    private MockMvc mockMvc;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }


    @Test
    public void testProductList() throws Exception{
        Product product1 = new Product("prod1", "man1", 1, 1);
        Product product2 = new Product("prod2", "man2", 2, 2);

        mockMvc.perform(post("/users/products").param("id", "1")).
                andDo(MockMvcResultHandlers.print()).andExpect(status().isOk());

        mockMvc.perform(get("/users/products")).
                andDo(MockMvcResultHandlers.print()).
                andExpect(status().isOk());
    }
}
