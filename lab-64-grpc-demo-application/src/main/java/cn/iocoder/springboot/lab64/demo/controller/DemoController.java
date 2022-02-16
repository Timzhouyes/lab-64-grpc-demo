package cn.iocoder.springboot.lab64.demo.controller;

import cn.iocoder.springboot.lab64.userservice.api.UserCreateRequest;
import cn.iocoder.springboot.lab64.userservice.api.UserCreateResponse;
import cn.iocoder.springboot.lab64.userservice.api.UserGetRequest;
import cn.iocoder.springboot.lab64.userservice.api.UserGetResponse;
import cn.iocoder.springboot.lab64.userservice.api.UserServiceGrpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private UserServiceGrpc.UserServiceBlockingStub userServiceGrpc;

    @GetMapping("/get")
    public String get(@RequestParam("id") Integer id) {
        UserGetRequest request = UserGetRequest.newBuilder().setId(id).build();
        UserGetResponse response = userServiceGrpc.get(request);
        return response.getName();
    }

    @GetMapping("/create")
    public Integer create(@RequestParam("name") String name,
                          @RequestParam("gender") Integer gender) {
        UserCreateRequest request = UserCreateRequest.newBuilder().setName(name)
            .setGender(gender).build();
        UserCreateResponse response = userServiceGrpc.create(request);
        return response.getId();
    }
}
