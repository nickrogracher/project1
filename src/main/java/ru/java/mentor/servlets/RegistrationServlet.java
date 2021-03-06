package ru.java.mentor.servlets;

import ru.java.mentor.model.User;
import ru.java.mentor.service.UserService;
import ru.java.mentor.util.PropertyReader;
import ru.java.mentor.util.ReaderException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private final String page = "/WEB-INF/view/registration.jsp";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.getRequestDispatcher(PropertyReader.read("registration")).forward(request, response);
        } catch (ReaderException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String name = req.getParameter("name");
        final String password = req.getParameter("pass");
        User user = new User(name, password);
        UserService.getInstance().addUser(user);
        resp.sendRedirect("/login");
    }
}
