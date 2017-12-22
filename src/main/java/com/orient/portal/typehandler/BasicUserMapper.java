/**
 * @Project Name :  portal
 * @Package Name :  com.orient.typehandler
 * @Description :
 * @author :  panduanduan
 * @Creation Date:  2017-12-22 9:54 AM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.orient.portal.typehandler;

import com.orient.portal.domain.BasicUser;
import org.apache.ibatis.annotations.*;

/**
 * @author :  panduanduan
 * @Description :  mybatis 操作接口
 * @Creation Date:  2017-12-22 9:54 AM
 */
@Mapper
public interface BasicUserMapper {

    @Select("select * from cwm_sys_user where user_name = #{userName}")
//    @Results({
//            @Result(property = "id", column = "id"),
//            @Result(property = "userName", column = "user_name"),
//            @Result(property = "allName", column = "all_name"),
//    })
    BasicUser findByUserName(@Param("userName") String userName);
}
