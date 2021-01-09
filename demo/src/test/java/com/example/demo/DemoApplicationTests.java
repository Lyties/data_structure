package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class DemoApplicationTests {

    // 继承了BaseMapper，所有的方法都来自己父类
    // 我们也可以编写自己的扩展方法！
    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        // 参数是一个 Wrapper ，条件构造器，这里我们先设置条件为空，查询所有。
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    void insert(){
        User user = new User();
        user.setName("kwhua_mybatis-plus_insertTest");
        user.setAge(15);
        user.setEmail("310697723@qq.com");

        int result = userMapper.insert(user); // 帮我们自动生成id
        System.out.println(result); // 受影响的行数
        System.out.println(user); // 看到id会自动填充。
    }

    @Test
    void update(){
        User user = new User();
        // 通过条件自动拼接动态sql
        user.setId(1346414134310776839L);
        user.setName("kwhua_mybatis-plus_updateTest");
        user.setAge(20);
        // 注意：updateById 但是参数是一个对象！
        int i = userMapper.updateById(user);
        System.out.println(i);
    }

    /**
     * OptimisticLockerInnerInterceptor
     */
    @Test
    void optimisticLocker(){
        // 1、查询用户信息
        User user = userMapper.selectById(1L);
        // 2、修改用户信息
        user.setName("kwhua");
        user.setEmail("123456@qq.com");
        // 3、执行更新操作
        userMapper.updateById(user);
    }

    /**
     * --------------------------
     */

    // 测试乐观锁失败！多线程下
    @Test
    public void testOptimisticLocker2(){

        // 线程 1
        User user = userMapper.selectById(1L);
        user.setName("kwhua111");
        user.setEmail("123456@qq.com");

        // 模拟另外一个线程执行了插队操作
        User user2 = userMapper.selectById(1L);
        user2.setName("kwhua222");
        user2.setEmail("123456@qq.com");
        userMapper.updateById(user2);

        // 自旋锁来多次尝试提交！
        userMapper.updateById(user); // 如果没有乐观锁就会覆盖插队线程的值！
    }


    /**
     * ---------------------------
     */

    // 测试查询
    @Test
    public void testSelectById(){
        User user = userMapper.selectById(1L);
        System.out.println(user);
    }

    // 测试批量查询！
    @Test
    public void testSelectByBatchId(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);
    }

    // 按条件查询之一使用map操作
    @Test
    public void testSelectByBatchIds(){
        Map<String, Object> map = new HashMap<>();
        // 自定义要查询
        map.put("name","kwhua");
        map.put("age",15);

        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }


    // 测试分页查询
    @Test
    public void testPage(){
        // 参数一：当前页
        // 参数二：页面大小
        Page<User> page = new Page<>(2,5);
        userMapper.selectPage(page,null);
        page.getRecords().forEach(System.out::println);
        System.out.println(page.getTotal());
    }


    // 测试删除
    @Test
    public void testDeleteById(){
        userMapper.deleteById(1L);
    }

    // 通过id批量删除
    @Test
    public void testDeleteBatchId(){
        userMapper.deleteBatchIds(Arrays.asList(2L,3L));
    }

    // 通过map删除
    @Test
    public void testDeleteMap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","kwhua");
        userMapper.deleteByMap(map);
    }

    // 逻辑删除
    @Test
    public void deleteById(){
        userMapper.deleteById(1346414134310776842L);
    }


    @Test
    void textWrapper(){
// 查询name不为空的用户，并且邮箱不为空的用户，年龄大于等于12
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .isNotNull("name") //不为空
                .isNotNull("email")
                .ge("age",18);
        userMapper.selectList(wrapper).forEach(System.out::println); // 和我们刚才学习的map对比一下
    }
    @Test
    void testWrapper(){
        // 查询名字kwhua
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name","kwhua");
        User user = userMapper.selectOne(wrapper); // 查询一个数据用selectOne，查询多个结果使用List 或者 Map
        System.out.println(user);
    }

    @Test
    public void testSelect() {
        User user = userMapper.selectById(5);
        System.out.println(user.toString());
    }




}
