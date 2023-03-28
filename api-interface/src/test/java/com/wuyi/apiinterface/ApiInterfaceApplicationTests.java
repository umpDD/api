package com.wuyi.apiinterface;

import com.wuyi.apiclientsdk.client.ApiClient;
import com.wuyi.apiclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ApiInterfaceApplicationTests {

    @Resource
    private ApiClient apiClient;

    @Test
    void contextLoads() {
        String result = apiClient.getNameByGet("wuyi");
        String result2 = apiClient.getNameByPost("wuyi");
        User user = new User();
        user.setUsername("wuyiYao");
        String result3 = apiClient.getUserByPost(user);
        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);


    }

}
