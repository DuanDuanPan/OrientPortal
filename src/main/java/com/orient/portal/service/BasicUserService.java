/**
 * @Project Name :  portal
 * @Package Name :  com.orient.service
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2017-12-22 10:11 AM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.orient.portal.service;

import com.orient.portal.domain.BasicUser;

/**
 * @author :  panduanduan
 * @Description :  数据库查询用户接口
 * @Creation Date:  2017-12-22 10:11 AM
 */
public interface BasicUserService {

    /**
     * 根据用户名获取用户信息
     *
     * @param userName
     * @return
     */
    BasicUser getUserByUserName(String userName);
}
