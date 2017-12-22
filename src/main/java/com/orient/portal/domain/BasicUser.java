/**
 * @Project Name :  portal
 * @Package Name :  com.orient.domain
 * @Description :
 * @author :  panduanduan
 * @Creation Date:  2017-12-22 9:48 AM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 * Pan       2017-12-22 init
 */
package com.orient.portal.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author :  panduanduan
 * @Description :基础平台用户表mybatis映射类
 * @Creation Date:  2017-12-22 9:48 AM
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BasicUser implements Serializable {

    private Long id;

    private String userName;

    private String allName;
}