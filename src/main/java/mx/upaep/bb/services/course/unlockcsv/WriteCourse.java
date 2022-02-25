package mx.upaep.bb.services.course.unlockcsv;

import blackboard.admin.data.IAdminObject;
import blackboard.admin.data.course.CourseSite;
import blackboard.admin.persist.course.CourseSitePersister;
import blackboard.data.ValidationException;
import blackboard.db.ConstraintViolationException;
import blackboard.persist.BbPersistenceManager;
import blackboard.persist.PersistenceException;
import blackboard.platform.persistence.PersistenceService;
import blackboard.platform.persistence.PersistenceServiceFactory;
import com.google.gson.JsonObject;

import java.util.ArrayList;

public class WriteCourse {
    public JsonObject writeByCoursesite(ArrayList<CourseSite> listaCursos) {
        JsonObject jsonObjCourseData= new JsonObject();
        try {
            String courseId;
            String bbObjectId;
            String courseBatchUid;
            PersistenceService Pm = PersistenceServiceFactory.getInstance();
            BbPersistenceManager eatiPm = Pm.getDbPersistenceManager();
            CourseSitePersister eatiCoursePersister = (CourseSitePersister) eatiPm.getPersister(CourseSitePersister.TYPE);
            if((listaCursos.size() == 1) && !(listaCursos.isEmpty())){
                CourseSite coursiteItem = listaCursos.get(0);
                courseId = coursiteItem.getCourseId();
                bbObjectId = coursiteItem.getId().toExternalString();
                courseBatchUid = coursiteItem.getBatchUid().toString();
                coursiteItem.setRowStatus(IAdminObject.RowStatus.ENABLED);
                coursiteItem.setDataSourceBatchUid("SYSTEM");
                coursiteItem.setIsAvailable(false);
                eatiCoursePersister.update(coursiteItem);
                jsonObjCourseData.addProperty("error", false);
                jsonObjCourseData.addProperty("mensaje", "curso ok");
                jsonObjCourseData.addProperty("courseid", courseId);
                jsonObjCourseData.addProperty("bbobjectid", bbObjectId);
                jsonObjCourseData.addProperty("coursebatchuid", courseBatchUid);
            }else{
                jsonObjCourseData.addProperty("error", true);
                jsonObjCourseData.addProperty("mensaje", "error array inconsistente!");
            }
        }catch(PersistenceException pe){
            jsonObjCourseData.addProperty("error", true);
            jsonObjCourseData.addProperty("mensaje", "error PersistenceException!");
        }catch(ValidationException ve){
            jsonObjCourseData.addProperty("error", true);
            jsonObjCourseData.addProperty("mensaje", "error ValidationException!");
        }catch(ConstraintViolationException dbe){
            jsonObjCourseData.addProperty("error", true);
            jsonObjCourseData.addProperty("mensaje", "error ConstraintViolationException!S");
        }
        return jsonObjCourseData;
    }
}
