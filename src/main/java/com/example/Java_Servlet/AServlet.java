package com.example.Java_Servlet;

import javax.servlet.*;
import java.io.IOException;

public class AServlet implements Servlet {

    public AServlet(){
        System.out.println("Aservlet 无参构造执行了");
        //底层会将wen.xml中的请求路径和servlet放进一个Map集合中，并不是在启动的时候就创建所有的servlet对象
        //如果想要在服务启动的时候就创建servlet对象的话，就在<servlet>标签中添加
        //<load-on-startup>0</load-on startup> 中间的数字越小，创建的优先级越高
        //一般情况下不会使用启动创建
    }
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("Aservlet's init method  executed!");

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Aservlet's service method executed!");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        //这个方法很少使用
        //通常再该方法中，进行资源的关闭，马上对象就要销毁了，还有什么没有关闭的，抓紧时间关闭资源
        //没有保存到的数据抓紧保存
        System.out.println("Aservlet's service method executed!");
    }
}

//默认情况下，服务器启动的时候并不会实例化Aservelt对象
//用户发送第一次请求的时候就会实例化这个对象，并且执行的是无参构造方法
//对象被实例化后，立即调用了init方法和service方法
//用户再次访问的时候，服务器不会创建新的对象，而是直接使用之前实例化好的对象

//Servlet规范中又要求，ajvaweb程序员再编写Servlet类的时候，不建议手动编写构造方法
//因为这样很容易让无参构造方法消失，这个操作可能会导致Servlet对象无法实例化