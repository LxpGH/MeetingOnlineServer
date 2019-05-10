package com.example.lxp.demo.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.lxp.demo.Service.Imp.RoomServiceImp;
import com.example.lxp.demo.Service.RoomService;
import com.example.lxp.demo.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RoomController extends RoomServiceImp {
    @Autowired
    private RoomService rs;
    @RequestMapping(value = "/getRoomType",method = RequestMethod.POST)
public @ResponseBody Room getRoom_type(@RequestBody Room room){
    EntityWrapper<Room> roomEntityWrapper=new EntityWrapper<>();
    roomEntityWrapper.eq("room_id",room.getRoom_id());
    Room room1;
    room1=rs.selectOne(roomEntityWrapper);
    System.out.println("room_id "+room.getRoom_id()+"room_type "+room1.getRoom_type());
    return room1;
}
}
