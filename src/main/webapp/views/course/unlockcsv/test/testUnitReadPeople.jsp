<%--
  Created by IntelliJ IDEA.
  Author: franciscoxavier.lugo@upaep.mx
  Date: 2021
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Strict//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@ page language="java" errorPage="IdeaProjects/BBUltraAdmin/src/main/webapp/error/error.jsp"%>
<%@ page import="mx.upaep.bb.services.person.ReadPerson,
com.google.gson.JsonParser,
com.google.gson.JsonObject,
java.util.ArrayList,
blackboard.admin.data.user.Person"%>
<%@ taglib uri="/bbUI" prefix="bbUI"%>
<%@ taglib uri="/bbNG" prefix="bbNG" %>
<bbNG:genericPage authentication="y" entitlement="system.user.VIEW" wrapper="true"  outputBodyTags="true"  navItem="dur-durCurso-nav-1" ctxId="ctx">
    <%
        ArrayList<Person> people = new ArrayList<>();
        String json = "{'error':false,'mensaje':'inscripciones ok','person':['124975','3475281','3484174','3485822','3489341','3443892','3467680','3485415','3489577','3448029','3485068','3415332','3457163','3482324','3487819','3478712','3459238','3489130','3480676','3487632']}";
        ReadPerson rp = new ReadPerson();
        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        people = rp.readByPeople(jsonObject.get("person").getAsJsonArray());
        for(Person personItem : people){
            out.print(personItem.getEmailAddress() + "<br>");
        }
    %>
</bbNG:genericPage>