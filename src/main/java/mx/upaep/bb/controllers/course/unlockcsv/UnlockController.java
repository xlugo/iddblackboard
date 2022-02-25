package mx.upaep.bb.controllers.course.unlockcsv;

import com.google.gson.JsonObject;
import mx.upaep.bb.services.course.unlockcsv.DesbloquearCurso;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/unlockcourse")
public class UnlockController extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        processRequest(req, res);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        JsonObject jsonObjCourseUnblock= new JsonObject();

        DesbloquearCurso dc = new DesbloquearCurso();
        JsonObject jsonObjectCourse  = dc.setCourseRowStatus(req);
        jsonObjCourseUnblock.add("course", jsonObjectCourse);
        JsonObject jsonObjectEnrollment = dc.setEnrollmentRowStatus(jsonObjectCourse.get("bbobjectid").getAsString(), jsonObjectCourse.get("coursebatchuid").getAsString());
        jsonObjCourseUnblock.add("enrollment", jsonObjectEnrollment);
        JsonObject jsonObjectPerson = dc.setPersonRowStatus(jsonObjectEnrollment.get("person").getAsJsonArray());
        jsonObjCourseUnblock.add("person", jsonObjectPerson);
        req.setAttribute("jsonObject", jsonObjCourseUnblock);
        RequestDispatcher dispatcher = req.getRequestDispatcher("views/course/unlockcsv/result_data.jsp");
        dispatcher.forward(req, res);



    }
}
