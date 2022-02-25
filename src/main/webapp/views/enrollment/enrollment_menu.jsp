<%--
  Created by IntelliJ IDEA.
  Author: franciscoxavier.lugo@upaep.mx
  Date: 2021
--%>
<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page errorPage="../../error/error.jsp"%>
<%@ taglib uri="/bbUI" prefix="bbUI"%>
<%@ taglib uri="/bbNG" prefix="bbNG" %>

<bbNG:genericPage authentication="y" entitlement="system.courseuserlist.VIEW" wrapper="true"  outputBodyTags="true"  navItem="mex-mexUnive-nav-1">

    <bbNG:breadcrumbBar >
        <bbNG:breadcrumb>Cursos</bbNG:breadcrumb>
    </bbNG:breadcrumbBar>

    <bbNG:pageHeader>
        <bbNG:pageTitleBar  title="Inscripciones" iconUrl="imagenes/course.gif"/>
    </bbNG:pageHeader>

    <bbUI:caretList description="Cursos">
        <bbUI:caret title="Dar de baja inscripciones" href="deletebyuser/form.jsp">Permite eliminar las inscripciones de un usuario</bbUI:caret>

    </bbUI:caretList>

</bbNG:genericPage>