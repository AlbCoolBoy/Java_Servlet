package com.example.Java_Servlet01;

import com.example.Java_Servlet.GenericServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.awt.geom.GeneralPath;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class ServletContextTest03 extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html");
        PrintWriter writer = servletResponse.getWriter();


        //获取ServletContext中的配置信息
        ServletContext application=this.getServletConfig().getServletContext();
        Enumeration<String> initParameterNames = application.getInitParameterNames();
        while(initParameterNames.hasMoreElements()){
            String s = initParameterNames.nextElement();
            String value= getServletConfig().getInitParameter(s);
            writer.println(s+"   "+"value");
            writer.print("<br>");
        }
        
    }
}
