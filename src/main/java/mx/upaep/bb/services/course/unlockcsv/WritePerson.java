package mx.upaep.bb.services.course.unlockcsv;

import blackboard.admin.data.IAdminObject;
import blackboard.admin.data.user.Person;
import blackboard.admin.persist.user.PersonPersister;
import blackboard.data.ValidationException;
import blackboard.db.ConstraintViolationException;
import blackboard.persist.BbPersistenceManager;
import blackboard.persist.PersistenceException;
import blackboard.platform.persistence.PersistenceService;
import blackboard.platform.persistence.PersistenceServiceFactory;
import com.google.gson.JsonObject;

import java.util.ArrayList;

public class WritePerson {
    public JsonObject writeByPerson(ArrayList<Person> arrayPerson) {
        JsonObject jsonObjPersontData = new JsonObject();
        PersistenceService Pm = PersistenceServiceFactory.getInstance();
        BbPersistenceManager eatiPm = Pm.getDbPersistenceManager();
        boolean error = false;
        int cuentaf = 0;
        for(Person personItem : arrayPerson) {
            try {
                PersonPersister eatiPersonPersister = (PersonPersister) eatiPm.getPersister(PersonPersister.TYPE);
                personItem.setRowStatus(IAdminObject.RowStatus.ENABLED);
                personItem.setDataSourceBatchUid("SYSTEM");
                eatiPersonPersister.update(personItem);
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
            jsonObjPersontData.addProperty("error", true);
            jsonObjPersontData.addProperty("mensaje", "error en algun usuario!");
            jsonObjPersontData.addProperty("cuentao", arrayPerson.size());
            jsonObjPersontData.addProperty("cuentaf", cuentaf);
        }else {
            jsonObjPersontData.addProperty("error", false);
            jsonObjPersontData.addProperty("mensaje", "usuarios ok");
            jsonObjPersontData.addProperty("cuentao", arrayPerson.size());
            jsonObjPersontData.addProperty("cuentaf", cuentaf);
        }
        return jsonObjPersontData;
    }
}
