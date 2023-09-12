package com.learning.springboot.tests;

import com.alibaba.fastjson.JSONObject;
import com.learning.springboot.base.TestBase;
import com.learning.springboot.restClient.RestClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;


public class GetTest01 extends TestBase {
    TestBase testBase;
    RestClient restClient;
    String host;
    String url;
    CloseableHttpResponse response;
    @BeforeClass
    public void setUp(){
        testBase = new TestBase();
        host = testBase.pro.getProperty("HOST");//读取config.properties里面的根url
        url = host + "/api/users?page=2"; //进入https://reqres.in/ 网站下拉 有Get/Post/Put方法测试的说明文档
    }
    @Test
    public void getListUsers() throws IOException {
        restClient = new RestClient();
        response = restClient.getApi(url);
        //获取响应内容
        String responseString = EntityUtils.toString(response.getEntity(),"UTF-8");
        //创建JSON对象  把得到的响应字符串 序列化成json对象
        JSONObject responseJson = JSONObject.parseObject(responseString);
        System.out.println("response json---->" + responseJson);
    }
}
