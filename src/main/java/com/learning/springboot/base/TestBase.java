package com.learning.springboot.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    //新建测试基类 此类为所有测试类的父类
    public Properties pro;
    //读取配置文件  把读取配置文件的操作卸载构造方法中  我也不知道为什么(摊手 可能这样 效率比较高
    public TestBase()  {
        pro = new Properties();
        try {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir")//获取当前工程目录
                    + "/src/main/resources/application.yml");//获取config.properties文件目录
            pro.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
