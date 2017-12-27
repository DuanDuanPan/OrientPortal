
package com.orient.portal.controller;

import org.pac4j.cas.client.rest.CasRestFormClient;
import org.pac4j.cas.profile.CasProfile;
import org.pac4j.cas.profile.CasRestProfile;
import org.pac4j.core.context.J2EContext;
import org.pac4j.core.credentials.TokenCredentials;
import org.pac4j.core.profile.ProfileManager;
import org.pac4j.core.profile.jwt.JwtClaims;
import org.pac4j.jwt.credentials.authenticator.JwtAuthenticator;
import org.pac4j.jwt.profile.JwtGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.DateUtils;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@RestController
@CrossOrigin(value = "*")
public class IndexController {

    @Autowired
    private JwtGenerator generator;

    @Autowired
    private CasRestFormClient casRestFormClient;

    @Value("${cas.serviceUrl}")
    private String serviceUrl;

    @Autowired
    JwtAuthenticator jwtAuthenticator;

    @GetMapping("/")
    public Object index() {
        return "index page";
    }

    @RequestMapping("/login")
    public Object login(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> model = new HashMap<>();
        J2EContext context = new J2EContext(request, response);
        final ProfileManager<CasRestProfile> manager = new ProfileManager(context);
        final Optional<CasRestProfile> profile = manager.get(true);
        //获取ticket
        TokenCredentials tokenCredentials = casRestFormClient.requestServiceTicket(serviceUrl, profile.get(), context);
        //根据ticket获取用户信息
        final CasProfile casProfile = casRestFormClient.validateServiceTicket(serviceUrl, tokenCredentials, context);
        Calendar now = DateUtils.createNow();
        now.add(Calendar.MINUTE, 5);
//        casProfile.addAttribute("exp", now.getTime());
        //生成jwt token
        String token = generator.generate(casProfile);
        model.put("token", token);
        return new HttpEntity<>(model);
    }

    @GetMapping("/token/detail")
    public Map<String, String> getTokenDetail(String token) {
        Map<String, String> retVal = new HashMap<>();
        Map<String, Object> claims = jwtAuthenticator.validateTokenAndGetClaims(token);
        String userName = (String) claims.get(JwtClaims.SUBJECT);
        if (!StringUtils.isEmpty(userName)) {
            retVal.put("userName", userName);
        }
        return retVal;
    }
}
