package src.dao;

import src.entity.User;

/**
 * Created by z on 2018/9/15.
 */
public interface IUserDAO {
    public boolean check(User user) throws Exception;
}
