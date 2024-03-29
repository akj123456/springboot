package com.learning.springboot.restClient;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class RestClient {
    //本类中包含post get put delete请求方法
    //1 get请求 不带请求头
    /**
     *
     * @param url  请求地址
     * @return
     * @throws IOException
     */
    public CloseableHttpResponse getApi(String url) throws IOException {
        //新建一个可关闭的HTTPclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //新建get对象
        HttpGet get = new HttpGet(url);

        //执行 get请求  存储返回的响应
        CloseableHttpResponse httpResponse = httpClient.execute(get);
        return httpResponse;
    }
    //2 get请求 带有请求头 方法重载
    public CloseableHttpResponse getApi(String url , HashMap<String,String> headermap) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        //加载请求头到HTTP中
        for (Map.Entry<String, String> entry : headermap.entrySet()) {
            httpGet.addHeader(entry.getKey(),entry.getValue());
        }
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
        return httpResponse;
    }
    /**
     *
     * @param url
     * @param entityString 设置json 请求参数
     * @param headermap 请求头
     * @return
     * @throws IOException
     */
    //3 post请求
    public CloseableHttpResponse postApi(String url, String entityString, HashMap<String,String> headermap) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        //设置payload
        httpPost.setEntity(new StringEntity(entityString));
        //加载请求头对象到 httppost
        for (Map.Entry<String,String> entry : headermap.entrySet()){
            httpPost.addHeader(entry.getKey(),entry.getValue());
        }
        //发送post请求
        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
        return httpResponse;
    }
    //4 Put方法
    public CloseableHttpResponse put(String url, String entityString, HashMap<String,String> headerMap) throws ClientProtocolException, IOException {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPut httpput = new HttpPut(url);
        httpput.setEntity(new StringEntity(entityString));
        for(Map.Entry<String, String> entry : headerMap.entrySet()) {
            httpput.addHeader(entry.getKey(), entry.getValue());
        }
        //发送put请求
        CloseableHttpResponse httpResponse = httpclient.execute(httpput);
        return httpResponse;
    }
    //5 Delete方法
    public CloseableHttpResponse delete(String url) throws ClientProtocolException, IOException {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpDelete httpdel = new HttpDelete(url);
        //发送put请求
        CloseableHttpResponse httpResponse = httpclient.execute(httpdel);
        return httpResponse;
    }

}
