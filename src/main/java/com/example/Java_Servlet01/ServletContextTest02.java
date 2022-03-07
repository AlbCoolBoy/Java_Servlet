package com.example.Java_Servlet01;

import com.example.Java_Servlet.GenericServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletContextTest02 extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html");
        PrintWriter writer = servletResponse.getWriter();

        ServletContext servletContext = this.getServletConfig().getServletContext();
        writer.println(servletContext);
    }
}
