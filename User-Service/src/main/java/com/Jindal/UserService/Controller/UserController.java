package com.Jindal.UserService.Controller;

import com.Jindal.UserService.Entity.User;
import com.Jindal.UserService.Service.UserService;
import com.Jindal.UserService.VO.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService service;

//    Save User

@PutMapping("/")
    public User saveUser(@RequestBody User user){
      log.info("Inside saveUser of UserController");
        return service.saveUser(user);
    }
@GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(Long userId){
        log.info("Inside getUserWithDepartment of UserController");
    return service.getUserWithDepartment(userId);
    }


}