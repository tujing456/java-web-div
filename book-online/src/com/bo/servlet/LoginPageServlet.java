package com.bo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author suyuxi
 * @className LoginPageServlet
 * @Description TODO
 * @Date 2019/10/4
 * @Version 1.0
 **/
@WebServlet(urlPatterns = "/login")
public class LoginPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.getRequestDispatcher("login.html").forward(req,resp);

    }
}
