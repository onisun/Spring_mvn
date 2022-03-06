import com.onisun.ta.service.BookService;
import com.onisun.ta.service.impl.BookServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author Neo
 * @version 1.0
 */
public class MyTest01 {
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);

    @Test
    public void test01(){
       BookService bookService = context.getBean("bookServiceImpl", BookService.class);
       bookService.CheckOut("zhangsan",1);
    }

}
