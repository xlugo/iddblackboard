package mx.upaep.bb.services.course.unlockcsv;

import blackboard.admin.data.course.CourseSite;
import blackboard.admin.data.course.Enrollment;
import blackboard.admin.data.user.Person;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class DesbloquearCurso {

    public JsonObject setCourseRowStatus(HttpServletRequest request) {
        ReadCourse rc = new ReadCourse();
        ArrayList<CourseSite> listaCursos = rc.readByCoursesite(request.getParameter("courseid"));
        WriteCourse wc = new WriteCourse();
        JsonObject jsonObject = wc.writeByCoursesite(listaCursos);
        return jsonObject;
    }

    public JsonObject setPersonRowStatus(JsonArray personBatchUidArray) {
        ReadPerson rp = new ReadPerson();
        ArrayList<Person> personArray = rp.readByPerson(personBatchUidArray);//person batchuid
        WritePerson wp = new WritePerson();
        JsonObject jsonObject = wp.writeByPerson(personArray);
        return jsonObject;
    }

    public JsonObject setEnrollmentRowStatus(String bbObjectid,  String courseBatchUid) {
        ReadEnrollment  re = new ReadEnrollment();
        ArrayList<Enrollment> listaEnrollment = re.readByEnrollment(bbObjectid);// curso bbbObjectid
        WriteEnrollment we = new WriteEnrollment();
        JsonObject jsonObject = we.writeByEnrollment(listaEnrollment);
        return jsonObject;
    }

}