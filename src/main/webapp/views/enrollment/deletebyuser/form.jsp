<%--
  Created by IntelliJ IDEA.
  Author: franciscoxavier.lugo@upaep.mx
  Date: 2021
--%>
<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page errorPage="../../../error/error.jsp"%>
<%@ taglib uri="/bbUI" prefix="bbUI"%>
<%@ taglib uri="/bbNG" prefix="bbNG" %>

<bbNG:genericPage authentication="y" entitlement="system.user.VIEW" wrapper="true"  outputBodyTags="true"  navItem="mex-mexUnive-nav-1">
    <bbNG:breadcrumbBar >
        <bbNG:breadcrumb href="../enrollment_menu.jsp" >Inscripciones</bbNG:breadcrumb>
        <bbNG:breadcrumb>Dar de baja inscripciones</bbNG:breadcrumb>
    </bbNG:breadcrumbBar>
    <bbNG:pageHeader instructions="Use un nombre de usuario para ver sus inscripciones">
        <bbNG:pageTitleBar  title="Dar de baja inscripciones" iconUrl="../imagenes/search.gif" />
        <!-- obtenemos el contexto de la aplicación -->
        <link id="contextPath" data-contextPath="<%=request.getContextPath()%>"/>
    </bbNG:pageHeader>

    <div style="margin: -20px 0px 0px -30px; width:100%;" class="containerOptions">
    <!-- Begin Action Panel List. -->
        <div id="panelbutton1" class="searchbar editmode">
          Usuario:
                <%if (request.getParameter("user") != null){
                    String pa = request.getParameter("user").trim();
                %>
                <bbUI:userPicker  username="<%= pa%>" textFieldName="user" formName="USER_SEARCH_FORM" textFieldSize="50" selectMultiple="false"></bbUI:userPicker>
                <%}else{ %>
                <bbUI:userPicker  textFieldName="user" formName="USER_SEARCH_FORM" textFieldSize="50" selectMultiple="false"></bbUI:userPicker>
                <%} %>
                <button type="button" class="btn btn-primary btn-sm" id="btn_exec">
                    <span class="spinner-border spinner-border-sm" role="status" aria-hidden="true" id="idd_btn_exec_spinner" style="display:none"></span>
                    <span id="idd_btn_exec_txt">Ir</span>
                </button>
        </div>
    </div>
    <script src="js/main-1.1.js" type="module"></script>
</bbNG:genericPage>
