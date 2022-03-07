package com.example.Java_Servlet01;

import com.example.Java_Servlet.GenericServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServlertContextTest05 extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //向应用域中添加数据
        servletResponse.setContentType("text/html");
        PrintWriter writer = servletResponse.getWriter();

        ServletContext servletContext = this.getServletConfig().getServletContext();

        User user=new User("jack","123456");
        servletContext.setAttribute("userObj",user);
        Object userObj = servletContext.getAttribute("userObj");

        writer.print(userObj);
    }
}
