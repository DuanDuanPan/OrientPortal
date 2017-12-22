/**
 * @Project Name :  portal
 * @Package Name :  com.orient.portal.mapper
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2017-12-22 9:58 AM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.orient.portal.mapper;

import com.orient.portal.domain.BasicUser;
import com.orient.portal.typehandler.BasicUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author :  panduanduan
 * @Description :  单元测试--测试
 * @Creation Date:  2017-12-22 9:58 AM
 */
@RunWith(SpringRunner.class)
@MybatisTest
public class BasicUserMapperTest {

    @Autowired
    private BasicUserMapper basicUserMapper;

    @Test
    public void findByStateTest() {
        BasicUser user = basicUserMapper.findByUserName("guest1");
        System.err.println(user);
    }
}