package com.bo.service;

import com.bo.entity.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mqxu
 * @date 2019.9.20
 * 图书服务类
 */
public class BookService {
    private static List<Book> bookList;

    public static List<Book> init() {
        bookList = new ArrayList<>(10);
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
        bookList = Arrays.asList(books);
        return bookList;
    }
}