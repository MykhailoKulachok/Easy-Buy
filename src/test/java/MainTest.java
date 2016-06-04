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
public class MainTest {
    private MockMvc mockMvc;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private UserProductListBean userProductListBean;


    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }


    //@Test
    public void testDirectives() throws Exception {
        mockMvc.perform(get("/directives/login")).
                //andDo(MockMvcResultHandlers.print()).
                andExpect(status().isOk());
    }

    //@Test
    public void testDataBaseInsert() throws Exception{

        Product product = new Product();
        product.setCount(10);
        product.setManufacturer("man1");
        product.setPrice(100.1);
        product.setTitle("prod1");
        productDao.saveProduct(product);
    }

    //@Test
    public void testDataBaseGet() throws Exception {
        Product product = productDao.getProduct(1);
        System.out.println(product);
        Assert.assertNotEquals(null, product);


        List<Product> products = productDao.getProducts();
        System.out.println(product);
        Assert.assertNotEquals(null, product);
    }

    @Test
    public void testUserList() throws Exception {

    }

}