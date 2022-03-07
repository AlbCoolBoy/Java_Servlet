package com.example.Java_Servlet01;

import com.example.Java_Servlet.GenericServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletContextTest04 extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //动态获取项目的根路径
        ServletContext servletContext = this.getServletConfig().getServletContext();
        String root_path=servletContext.getContextPath();

        servletResponse.setContentType("text/html");
        PrintWriter writer = servletResponse.getWriter();

        writer.write(root_path);

    }
}
