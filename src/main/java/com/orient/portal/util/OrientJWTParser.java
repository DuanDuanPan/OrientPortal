/**
 * @Project Name :  portal
 * @Package Name :  com.orient.portal.util
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2017-12-22 3:44 PM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.orient.portal.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author :  panduanduan
 * @Description :  解析token
 * @Creation Date:  2017-12-22 3:44 PM
 */
@Component
public class OrientJWTParser {

    @Value("${jwt.salt}")
    private String salt;

}