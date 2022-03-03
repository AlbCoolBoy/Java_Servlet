package com.example.Java_Servlet;

import javax.servlet.*;
import java.io.IOException;

public class Bservlet implements Servlet {
    public Bservlet(){
        System.out.println("Bservlet 无参构造执行了");
    }
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
