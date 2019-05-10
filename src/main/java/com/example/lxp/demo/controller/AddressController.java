package com.example.lxp.demo.controller;

import com.example.lxp.demo.Service.AddressService;
import com.example.lxp.demo.Service.Imp.AddressServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController extends AddressServiceImp {
    @Autowired
    private AddressService adrs;
}
