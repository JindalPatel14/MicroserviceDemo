package com.Jindal.UserService.Service;

import com.Jindal.UserService.Entity.User;
import com.Jindal.UserService.Repository.UserRepository;
import com.Jindal.UserService.VO.Department;
import com.Jindal.UserService.VO.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository Repo;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser of UserService");
        return Repo.save(user);
    }


    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment  of UserService");
        ResponseTemplateVO vo=new ResponseTemplateVO();
        User user = Repo.getReferenceById(userId);

        Department department= restTemplate.getForObject(" http://localhost:8081/departments/" +
                user.getDepartmentId(),Department.class);
        vo.setUser(user);
        vo.setDepartment(department);

   return vo;
    }
}
