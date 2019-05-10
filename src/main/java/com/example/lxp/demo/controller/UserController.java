package com.example.lxp.demo.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.lxp.demo.Service.Imp.UserServiceImp;
import com.example.lxp.demo.Service.UserService;
import com.example.lxp.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController extends UserServiceImp {
    @Autowired
    private UserService us;
    @RequestMapping(value = "/login",method =RequestMethod.POST)
    public @ResponseBody
    String Login(@RequestBody User user){
    User cUser;
    EntityWrapper<User> userEntityWrapper=new EntityWrapper<>();
    /**userEntityWrapper只是一个实体条件封装器，没有操作数据库功能，仍需用Service调用才能查询**/
    cUser=us.selectOne(userEntityWrapper.eq("user_id",user.getUser_id()));
    System.out.println(cUser);
    boolean is_allow=false;
    if(cUser!=null){
        if(cUser.getPassword().equals(user.getPassword())){
            System.out.println(cUser.getPassword());
            is_allow=true;
        }
    }
        JSONObject resultJson=new JSONObject();
        try {
            resultJson.put("result",is_allow);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return resultJson.toString();
    }
}

