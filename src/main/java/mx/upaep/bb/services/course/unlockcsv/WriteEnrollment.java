package mx.upaep.bb.services.course.unlockcsv;

import blackboard.admin.data.IAdminObject;
import blackboard.admin.data.course.Enrollment;
import blackboard.admin.persist.course.EnrollmentPersister;
import blackboard.data.ValidationException;
import blackboard.db.ConstraintViolationException;
import blackboard.persist.BbPersistenceManager;
import blackboard.persist.PersistenceException;
import blackboard.platform.persistence.PersistenceService;
import blackboard.platform.persistence.PersistenceServiceFactory;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;

public class WriteEnrollment {
    public JsonObject writeByEnrollment(ArrayList<Enrollment> listaEnrollment) {
        JsonObject jsonObjEnrollmentData = new JsonObject();
        JsonArray jsonArrayPersonData = new JsonArray();
        PersistenceService Pm = PersistenceServiceFactory.getInstance();
        BbPersistenceManager eatiPm = Pm.getDbPersistenceManager();
        EnrollmentPersister eatiEnrollmentPersister = null;
        boolean error = false;
        int cuentaf = 0;
        for(Enrollment enrollmentItem : listaEnrollment){
            try {
                eatiEnrollmentPersister = (EnrollmentPersister) eatiPm.getPersister(EnrollmentPersister.TYPE);
                jsonArrayPersonData.add(enrollmentItem.getPersonBatchUid().toString());
                enrollmentItem.setRowStatus(IAdminObject.RowStatus.ENABLED);
                enrollmentItem.setDataSourceBatchUid("SYSTEM");
                eatiEnrollmentPersister.update(enrollmentItem);
                cuentaf++;
            }catch(PersistenceException pe){
                error = true;
            }catch(ValidationException ve){
                error = true;
            }catch(ConstraintViolationException dbe){
                error = true;
            }
        }

        if(error) {
            jsonObjEnrollmentData.addProperty("error", true);
            jsonObjEnrollmentData.addProperty("mensaje", "error en alguna inscripcion!");
            jsonObjEnrollmentData.add("person", jsonArrayPersonData);
            jsonObjEnrollmentData.addProperty("cuentao",listaEnrollment.size());
            jsonObjEnrollmentData.addProperty("cuentaf",cuentaf);
        }else {
            jsonObjEnrollmentData.addProperty("error", false);
            jsonObjEnrollmentData.addProperty("mensaje", "inscripciones ok");
            jsonObjEnrollmentData.add("person", jsonArrayPersonData);
            jsonObjEnrollmentData.addProperty("cuentao",listaEnrollment.size());
            jsonObjEnrollmentData.addProperty("cuentaf",cuentaf);
        }

        return jsonObjEnrollmentData;
    }
}
