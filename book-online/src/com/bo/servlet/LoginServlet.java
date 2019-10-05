package com.bo.servlet;

import com.bo.entity.User;
import com.bo.service.UserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author mqxu
 * @date 2019.9.17
 * 登陆的请求响应
 */
@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理请求乱码
        req.setCharacterEncoding("UTF-8");
        //通过req请求参数获取前台表单的用户名参数
        String username = req.getParameter("account");
        //取得密码参数
        String password = req.getParameter("password");

        UserService userService = new UserService();

        // 获取用户列表数据（创建全局变量）
        ServletContext sc = this.getServletContext();
        List<User> userList = (List<User>) sc.getAttribute("userList");
        // 将数据传送到userService中
        userService.setUserList(userList);
        // 调用登录功能，得到用户对象
        User user = userService.signIn(username, password);

        //账号密码正确
        if (user != null) {
            //通过request对象获取session会话对象
            HttpSession session = req.getSession();
            //把用户名存入session对象
            session.setAttribute("user", user);
            //进行重定向跳转（客户端跳转）
            resp.sendRedirect("/index");
        }else {
            //账号或密码错误，跳转到登陆页面
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter write = resp.getWriter();
            write.print("<script>alert('登录失败');location.href='/login'</script>");
        }
    }
}