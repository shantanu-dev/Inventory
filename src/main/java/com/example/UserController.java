package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by shantanu on 9/8/16.
 */

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value="/userinsert" ,  method = RequestMethod.POST)
    void RoleInsert(@RequestBody Roles userRoles) {

        System.out.println(userRoles);
        userService.RoleInsert(userRoles);

    }


    @RequestMapping("/displayroles")
    public List<Roles> display() {
        return userService.RolesDisplay();
    }
}
