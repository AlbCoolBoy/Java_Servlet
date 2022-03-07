package com.example.Java_Servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class Using_GenericServlet extends GenericServlet{
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        ServletConfig servletConfig = this.getServletConfig();
        System.out.println(servletConfig);

    }
    //只要是继承类GenericServlet，之前的init方法还是会执行的
    //使用适配器进行改造使代码更加的简洁

}
