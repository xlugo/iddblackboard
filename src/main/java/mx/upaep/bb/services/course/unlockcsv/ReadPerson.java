package mx.upaep.bb.services.course.unlockcsv;

import blackboard.admin.data.user.Person;
import blackboard.admin.persist.user.PersonLoader;
import blackboard.persist.BbPersistenceManager;
import blackboard.persist.PersistenceException;
import blackboard.platform.persistence.PersistenceService;
import blackboard.platform.persistence.PersistenceServiceFactory;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.Iterator;

public class ReadPerson {
    public ArrayList<Person> readByPerson(JsonArray personBatchUidArray){
        ArrayList<Person> listaPerson = new ArrayList<Person>();
        try {
            PersistenceService Pm = PersistenceServiceFactory.getInstance();
            BbPersistenceManager eatiPm = Pm.getDbPersistenceManager();
            PersonLoader  eatiPersonLoader = (PersonLoader) eatiPm.getLoader(PersonLoader.TYPE);
            Iterator<JsonElement> batchUids = personBatchUidArray.iterator();
            while (batchUids.hasNext()) {
                Person person = eatiPersonLoader.load(batchUids.next().getAsString());
                listaPerson.add(person);
            }
        }catch(PersistenceException pe) {
            //
        }
        return listaPerson;
    }
}
