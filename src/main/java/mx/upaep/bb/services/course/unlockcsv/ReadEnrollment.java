package mx.upaep.bb.services.course.unlockcsv;

import blackboard.admin.data.course.Enrollment;
import blackboard.admin.persist.course.EnrollmentLoader;
import blackboard.data.course.Course;
import blackboard.persist.BbPersistenceManager;
import blackboard.persist.DataType;
import blackboard.persist.Id;
import blackboard.persist.PersistenceException;
import blackboard.platform.persistence.PersistenceService;
import blackboard.platform.persistence.PersistenceServiceFactory;

import java.util.ArrayList;

public class ReadEnrollment {
    public ArrayList<Enrollment> readByEnrollment(String bbObjectid) {
        ArrayList<Enrollment> listaEnrollment = new ArrayList<Enrollment>();
        try {
            PersistenceService Pm = PersistenceServiceFactory.getInstance();
            BbPersistenceManager eatiPm = Pm.getDbPersistenceManager();
            EnrollmentLoader eatiEnrollmentLoader = (EnrollmentLoader) eatiPm.getLoader(EnrollmentLoader.TYPE);
            Enrollment enr = new Enrollment();
            enr.setCourseId(generaId(bbObjectid, eatiPm));
            listaEnrollment = eatiEnrollmentLoader.load(enr);
        }catch(PersistenceException pe){
            //null
        }
        return listaEnrollment;
    }

    private Id generaId(String crsPkStr, BbPersistenceManager bbPm) throws PersistenceException{
        DataType ld = new DataType(Course.class);
        return  bbPm.generateId(ld, crsPkStr);
    }
}
