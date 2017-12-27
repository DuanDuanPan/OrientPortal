/**
 * @Project Name :  portal
 * @Package Name :  com.orient.portal.controller
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2017-12-23 3:29 PM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.orient.portal.controller;

import com.orient.portal.domain.BasicUser;
import com.orient.portal.service.BasicUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description  :  基础用户
 * @author       :  panduanduan
 * @Creation Date:  2017-12-23 3:29 PM
 */
@RestController
@CrossOrigin(value = "*")
public class UserController {

    @Autowired
    private BasicUserService basicUserService;

    @GetMapping("/user")
    public Map<String, String> detail(HttpServletRequest request) {
        Map<String, String> retVal = new HashMap<>();
        retVal.put("user", request.getUserPrincipal().getName());
        return retVal;
    }

    @GetMapping("/user/{userName}")
    public BasicUser detail(@PathVariable String userName) {
        return basicUserService.getUserByUserName(userName);
    }

//    @GetMapping("/user/{id}")
//    @RequiresRoles("aRoleName")
//    public Object user(@PathVariable(value = "id") String id) {
//        return "users page:" + id;
//    }
}