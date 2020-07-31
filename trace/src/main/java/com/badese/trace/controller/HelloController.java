package com.badese.trace.controller;


import com.badese.common.entity.LoginResult;
import com.badese.trace.mapper.HelloMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Tao
 * @Date 2020/7/29
 * @Time 15:14
 */
@RestController
public class HelloController {

    @Autowired
    private HelloMapper helloMapper;

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/hello")
    public String hello(){
        System.out.println(helloMapper.hello());
        System.out.println(helloMapper.hello2());
        return "Hello";
    }

    @Value("${api.admin.login}")
    private String adminUrl;


    @GetMapping("/hello2")
    public LoginResult getPayment() {
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
        paramMap.add("username", "admin");
        paramMap.add("password", "admin123");
        paramMap.add("rememberMe",false);

        return restTemplate.postForObject(adminUrl, paramMap,LoginResult.class);

    }
}
