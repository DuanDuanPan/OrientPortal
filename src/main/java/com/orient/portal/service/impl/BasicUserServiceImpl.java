/**
 * @Project Name :  portal
 * @Package Name :  com.orient.service.impl
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2017-12-22 10:13 AM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.orient.portal.service.impl;

import com.orient.portal.domain.BasicUser;
import com.orient.portal.service.BasicUserService;
import com.orient.portal.typehandler.BasicUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author :  panduanduan
 * @Description :
 * @Creation Date:  2017-12-22 10:13 AM
 */
@Service
@Transactional(rollbackFor = {Throwable.class})
public class BasicUserServiceImpl implements BasicUserService {

    @Autowired
    private BasicUserMapper basicUserMapper;

    @Override
    public BasicUser getUserByUserName(String userName) {
        return basicUserMapper.findByUserName(userName);
    }
}