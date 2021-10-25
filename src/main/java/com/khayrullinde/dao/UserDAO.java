package com.khayrullinde.dao;

import com.khayrullinde.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

// т.к. можно обойтись готовым роу мапером - обошелся им, этот просто попробовал сделать
@Component
public class UserDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> index() {
        return jdbcTemplate.query("SELECT * FROM userAbout", new BeanPropertyRowMapper<>(User.class));
    }

    public User showUser(int id) {
        return jdbcTemplate.query("select * from userAbout where id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(User.class))
                .stream().findAny().orElse(null);
    }

    public void save(User user) {
        jdbcTemplate.update("insert into userAbout (name, email, age) values (?, ?, ?)",
                user.getName(), user.getEmail(), user.getAge());

    }

    public void update(int id, User updatedUser) {
        jdbcTemplate.update("update userAbout set name = ?, email = ?, age = ? where id = ?",
                updatedUser.getName(), updatedUser.getEmail(), updatedUser.getAge(), id);
    }

    public void delete(int id) {
       jdbcTemplate.update("delete from userAbout where id = ?", id);
    }
}
