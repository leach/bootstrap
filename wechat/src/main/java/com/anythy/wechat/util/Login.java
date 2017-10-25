package com.anythy.wechat.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Leach on 0027 2017/9/27.
 */
public class Login {
    private String iamgeImg= Login.class.getResource("/").getPath().toString() + "qrcode";
    String redirect_uri="";
    CloseableHttpClient https = HttpClients.createDefault();

    public static void main(String[] args) {
        System.setProperty ("jsse.enableSNIExtension", "false");
        Login login = new Login();
        login.initPage();
        String uuid = login.getPng1();
        login.getPng2(uuid);
    }
    public void initPage(){
        HttpGet httpPost=new HttpGet("https://wx.qq.com/");
        String html="";
        try {
            HttpResponse response = https.execute(httpPost);
            HttpEntity entitySort = response.getEntity();
            html= EntityUtils.toString(entitySort, "utf-8");
            //System.out.println(html);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 下载二维码之获取参数
     */
    public String getPng1()
    {
        String url = "https://login.wx.qq.com/jslogin?appid=wx782c26e4c19acffb&redirect_uri=https%3A%2F%2Fwx.qq.com%2Fcgi-bin%2Fmmwebwx-bin%2Fwebwxnewloginpage&fun=new&lang=zh_CN&_="+System.currentTimeMillis();
               url = "https://login.wx.qq.com/jslogin?appid=wx782c26e4c19acffb&redirect_uri=https%3A%2F%2Fwx.qq.com%2Fcgi-bin%2Fmmwebwx-bin%2Fwebwxnewloginpage&fun=new&lang=zh_CN&_="+System.currentTimeMillis();
        HttpGet httpPost=new HttpGet(url);
        String html="";
        try {
            HttpResponse response = https.execute(httpPost);
            HttpEntity entitySort = response.getEntity();
            html=EntityUtils.toString(entitySort, "utf-8");
            System.out.println(html);
            if(html.indexOf("window.QRLogin.code = 200")!=-1)
            {
                return html.replace("window.QRLogin.code = 200; window.QRLogin.uuid = \"", "").replace("\";", "");
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 下载二维码
     * @param uuid
     * @return
     */
    public void getPng2(String uuid)
    {
        String url="https://login.weixin.qq.com/qrcode/"+uuid;
        HttpGet httpget = new HttpGet(url);
        System.out.println("获取二维码：Executing request " + httpget.getURI());//开始
        String html="";
        FileOutputStream fos;
        try {
            HttpResponse response = https.execute(httpget);
            System.out.println(response.getStatusLine());
            InputStream inputStream = response.getEntity().getContent();
            File file = new File(this.iamgeImg);
            if (!file.exists()) {
                file.mkdirs();
            }
            fos = new FileOutputStream(iamgeImg + "\\test.jpg");
            byte[] data = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(data)) != -1) {
                fos.write(data, 0, len);
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(html);
    }
}
