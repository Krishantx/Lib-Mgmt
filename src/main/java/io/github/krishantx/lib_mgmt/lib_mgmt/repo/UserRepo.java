package io.github.krishantx.lib_mgmt.lib_mgmt.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import io.github.krishantx.lib_mgmt.lib_mgmt.models.User;

@Repository
public class UserRepo {
    @Autowired
    private JdbcTemplate jdbc;

    public void addUser(User user) {
        String sql = "insert into users" + 
        "(first_name, last_name, email_id, password)" + 
        "values (?, ?, ?, ?)";
        jdbc.update(
            sql, 
            user.getFirstName(), 
            user.getLastName(), 
            user.getEmailId(), 
            user.getPassword()
        );
    }

    public void updateUser(User user) {
        String sql = "update users " +
        "set first_name = ?, " +
        "last_name = ?, " +   
        "email_id = ?, " +  
        "password = ? " +
        "where user_id = ?";
        try {
            jdbc.update(sql, user.getFirstName(), user.getLastName(), user.getEmailId(), user.getPassword(), user.getUserId());    
        } catch (Exception e) {
            System.out.println("Exception : " + e);
        }    
    }

    public void deleteUser(int userId) {
        String sql = "delete from users where user_id = ?";
        jdbc.update(sql, userId);
    }

    public User getUser(int userId) {
        String sql = "select * from users where user_id = " + userId;


        List<User> users = jdbc.query(sql, new RowMapper<>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setEmailId(rs.getString("email_id"));
                user.setPassword(rs.getString("password"));
                user.setUserId(rs.getInt("user_id"));
                return user;
            }
        });
        if (users.size() == 0) {
            return null;
        }
        return users.get(0);
    }

    public List<User> getAllUsers() {
        String sql = "select * from users";
        List<User> allUsers = jdbc.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setEmailId(rs.getString("email_id"));
                user.setPassword(rs.getString("password"));
                user.setUserId(rs.getInt("user_id"));
                return user;
            }
        });
        return allUsers;
        
    }
}
