package com.khayrullinde.dao;

import com.khayrullinde.models.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {

        User user = new User();
        user.setName(resultSet.getString("name"));
        user.setId(resultSet.getInt("id"));
        user.setAge(resultSet.getInt("age"));
        user.setEmail(resultSet.getString("email"));

        return user;
    }
}
