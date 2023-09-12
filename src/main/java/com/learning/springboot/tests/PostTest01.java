package com.learning.springboot.tests;

import com.alibaba.fastjson.JSON;

import com.alibaba.fastjson.JSONObject;
import com.learning.springboot.base.TestBase;
import com.learning.springboot.restClient.RestClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import com.learning.springboot.utils.getJsonValueUtil;

import javax.xml.namespace.QName;

public class PostTest01 {
    TestBase testBase;
    RestClient restClient;
    String host;
    String url;
    CloseableHttpResponse response;

    @BeforeClass
    public void setUp(){
        testBase = new TestBase();
        host = testBase.pro.getProperty("HOST");//读取config.properties里面的根url
        url = host + "/getList"; //进入https://reqres.in/ 网站下拉 有Get/Post/Put方法测试的说明文档
        System.out.println("-----------------------------------------------------------------------"+url);
    }
    @Test
    public void postCreate() throws IOException {
        restClient = new RestClient();
        //准备请求头信息
        HashMap<String,String> headermap = new HashMap<String, String>();
        headermap.put("Content-Type","application/json");

        //实例化数据对象 并将其转换成json格式
        String dataJsonString = "";
        //post请求
        response = restClient.postApi(url,dataJsonString,headermap);
        //得到响应结果 并输出
        String responseString = EntityUtils.toString(response.getEntity());
        System.out.println(responseString);
        //添加断言
        int statusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode,200,"网页成功响应");

        System.out.println("response---->" + responseString);
    }
}
