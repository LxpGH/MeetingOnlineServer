package com.example.lxp.demo.Service.Imp;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.lxp.demo.Service.UserService;
import com.example.lxp.demo.dao.UserDao;
import com.example.lxp.demo.entity.User;
import org.springframework.web.bind.annotation.RestController;


public class UserServiceImp extends ServiceImpl<UserDao,User> implements UserService {

}
