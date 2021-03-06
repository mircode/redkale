/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.redkale.test.http;

import java.io.*;
import java.net.*;
import java.nio.charset.*;
import java.util.*;
import org.redkale.convert.json.*;
import org.redkale.net.http.*;

/**
 *
 * @author zhangjx
 */
public interface HttpRequestDesc {

    //获取请求方法 GET、POST等
    public String getMethod();

    //获取协议名 http、https、ws、wss等
    public String getProtocol();

    //获取Host的Header值
    public String getHost();

    //获取请求内容的长度, 为-1表示内容长度不确定
    public long getContentLength();

    //获取Content-Type的header值
    public String getContentType();

    //获取Connection的Header值
    public String getConnection();

    //获取客户端地址IP
    public SocketAddress getRemoteAddress();

    //获取客户端地址IP, 与getRemoteAddres() 的区别在于：本方法优先取header中指定为RemoteAddress名的值，没有则返回getRemoteAddres()的getHostAddress()。
    //本方法适用于服务前端有如nginx的代理服务器进行中转，通过getRemoteAddres()是获取不到客户端的真实IP。
    public String getRemoteAddr();

    //获取请求内容指定的编码字符串
    public String getBody(Charset charset);

    //获取请求内容的UTF-8编码字符串
    public String getBodyUTF8();

    //获取文件上传对象
    public MultiContext getMultiContext();

    //获取文件上传信息列表 等价于 getMultiContext().parts();
    public Iterable<MultiPart> multiParts() throws IOException;

    //获取sessionid
    public String getSessionid(boolean autoCreate);

    //更新sessionid
    public String changeSessionid();

    //使sessionid失效
    public void invalidateSession();

    //获取所有Cookie对象
    public java.net.HttpCookie[] getCookies();

    //获取Cookie值， 没有返回默认值
    public String getCookie(String name, String defaultValue);

    //获取Cookie值
    public String getCookie(String name);

    //获取请求的URL
    public String getRequestURI();

    //截取getRequestURI最后的一个/后面的部分
    public String getRequstURILastPath();

    //从prefix之后截取getRequestURI再对"/"进行分隔
    public String[] getRequstURIPaths(String prefix);

    //获取请求URL分段中含prefix段的long值
    // 例如请求URL /pipes/record/query/time:1453104341363/id:40
    // 获取time参数: long time = request.getRequstURIPath("time:", 0L);
    public long getRequstURIPath(String prefix, long defaultValue);

    //获取请求URL分段中含prefix段的int值
    // 例如请求URL /pipes/record/query/offset:2/limit:50
    // 获取page参数: int offset = request.getRequstURIPath("offset:", 1);
    // 获取size参数: int limit = request.getRequstURIPath("limit:", 20);
    public int getRequstURIPath(String prefix, int defaultValue);

    //获取请求URL分段中含prefix段的值
    //例如请求URL /pipes/record/query/name:hello
    //获取name参数: String name = request.getRequstURIPath("name:", "none");
    public String getRequstURIPath(String prefix, String defaultValue);

    // 获取请求URL分段中含prefix段的short值
    // 例如请求URL /pipes/record/query/type:10
    // 获取type参数: short type = request.getRequstURIPath("type:", (short)0);
    public short getRequstURIPath(String prefix, short defaultValue);

    //获取所有的header名
    public String[] getHeaderNames();

    // 获取指定的header值
    public String getHeader(String name);

    //获取指定的header值, 没有返回默认值
    public String getHeader(String name, String defaultValue);

    //获取指定的header的json值
    public <T> T getJsonHeader(JsonConvert convert, Class<T> clazz, String name);

    //获取指定的header的json值
    public <T> T getJsonHeader(Class<T> clazz, String name);

    //获取指定的header的boolean值, 没有返回默认boolean值
    public boolean getBooleanHeader(String name, boolean defaultValue);

    // 获取指定的header的short值, 没有返回默认short值
    public short getShortHeader(String name, short defaultValue);

    //获取指定的header的int值, 没有返回默认int值
    public int getIntHeader(String name, int defaultValue);

    // 获取指定的header的float值, 没有返回默认float值
    public float getFloatHeader(String name, float defaultValue);

    // 获取指定的header的long值, 没有返回默认long值
    public long getLongHeader(String name, long defaultValue);

    //获取指定的header的double值, 没有返回默认double值
    public double getDoubleHeader(String name, double defaultValue);

    //获取所有参数名
    public String[] getParameterNames();

    //获取指定的参数值
    public String getParameter(String name);

    //获取指定的参数值, 没有返回默认值
    public String getParameter(String name, String defaultValue);

    //获取指定的参数json值
    public <T> T getJsonParameter(JsonConvert convert, Class<T> clazz, String name);

    //获取指定的参数json值
    public <T> T getJsonParameter(Class<T> clazz, String name);

    //获取指定的参数boolean值, 没有返回默认boolean值
    public boolean getBooleanParameter(String name, boolean defaultValue);

    //获取指定的参数short值, 没有返回默认short值
    public short getShortParameter(String name, short defaultValue);

    //获取指定的参数int值, 没有返回默认int值
    public int getIntParameter(String name, int defaultValue);

    //获取指定的参数float值, 没有返回默认float值
    public float getFloatParameter(String name, float defaultValue);

    //获取指定的参数long值, 没有返回默认long值
    public long getLongParameter(String name, long defaultValue);

    //获取指定的参数double值, 没有返回默认double值
    public double getDoubleParameter(String name, double defaultValue);

    //获取HTTP上下文对象
    public HttpContext getContext();

    //获取所有属性值, servlet执行完后会被清空
    public Map<String, Object> getAttributes();

    //获取指定属性值
    public <T> T getAttribute(String name);

    //删除指定属性
    public void removeAttribute(String name);

    //设置属性值
    public void setAttribute(String name, Object value);

    //获取request创建时间
    public long getCreatetime();
}
