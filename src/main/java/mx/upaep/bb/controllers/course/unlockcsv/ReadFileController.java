package mx.upaep.bb.controllers.course.unlockcsv;

import com.google.gson.JsonObject;
import mx.upaep.bb.services.utils.file.LoadFileService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/readfile")
public class ReadFileController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LoadFileService readFile;

    public ReadFileController() {
        this.readFile = new LoadFileService();
    }
    /**
     *
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
     protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        processRequest(req, res);
    }

    /**
     *
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    private void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        JsonObject jsonFile = this.readFile.getContent(req);
        req.setAttribute("jsonObject", jsonFile);
        RequestDispatcher dispatcher = req.getRequestDispatcher("views/course/unlockcsv/file_csv_data.jsp");
        dispatcher.forward(req, res);
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }


}
