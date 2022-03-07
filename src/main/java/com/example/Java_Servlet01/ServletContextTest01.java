package com.example.Java_Servlet01;

import com.example.Java_Servlet.GenericServlet;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

//通过ServletConfig对象获取ServletContext对象
//ServletContext对象实在服务器启动的时候由WEB服务器创建的
//对于一个webapp来说，只有一个ServletContext
//该对象在服务器关闭的时候销毁
public class ServletContextTest01 extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        servletResponse.setContentType("text/html");
        PrintWriter writer = servletResponse.getWriter();


        ServletConfig config=this.getServletConfig();
        ServletContext appplication = config.getServletContext();

        writer.println(appplication);


    }
}
