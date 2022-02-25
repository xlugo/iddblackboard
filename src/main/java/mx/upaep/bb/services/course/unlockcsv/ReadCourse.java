package mx.upaep.bb.services.course.unlockcsv;

import blackboard.admin.data.course.CourseSite;
import blackboard.admin.persist.course.CourseSiteLoader;
import blackboard.persist.BbPersistenceManager;
import blackboard.persist.PersistenceException;
import blackboard.platform.persistence.PersistenceService;
import blackboard.platform.persistence.PersistenceServiceFactory;

import java.util.ArrayList;
/**
 *
 */
public class ReadCourse {
    /**
     *
     * @param courseId
     * @return
     */
    public ArrayList<CourseSite> readByCoursesite(String courseId) {
        ArrayList<CourseSite> listaCursos = new ArrayList<CourseSite>();
        try {
            PersistenceService Pm = PersistenceServiceFactory.getInstance();
            BbPersistenceManager eatiPm = Pm.getDbPersistenceManager();
            CourseSiteLoader eatiCourseLoader = (CourseSiteLoader) eatiPm.getLoader(CourseSiteLoader.TYPE);
            CourseSite ctemplate = new CourseSite();
            ctemplate.setCourseId(courseId);
            listaCursos = eatiCourseLoader.load(ctemplate);
        }catch(PersistenceException pe){
            //null
        }
        return listaCursos;
    }
}
