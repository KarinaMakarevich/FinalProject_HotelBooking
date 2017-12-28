package by.epam.makarevich.controller;

import by.epam.makarevich.command.AbstractCommand;
import by.epam.makarevich.factory.CommandFactory;
import by.epam.makarevich.request_content.RequestContent;
import by.epam.makarevich.type.RouterType;
import by.epam.makarevich.util.Router;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MainController", urlPatterns = "/mainController")
public class MainController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AbstractCommand abstractCommand;
        RequestContent requestContent = new RequestContent();
        requestContent.extractValues(request);
        abstractCommand = new CommandFactory().initializeCommand(requestContent);
        Router router = abstractCommand.execute(requestContent);
        requestContent.insertValues(request);
        if (RouterType.FORWARD.equals(router.getType())) {
            request.getRequestDispatcher(router.getPath()).forward(request, response);
        } else if (RouterType.REDIRECT.equals(router.getType())) {
            response.sendRedirect(router.getPath());
        } else {
            response.sendRedirect(router.getPath());
        }
    }
}