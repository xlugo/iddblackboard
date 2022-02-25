<%--
  Created by IntelliJ IDEA.
  Author: franciscoxavier.lugo@upaep.mx
  Date: 2022
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Strict//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@ page errorPage="error/error.jsp"%>
<%@ taglib uri="/bbUI" prefix="bbUI"%>
<%@ taglib uri="/bbNG" prefix="bbNG"%>
<bbNG:genericPage authentication="y" entitlement="system.administration.top.VIEW" wrapper="true"  outputBodyTags="true"  navItem="mex-mexUnive-nav-1">
    <bbNG:pageHeader instructions="Tareas disponibles para administrar">
        <bbNG:pageTitleBar  title="Herramientas de administración" iconUrl="imagenes/config.gif" showTitleBar="true"/>
    </bbNG:pageHeader>
    <bbUI:caretList description="Tareas">
        <bbUI:caret title="Cursos" href="views/course/course_menu.jsp">Permite configurar diferentes opciones de curso</bbUI:caret>
        <bbUI:caret title="Inscripciones" href="views/course/enrollment_menu.jsp">Permite configurar diferentes opciones de inscripción</bbUI:caret>
    </bbUI:caretList>
</bbNG:genericPage>