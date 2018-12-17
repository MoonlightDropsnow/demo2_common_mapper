package com.baizhi;

import com.baizhi.entity.User;
import com.baizhi.entity.UserExample;
import com.baizhi.mapper.UserMapper;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        User user = new User();
        user.setType(1);
        List<User> select = userMapper.select(user);
        for (User user1 : select) {
            System.out.println(user1);
        }
    }

    @Test
    public void testSelectAll() {
        List<User> users = userMapper.selectAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testSelectByPrimaryKey() {
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println(user);
    }

    @Test
    public void testSelectCount() {
        User user = new User();
        user.setType(1);
        int i = userMapper.selectCount(user);
        System.out.println(i);
    }

    @Test
    public void testInsert() {
        User user = new User(null, "jack2", "123321", 1);
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

    @Test
    public void testInsertSelective() {
        User user = new User(null, "jack3", "321123", 0);
        int i = userMapper.insertSelective(user);
        System.out.println(i);
    }

    @Test
    public void testUpdateByPrimaryKey() {
        User user = new User(5, "jack1", "321123", 0);
        int i = userMapper.updateByPrimaryKey(user);
        System.out.println(i);
    }

    @Test
    public void test() {
        RowBounds rowBounds = new RowBounds(3, 3);
        List<User> users = userMapper.selectByExampleAndRowBounds(new UserExample(), rowBounds);
        for (User user : users) {
            System.out.println(user);
        }
    }


}
