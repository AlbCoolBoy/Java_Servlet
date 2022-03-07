package com.example.Java_Servlet;

import javax.servlet.*;
import java.io.IOException;

public abstract class GenericServlet implements Servlet {
    private ServletConfig config;

    @Override
    public final void init(ServletConfig servletConfig) throws ServletException {
        this.config=servletConfig;
        this.init();

    }
    public void init(){

    }
    //这样子类依然能够重写init()方法并且不会修改原来的代码

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public abstract void service(ServletRequest servletRequest, ServletResponse servletResponse)
            throws ServletException, IOException;


    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
