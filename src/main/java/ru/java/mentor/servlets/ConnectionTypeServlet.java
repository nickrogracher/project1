package ru.java.mentor.servlets;

import ru.java.mentor.util.PropertyReader;
import ru.java.mentor.util.ReaderException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class ConnectionTypeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String connectionType = req.getParameter("connectionType");
        try {
            PropertyReader.getInstance().setConnection(PropertyReader.read(connectionType));
        } catch (ReaderException e) {
            e.printStackTrace();
        }
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
