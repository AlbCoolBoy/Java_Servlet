package com.example.Java_Servlet01;

import com.example.Java_Servlet.GenericServlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class ConfigTestServlet extends GenericServlet {
    @Override
    /*ServletConfig
    * 1.ServletConfig是什么：是Servlet规范中的一员，也是一个接口
    * 2.这个接口由Tomcat实现
    * 3.Servlet对象和ServletConfig是一一对应的，一个Servlet对象就对应着一个ServletConfig */

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        ServletConfig servletConfig = this.getServletConfig();
        System.out.println(servletConfig);
        servletResponse.setContentType("text/html");
        PrintWriter writer = servletResponse.getWriter();
        writer.println("ServletConfig对象是："+servletConfig);
        writer.println("<br>");

        //通过ServletConfig对象中的两个方法能够获取到web.xml文件中关于该对象的配置信息
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        while(initParameterNames.hasMoreElements()){
            String s = initParameterNames.nextElement();
            writer.print(s+"<br>");
        }
        writer.print("<br>");
        String user=servletConfig.getInitParameter("user");
        writer.println("user: "+user+"<br");
        String url=servletConfig.getInitParameter("url");
        writer.print("url: "+url+"<br>");
        String password=servletConfig.getInitParameter("password");
        writer.println("passwoord: "+password+"<br>");
        //通过上述方法获取web.xml配置文件中的信息

        //实际上也可以不通过实例化config来获取配置信息，可以直接通过this来获取


    }
}
