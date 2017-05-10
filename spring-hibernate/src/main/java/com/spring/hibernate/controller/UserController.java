package com.spring.hibernate.controller;

import com.spring.hibernate.domain.DO.User;
import com.spring.hibernate.domain.VO.LoginUser;
import com.spring.hibernate.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by siyong.xu on 2017-05-05.
 */
@RequestMapping("/user")
@Controller
public class UserController {
    private Logger log = LogManager.getLogger(this.getClass());

    @Resource
    UserService userService;

    @RequestMapping(value = "/index")
    public String index() {
        return "/login";
    }

    @RequestMapping(value = "/login")
    public String login(LoginUser loginUser) {
        User user = new User();
        user.setUserName(loginUser.getUsername());
        user.setPwd(loginUser.getPassword());
        User user1 = userService.queryById(111);

        List<User> backusers = userService.findListByExample(user);
        if (backusers == null || backusers.size() < 1) {
            return "/loginError";
        }

        return "/loginSuc";
    }
}
