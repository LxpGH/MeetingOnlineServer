package com.example.lxp.demo.Service;

import com.baomidou.mybatisplus.service.IService;
import com.example.lxp.demo.Service.Imp.UserServiceImp;
import com.example.lxp.demo.entity.User;
import org.springframework.web.bind.annotation.RestController;


public interface UserService extends IService<User> {

}
