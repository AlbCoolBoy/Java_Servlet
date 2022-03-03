package com.example.Java_Servlet;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class HelloServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest Request, ServletResponse Response) throws ServletException, IOException {
        //将获取的数据直接打印到浏览器中
        Response.setContentType("text/html");
        PrintWriter out=Response.getWriter();


        //进行一下数据库的操作
        Connection  connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/sql_store";
            String user="root";
            String password="smt020528";

            connection= DriverManager.getConnection(url,user,password);
            String sql_statement="select * from customers";
            preparedStatement=connection.prepareStatement(sql_statement);
            resultSet= preparedStatement.executeQuery();


            while(resultSet.next()){
                String customer_id= resultSet.getString(1);
                String first_name=resultSet.getString(2);
                String last_name=resultSet.getString(3);

                out.println("customer: "+customer_id+" first_name: "+first_name+" last_name: "+last_name+"<br>");
                out.println("<br>");


            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(resultSet!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
