package src.impl;

import src.dao.IUserDAO;
import src.entity.User;
import src.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by z on 2018/9/15.
 */
public class UserDAOImpl implements IUserDAO {

    @Override
    public boolean check(User user) throws Exception{
        boolean result = false;
        Connection conn = null;
        try{
            conn = ConnectionManager.getConn();
            PreparedStatement ps = conn.prepareStatement("select * from user where name = ? and password = ?");
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                user.setId(rs.getInt("id"));
                result = true;
            }
        }finally {
            ConnectionManager.closeConn(conn);
        }
        return result;
    }
}
