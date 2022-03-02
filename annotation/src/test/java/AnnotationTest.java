import com.onisun.controller.PersonController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Neo
 * @version 1.0
 */
public class AnnotationTest {


    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        PersonController personController = context.getBean("personController", PersonController.class);
        personController.getPerson();
        Object obj = context.getBean("personService222");
        System.out.println(obj);
    }
}
