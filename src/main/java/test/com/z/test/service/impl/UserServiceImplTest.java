package test.com.z.test.service.impl;

import com.z.test.pojo.User;
import com.z.test.service.IUserService;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * UserServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>03/28/2017</pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserServiceImplTest {

    @Resource
    private IUserService userService;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getUserById(Long userId)
     */
    @Test
    public void testGetUserById() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: addUser(User user)
     */
    @Test
    @Transactional   //标明此方法需使用事务
    @Rollback(false)  //标明使用完此方法后事务不回滚,true时为回滚
    public void testAddUser() throws Exception {
//TODO: Test goes here...
        User user = new User();
        user.setPassword("password");
        user.setUsername("username");
        userService.addUser(user);
    }

    /**
     * Method: findByUsername(String username)
     */
    @Test
    public void testFindByUsername() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: login(User user)
     */
    @Test
    public void testLogin() throws Exception {
//TODO: Test goes here... 
    }


} 
