package org.javaboy;

import org.apache.ibatis.session.SqlSession;
import org.javaboy.mybatis01.mapper.BookMapper;
import org.javaboy.mybatis01.mapper.UserMapper;
import org.javaboy.mybatis01.model.BookUser;
import org.javaboy.mybatis01.model.User;
import org.javaboy.mybatis01.utils.SqlSessionFactoryUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.UUID;

public class MyTest {
    private SqlSession sqlSession;
    private BookMapper bookMapper;

    @Before
    public void before(){
        sqlSession = SqlSessionFactoryUtils.getInstance().openSession();
        bookMapper = sqlSession.getMapper(BookMapper.class);
    }

    @Test
    public void addUser(){
        User user = new User();
        user.setUsername("itboy");
        user.setAddress("www.itboyhub.com");
//        user.setId(UUID.randomUUID().toString());
        int insert = sqlSession.insert("org.javaboy.mybatis01.mapper.UserMapper.addUser",user);
        System.out.println("insert = " + insert);
        sqlSession.commit();
    }

    @Test
    public void deleteUserId(){
        int delete = sqlSession.delete("org.javaboy.mybatis01.mapper.UserMapper.deleteUserById", 1);
        sqlSession.commit();
        System.out.println("delete = " + delete);
    }

    @Test
    public void updateUserId(){
        User user = new User();
        user.setId(3);
        user.setUsername("log4j");
        int update = sqlSession.update("org.javaboy.mybatis01.mapper.UserMapper.updateUserById",user);
        sqlSession.commit();
        System.out.println("update = " + update);
    }

    @Test
    public void getUserId(){
        User user = sqlSession.selectOne("org.javaboy.mybatis01.mapper.UserMapper.getUserById", 3);
        System.out.println("user = " + user);
    }

    @Test
    public void getUserById2(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById(4);
        System.out.println("user = " + user);
    }

    @Test
    public void getAllUser(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> allUser = userMapper.getAllUser();
        for (User user : allUser) {
            System.out.println(user);
        }
    }

    @Test
    public void getUserNameContains(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userNameContains = mapper.getUserNameContains("boy");
        for (User userNameContain : userNameContains) {
            System.out.println(userNameContain);
        }
    }

    @Test
    public void updateUsernameById(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Integer itboy123 = mapper.updateUsernameById("itboy123", 1);
        System.out.println(itboy123);
        sqlSession.commit();
    }

    @Test
    public void addUser2(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(15);
        user.setUsername("ra");
        user.setAddress("sdsda.ddsd");
        Integer integer = mapper.addUser2(user);
        System.out.println(integer);
    }

    @Test
    public void getAllBook(){
        List<BookUser> allBook = bookMapper.getAllBook();
        for (BookUser bookUser : allBook) {
            System.out.println(bookUser);
        }
    }

    @Test
    public void getBookByNameOrAuthor(){
        BookUser bookUser1 = new BookUser(123,"zyy",2);
        List<BookUser> author = bookMapper.getBookByNameOrAuthor(bookUser1);
        for (BookUser bookUser : author) {
            System.out.println(bookUser);
        }
    }

    @Test
    public void updateBook(){
        BookUser user = new BookUser(1, "zs", 123);
        Integer book = bookMapper.updateBook(user);
        System.out.println(book);
        sqlSession.commit();
    }
    @After
    public void after(){
        sqlSession.close();
    }
}
