
package com.bo.listener;

import com.bo.entity.Book;
import com.bo.entity.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author suyuxi
 * @className ContextLoaderListener
 * @Description TODO
 * @Date 2019/9/29
 * @Version 1.0
 **/


//监视Tomcat
@WebListener
public class ContextLoaderListener implements ServletContextListener {
    /**
     * @param sce
     * @Description 容器初始化方法
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("容器启动");
        //创建并生成用户数据列表
        List<User> userList = new ArrayList<>(3);
        User[] users = {
                new User(1, "aaa@qq.com", "698d51a19d8a121ce581499d7b701668", "苏洛", "login (1).jpg", "重庆", LocalDate.of(2019, 1, 1)),
                new User(2, "bbb@qq.com", "bcbe3365e6ac95ea2c0343a2395834dd", "十年", "login (2).jpg", "江苏", LocalDate.of(2019, 2, 2)),
                new User(3, "ccc@qq.com", "310dcbbf4cce62f762a2aaa148d556bd", "我的名字", "login (3).jpg", "山西", LocalDate.of(2019, 3, 3))
        };
        //创建并生成图书数据列表
        List<Book> bookList = new ArrayList<>(10);
        Book[] books = {
                new Book(1, "我和我的祖国", "book1.jpg", "[中国大陆]陈凯歌"),
                new Book(2, "攀登者", "book2.jpg", "[中国大陆]李仁港"),
                new Book(3, "中国机长", "book3.jpg", "[中国大陆]刘伟强"),
                new Book(4, "双子杀手", "book4.jpg", "[美国]李安"),
                new Book(5, "犯罪现场", "book5.jpg", "[中国香港]冯志强"),
                new Book(6, "雪人奇缘", "book6.jpg", "[美国，中国大陆]吉尔.卡尔顿  托德.维尔德曼"),
                new Book(7,"哪吒之魔童降世","book7.jpg","[中国大陆]饺子"),
                new Book(8,"沉默的证人","book8.jpg","[英国]兰尼.哈尼"),
                new Book(9,"烈火英雄","book9.jpg","[中国大陆]陈国辉"),
                new Book(10,"流浪地球","book10.jpg","[中国大陆]郭帆")
        };
        userList = Arrays.asList(users);
        bookList = Arrays.asList(books);
        //获得全局变量
        ServletContext servletContext = sce.getServletContext();
        //设置全局变量属性，将用户和图书列表数据记入，整个应用可以共享
        servletContext.setAttribute("userList", userList);
        servletContext.setAttribute("bookList", bookList);
        /**
         * 销毁方法
         *          * @param sce
         */

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        System.out.println("容器销毁");
    }
}
