package org.javaboy.mybatis01.model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.javaboy.mybatis01.utils.SqlSessionFactoryUtils;
//使用UserMapper可替换此代码,此代码废弃!
public class UserDao {
    private SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getInstance();
    public Integer addUser(User user){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int insert = sqlSession.insert("org.javaboy.mybatis01.mapper.UserMapper.addUser",user);
        sqlSession.commit();
        System.out.println("insert = " + insert);
        sqlSession.close();
        return insert;
    }
    public Integer deleteUserById(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int delete = sqlSession.delete("org.javaboy.mybatis01.mapper.UserMapper.deleteUserById", id);
        sqlSession.commit();
        sqlSession.close();
        return delete;
    }
    public void updateUserById(User user){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("org.javaboy.mybatis01.mapper.UserMapper.updateUserById",user);
        sqlSession.commit();
        sqlSession.close();
        sqlSession.close();
    }
}
