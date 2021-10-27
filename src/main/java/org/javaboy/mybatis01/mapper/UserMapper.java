package org.javaboy.mybatis01.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.javaboy.mybatis01.model.User;

import java.util.List;

public interface UserMapper {
    Integer addUser(User user);
    Integer leteUserById(int id);
    Integer updateUserById(User user);
    User getUserById(int id);
    List<User> getAllUser();
    List<User> getUserNameContains(String username);
    Integer updateUsernameById(String username , int id);
    Integer addUser2(@Param("z") User user);
}
