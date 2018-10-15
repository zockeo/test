package src.impl;

import org.apache.commons.beanutils.BeanUtils;
import src.dao.IUserDAO;
import src.entity.User;
import src.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
            PreparedStatement ps = conn.prepareStatement("select * from user left join role on user.role_id = role.id where user.username = ? and user.password = ?");
//            PreparedStatement ps = conn.prepareStatement("select user.id,user.username,role.name from user left join role on user.role_id = role.id where user.username = ? and user.password = ?");
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                User temp = this.getBean(rs);
                BeanUtils.copyProperties(user,temp);
                result = true;
            }
            rs.close();
            ps.close();
        }finally {
            ConnectionManager.closeConn(conn);
        }
        return result;
    }

    @Override
    public List<User> getByPage() throws Exception {
        List<User> res = new ArrayList<User>();
        Connection conn = null;
        try{
            conn = ConnectionManager.getConn();
            PreparedStatement ps = conn.prepareStatement("select * from user left join role on user.role_id = role.id");
//            PreparedStatement ps = conn.prepareStatement("select user.id,user.username,role.name,role.description from user left join role on user.role_id = role.id");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User temp = this.getBean(rs);
                res.add(temp);
            }
            rs.close();
            ps.close();
        }finally {
            ConnectionManager.closeConn(conn);
        }
        return res;
    }

    private User getBean(ResultSet rs) throws Exception {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.getRole().setId(rs.getInt("id"));
        user.getRole().setName(rs.getString("name"));
        user.getRole().setDesc(rs.getString("description"));
        return user;
    }

}
