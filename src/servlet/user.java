package servlet;

import src.dao.IUserDAO;
import src.entity.User;
import src.util.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by z on 2018/10/8.
 */
@WebServlet(name = "user")
public class user extends HttpServlet {

    private IUserDAO userDao = DaoFactory.getUserDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if("show".equals(action)) {
            show(request,response);
        } else {
            show(request,response);
        }
    }

    private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受客户端提交数据
        //进行服务器端数据检查
        //调用java bean 完成业务处理
        try {
            List<User> ulist = userDao.getByPage();
            //根据返回结果决定跳转页面
            request.setAttribute("userlist",ulist);
            request.getRequestDispatcher("show.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

}
