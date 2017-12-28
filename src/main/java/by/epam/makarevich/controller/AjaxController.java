package by.epam.makarevich.controller;

import by.epam.makarevich.command.AbstractCommand;
import by.epam.makarevich.factory.CommandFactory;
import by.epam.makarevich.request_content.RequestContent;
import com.google.gson.JsonObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AjaxController", urlPatterns = "/ajaxController")
public class AjaxController extends HttpServlet {
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
        abstractCommand.execute(requestContent);
        requestContent.insertValues(request);
        JsonObject json = requestContent.getJsonObject();
        response.getWriter().println(json.toString());
        response.getWriter().close();
    }

}
