<%--
  Created by IntelliJ IDEA.
  User: franciscoxavier.lugo@upaep.mx
  Date: diciembre 2021
--%>
<%@ page import="com.google.gson.JsonObject"%>
<%
  response.setContentType("application/json");
  response.setHeader("cache-control", "no-cache");
  JsonObject jo = (JsonObject) request.getAttribute("jsonObject");
  out.println(jo);
  out.flush();
%>