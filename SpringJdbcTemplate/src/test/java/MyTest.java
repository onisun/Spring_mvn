import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Neo
 * @version 1.0
 */
public class MyTest {

    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    DruidDataSource dataSource = context.getBean("dataSource", DruidDataSource.class);
    JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
    @Test
    public void test01() throws SQLException {
        //批量插入数据
        String sql = "insert into employee(id,user_name) values(?,?)";
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[]{1,"张三"});
        list.add(new Object[]{2,"李四"});
        list.add(new Object[]{3,"王五"});
        list.add(new Object[]{4,"赵六"});
        int[] ints = jdbcTemplate.batchUpdate(sql, list);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    @Test
    public void test02() throws SQLException {
        //查询单条记录
        String sql = "select * from employee where id = 3";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
    }
}
