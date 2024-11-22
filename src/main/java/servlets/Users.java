package servlets;

import com.parking.parkinglot.ejb.UserBean;
import common.UserDto;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Users", value = "/Users")
public class Users extends HttpServlet {

    @Inject
    private UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<UserDto> users = userBean.findAllUsers();


        req.setAttribute("users", users);


        req.getRequestDispatcher("/WEB-INF/pages/users.jsp").forward(req, resp);
    }
}
