package services;

import domain.Classification;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Mariusz Szymanski
 */
@WebServlet(name = "ICDServlet", urlPatterns = "/classification", loadOnStartup = 1, asyncSupported = true)
public class ICDServlet extends HttpServlet {

    @Inject
    private ICDBuilder icdBuilder;
    private Classification classification;

    @Override
    public void init() throws ServletException {
        classification = icdBuilder.getAllClassification();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        request.setAttribute("classification", classification);
        request.getRequestDispatcher("icd-9.jsp").forward(request, response);
    }
}
