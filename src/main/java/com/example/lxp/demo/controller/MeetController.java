package com.example.lxp.demo.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.lxp.demo.Service.AddressService;
import com.example.lxp.demo.Service.Imp.MeetServiceImp;
import com.example.lxp.demo.Service.MeetService;
import com.example.lxp.demo.Service.RoomService;
import com.example.lxp.demo.entity.Address;
import com.example.lxp.demo.entity.Meet;
import com.example.lxp.demo.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static com.sun.tools.doclint.Entity.and;

@RestController
public class MeetController extends MeetServiceImp {
    @Autowired
    private MeetService ms;
    @Autowired
    private RoomService rs;
    @Autowired
    private AddressService as;

    @RequestMapping(value ="/getMeets",method =RequestMethod.GET)
    public @ResponseBody
    List<MeetResult> getMeetList(){
        System.out.println("我执行了getMeets");
        List<Meet> meetList=new ArrayList<>();
        EntityWrapper<Meet> ew=new EntityWrapper<>();
        ew.orderBy("meet_id",true);
        meetList=ms.selectList(ew);
        System.out.println("meetList"+" "+meetList);
        List<MeetResult> meetResults=null;
        if(meetList!=null){//防止当没有正在进行的会议时，meetList为空导致出错
         meetResults=getMeetResults(meetList);
        }
        return meetResults;
    }
    @RequestMapping(value = "/getVideoURL",method = RequestMethod.POST)
    public @ResponseBody
    Address getAddress(@RequestBody Meet meet){
        Address address=new Address();
        EntityWrapper<Meet> meetEw=new EntityWrapper<>();
        meetEw.eq("meet_id",meet.getMeet_id());
        Meet resultMeet=new Meet();
        resultMeet=ms.selectOne(meetEw);
        System.out.println("getAddress");
        if(resultMeet!=null){
            System.out.println("resutMeet");
            int room_id;
            room_id=resultMeet.getMeet_room();
            EntityWrapper<Room> roomEw=new EntityWrapper<>();
            roomEw.eq("room_id",room_id);
            Room resultRoom=new Room();
            resultRoom=rs.selectOne(roomEw);
            /**视频位序号 ,**/
            int address_sit=-1;//-1代表房间状态为null
            int address_room;
            if(resultRoom!=null){
                /**视频位空闲状态 0:非空闲 1:空闲**/
                address_room=resultRoom.getRoom_id();
                if(resultRoom.getSit_first()==1){
                    address_sit=1;
                }else if(resultRoom.getSit_second()==1){
                    address_sit=2;
                }else if(resultRoom.getSit_third()==1){
                    address_sit=3;
                }else if(resultRoom.getSit_fourth()==1){
                    address_sit=4;
                }
                EntityWrapper<Address> addressEntityWrapper=new EntityWrapper<>();
                addressEntityWrapper.eq("address_room",address_room)
                                    .eq("address_sit",address_sit);
                address=as.selectOne(addressEntityWrapper);
                System.out.println("address_id: "+address.getAddress_id());
            }
        }
        return  address;
    }


    @RequestMapping(value = "/getPlayURL",method = RequestMethod.POST)
    public @ResponseBody
    List<Address> getPlayAddress(@RequestBody Meet meet){
        List<Address> addressList=new ArrayList<>();
        EntityWrapper<Meet> meetEw=new EntityWrapper<>();
        meetEw.eq("meet_id",meet.getMeet_id());
        Meet resultMeet=new Meet();
        resultMeet=ms.selectOne(meetEw);
        System.out.println("getPlayAddress");
        if(resultMeet!=null){
            System.out.println("resutMeet");
            int room_id;
            room_id=resultMeet.getMeet_room();
            EntityWrapper<Room> roomEw=new EntityWrapper<>();
            roomEw.eq("room_id",room_id);
            Room resultRoom=new Room();
            resultRoom=rs.selectOne(roomEw);
            /**视频位序号 ,**/
            int address_sit=-1;//-1代表房间状态为null
            int address_room;
            if(resultRoom!=null){
                /**视频位空闲状态 0:非空闲 1:空闲**/
                address_room=resultRoom.getRoom_id();
                EntityWrapper<Address> addressEntityWrapper=new EntityWrapper<>();
                addressEntityWrapper.eq("address_room",address_room);
                addressList=as.selectList(addressEntityWrapper);
                System.out.println("address_id: "+addressList);
            }
        }
        return  addressList;
    }

    public List<MeetResult> getMeetResults(List<Meet> meetList){
        List<MeetResult> meetResults=new ArrayList<>();
        for(Meet item:meetList){
            MeetResult meetResult=new MeetResult();
            meetResult.setMeet_id(item.getMeet_id());
            meetResult.setMeet_theme(item.getMeet_theme());
            meetResult.setTime_start(item.getTime_start());
            meetResult.setTime_end(item.getTime_end());
            meetResult.setMeet_room(item.getMeet_room());
            meetResult.setMeet_video(item.getMeet_video());
            meetResult.setTotal_size(item.getTotal_size());
            meetResult.setTrue_size(item.getTrue_size());
            meetResult.setMeet_summary(item.getMeet_summary());
            meetResult.setHost_user(item.getHost_user());
            meetResult.setSit_num(item.getSit_num());
            EntityWrapper<Room> roomEw=new EntityWrapper<>();
            roomEw.eq("room_id",item.getMeet_room());
            Room room=rs.selectOne(roomEw);
            System.out.println("meet_id: "+ room.getRoom_id()+" "+room.getRoom_type());
            meetResult.setMeet_type(room.getRoom_type());
            meetResults.add(meetResult);
        }
        return meetResults;
    }
}
 class MeetResult {

    private String meet_id;

    private String meet_theme;

    private Date time_start;

    private int meet_room;

    private Date time_end;

    private String meet_video;

    private int total_size;

    private int true_size;

    private String meet_summary;

    private String host_user;

    private int sit_num;

    private int meet_type;

    public void setMeet_type(int meet_type) {
        this.meet_type = meet_type;
    }

    public int getMeet_type() {
        return meet_type;
    }

    public void setMeet_id(String meet_id) {
        this.meet_id = meet_id;
    }

    public String getMeet_id() {
        return meet_id;
    }

    public void setMeet_theme(String meet_theme) {
        this.meet_theme = meet_theme;
    }

    public String getMeet_theme() {
        return meet_theme;
    }

    public void setTime_start(Date time_start) {
        this.time_start = time_start;
    }

    public Date getTime_start() {
        return time_start;
    }

    public void setMeet_room(int meet_room) {
        this.meet_room = meet_room;
    }

    public int getMeet_room() {
        return meet_room;
    }

    public void setTime_end(Date time_end) {
        this.time_end = time_end;
    }

    public Date getTime_end() {
        return time_end;
    }

    public void setMeet_video(String meet_video) {
        this.meet_video = meet_video;
    }

    public String getMeet_video() {
        return meet_video;
    }

    public void setTotal_size(int total_size) {
        this.total_size = total_size;
    }

    public int getTotal_size() {
        return total_size;
    }

    public void setTrue_size(int true_size) {
        this.true_size = true_size;
    }

    public int getTrue_size() {
        return true_size;
    }

    public void setMeet_summary(String meet_summary) {
        this.meet_summary = meet_summary;
    }

    public String getMeet_summary() {
        return meet_summary;
    }

    public void setHost_user(String host_user) {
        this.host_user = host_user;
    }

    public String getHost_user() {
        return host_user;
    }

    public void setSit_num(int sit_num) {
        this.sit_num = sit_num;
    }

    public int getSit_num() {
        return sit_num;
    }
}

