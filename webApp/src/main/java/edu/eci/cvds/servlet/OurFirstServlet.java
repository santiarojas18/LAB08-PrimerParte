package edu.eci.cvds.servlet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.*;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.eci.cvds.servlet.model.Todo;

@WebServlet(
        urlPatterns = "/OpenTheWindow"
)
public class OurFirstServlet extends HttpServlet{
	static final long serialVersionUID = 35L;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer responseWriter = resp.getWriter();
        int idSent = Integer.valueOf(req.getParameter("id"));
        try {
            Todo toDo = Service.getTodo(idSent);
            ArrayList<Todo> listTodo = new ArrayList<Todo>();
            listTodo.add(toDo);
            resp.setStatus(HttpServletResponse.SC_OK);
            responseWriter.write(Service.todosToHTMLTable(listTodo));
        } catch (Exception e) {
        	e.printStackTrace();
        	if (e instanceof FileNotFoundException) {
        		resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        		responseWriter.write(Service.itemDoesNotExistHTML(idSent));
        	} else if (e instanceof NumberFormatException) {
        		resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        	} else if (e instanceof MalformedURLException) {
        		resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        	} else {
        		resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);	
        	}
        	
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer responseWriter = resp.getWriter();
        int idSent = Integer.valueOf(req.getParameter("id"));
        try {
            Todo toDo = Service.getTodo(idSent);
            ArrayList<Todo> listTodo = new ArrayList<Todo>();
            listTodo.add(toDo);
            resp.setStatus(HttpServletResponse.SC_OK);
            responseWriter.write(Service.todosToHTMLTable(listTodo));
        } catch (Exception e) {
        	e.printStackTrace();
        	if (e instanceof FileNotFoundException) {
        		resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        		responseWriter.write(Service.itemDoesNotExistHTML(idSent));
        	} else if (e instanceof NumberFormatException) {
        		resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        	} else if (e instanceof MalformedURLException) {
        		resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        	} else {
        		resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);	
        	}
        	
        }
    }

}
