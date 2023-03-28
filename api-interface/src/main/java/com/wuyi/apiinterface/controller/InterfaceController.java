package com.wuyi.apiinterface.controller;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.wuyi.apiclientsdk.model.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


/**
 * 名称接口
 */
@RestController
@RequestMapping("/inv")
public class InterfaceController {


    @GetMapping("/name/get")
    public String getNameByGet(String name){
        return "Get your name:" + name;
    }

    @PostMapping("/name/post")
    public String getNameByPost(@RequestBody User user){
        return "Post your name:" + user.getUsername();
    }

    @PostMapping("/name/user")
    public String getUserByPost(@RequestBody User user){
        return "POST 用户名字是" + user.getUsername();

    }

    @GetMapping("/dygirl")
    public String getdyGirlGet(){
        Map<String,String> map= new HashMap<>();
        map.put("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36 Edg/111.0.1661.44");
        HttpResponse httpResponse = HttpRequest.get("https://zj.v.api.aa1.cn/api/video_dyv2")
                .addHeaders(map)
                .execute();
        String location = httpResponse.header("Location");
        HttpResponse httpResponse1 = HttpRequest.get(location).execute();
        return httpResponse1.body();
    }

    @GetMapping("/pcgirl")
    public String getpcGirlGet(){
        Map<String,String> map= new HashMap<>();
        map.put("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36 Edg/111.0.1661.44");
        HttpResponse httpResponse = HttpRequest.get("https://v.api.aa1.cn/api/api-dy-girl/index.php?aa1=json")
                .addHeaders(map)
                .execute();
        return httpResponse.body();
    }

}
