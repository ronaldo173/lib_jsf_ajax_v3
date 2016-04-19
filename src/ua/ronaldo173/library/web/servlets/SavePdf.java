package ua.ronaldo173.library.web.servlets;

import ua.ronaldo173.library.web.controllers.BookListController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Developer on 19.04.2016.
 */
@WebServlet(name = "SavePdf", urlPatterns = {"/SavePdf"})
public class SavePdf extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        prosessRequest(req, resp);
    }

    private void prosessRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/pdf");

        OutputStream out = resp.getOutputStream();

        try {
            int id = Integer.valueOf(req.getParameter("id"));
            BookListController bookListController = (BookListController) req.getSession(false).getAttribute("bookListController");
            byte[] content = bookListController.getContent(id);
            resp.setHeader("Content-Disposition", "attachment;filename=file.pdf");
            out.write(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
