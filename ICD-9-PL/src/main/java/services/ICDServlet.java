package services;

import domain.Record;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Mariusz Szymanski
 */
@WebServlet(name = "ICDServlet", urlPatterns = "/classification")
public class ICDServlet extends HttpServlet {

    @Inject @Default
    ICDClient icdClient;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Record> classification = icdClient.getICDRecords();
        request.setCharacterEncoding("UTF-8");
        request.setAttribute("classification", classification);
        request.getRequestDispatcher("icd-9.jsp").forward(request, response);

    }
}
