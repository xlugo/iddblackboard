<%--
  Created by IntelliJ IDEA.
  User: franciscoxavier.lugo@upaep.mx
  Date: diciembre 021
--%>
<%@ page import="com.google.gson.JsonObject,
mx.upaep.bb.services.course.unlockcsv.DesbloquearCurso" %>
<%

    response.setContentType("application/json");
    response.setHeader("cache-control", "no-cache");

    JsonObject jsonObjCourseUnblock= new JsonObject();

    DesbloquearCurso dc = new DesbloquearCurso();
    JsonObject jsonObjectCourse  = dc.setCourseRowStatus(request);
    jsonObjCourseUnblock.add("course", jsonObjectCourse);
    JsonObject jsonObjectEnrollment = dc.setEnrollmentRowStatus(jsonObjectCourse.get("bbobjectid").getAsString(), jsonObjectCourse.get("coursebatchuid").getAsString());
    jsonObjCourseUnblock.add("enrollment", jsonObjectEnrollment);
    JsonObject jsonObjectPerson = dc.setPersonRowStatus(jsonObjectEnrollment.get("person").getAsJsonArray());
    jsonObjCourseUnblock.add("person", jsonObjectPerson);
    out.println(jsonObjCourseUnblock);
    out.flush();

%>