package com.ruoyi.project.tool.gen.controller;

import com.ruoyi.project.tool.gen.mapper.HelloMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tao
 * @Date 2020/7/29
 * @Time 15:14
 */
@RestController
public class HelloController {

    @Autowired
    private HelloMapper helloMapper;



    @GetMapping("/hello")
    public String hello(){
        System.out.println(helloMapper.hello());
        System.out.println(helloMapper.hello2());
        return "Hello";
    }


}
