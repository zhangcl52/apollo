package com.hunter.common.util;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

/**
 * Created by lianjia on 2016/6/1.
 */
public class ConfPropertiesUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConfPropertiesUtils.class);
    private static Properties properties;

    private synchronized static void loadProperties() {
        properties = new Properties();
        InputStream stream = ConfPropertiesUtils.class.getClassLoader().getResourceAsStream("conf_" + EnvHelper.getEnv() + ".properties");
        try {
            properties.load(stream);
        } catch (Exception e){
            LOGGER.error("ConfPropertiesUtils error", e);
        }finally {
            if (stream != null)
                try {
                    stream.close();
                } catch (IOException e) {
                }
        }
    }

    private ConfPropertiesUtils(){
    }

    public static String getProperty(String key){
        Preconditions.checkArgument(StringUtils.isNotBlank(key), "Param key must be not null or empty");
        if(properties == null){
            loadProperties();
        }
        String property = properties.getProperty(key);
        if(StringUtils.isBlank(property)){
            throw new IllegalArgumentException("变量" + key + "无法获取对应property,请检查对应的properties配置文件");
        }
        return property;
    }

    public static String getProperty(String key, String def){
        Preconditions.checkArgument(StringUtils.isNotBlank(key), "Param key must be not null or empty");
        if(properties == null){
            loadProperties();
        }
        String property = properties.getProperty(key);
        if(StringUtils.isBlank(property)){
            return def;
        }
        return property;
    }

    public static boolean updateProValue(String path, String key, String value){
        Properties prop = new Properties();// 属性集合对象
        FileInputStream fis;
        try {
            fis = new FileInputStream(path);
            prop.load(fis);// 将属性文件流装载到Properties对象中
            fis.close();// 关闭流
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
        prop.setProperty(key, value);
        try {
            FileOutputStream fos = new FileOutputStream(path);// 文件输出流
            prop.store(fos, "config Properties");// 将Properties集合保存到流中
            fos.close();// 关闭流
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public static boolean isDEV(){
       return StringUtils.equals(EnvHelper.getEnv(),EnvHelper.ENV_DEV);
    }
    public static boolean isTEST(){
       return StringUtils.equals(EnvHelper.getEnv(),EnvHelper.ENV_TEST);
    }
    public static boolean isVRF(){
       return StringUtils.equals(EnvHelper.getEnv(),EnvHelper.ENV_VRF);
    }
    public static boolean isPRO(){
       return StringUtils.equals(EnvHelper.getEnv(),EnvHelper.ENV_PRO);
    }

}
