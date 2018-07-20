import cn.gmluo.bebetterme.model.User;
import cn.gmluo.bebetterme.service.IUserService;
import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Project: ssmbebetterme
 * Package: PACKAGE_NAME
 *
 * @author : gmluo1988
 * @date : 2018/7/19 15:49
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestMyBatis {
    private static Logger logger = Logger.getLogger(TestMyBatis.class);

    @Resource(name = "userService")
    private IUserService userService = null;


    @Test
    public void test() {
        User user = userService.getUserByID(126);
        System.out.println(user.getUsername());
        // logger.info("值："+user.getUserName());
        logger.info(JSON.toJSONString(user));
    }

    @Test
    public void selectAllUsersTest() {
        List<User> userList = userService.selectAllUsers();
        for (User u : userList) {
            System.out.println(u);
            logger.info(JSON.toJSONString(u));
        }
    }
}
