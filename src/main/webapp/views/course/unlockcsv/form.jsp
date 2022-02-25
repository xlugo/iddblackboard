<%--
  Created by IntelliJ IDEA.
  Author: franciscoxavier.lugo@upaep.mx
  Date: 2021
--%>
<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page errorPage="/error/error.jsp"%>
<%@ taglib uri="/bbUI" prefix="bbUI"%>
<%@ taglib uri="/bbNG" prefix="bbNG" %>

<bbNG:genericPage authentication="y" entitlement="course.user.MODIFY" wrapper="true"  outputBodyTags="true"  navItem="mex-mexUnive-nav-1">

        <bbNG:breadcrumbBar >
            <bbNG:breadcrumb href="../course_menu.jsp" >Cursos</bbNG:breadcrumb>
            <bbNG:breadcrumb>Desbloquear curso y sus inscripciones</bbNG:breadcrumb>
        </bbNG:breadcrumbBar>

        <bbNG:pageHeader instructions="Seleccione un archivo csv delimitado por comas con los ids de los cursos">
            <bbNG:pageTitleBar  title="Desbloquear curso " iconUrl="../imagenes/user.gif"/>
            <bbNG:cssFile href="//formden.com/static/cdn/bootstrap-iso.css" />
            <bbNG:cssFile href="//cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css" />
            <bbNG:pageTitleBar  title="Desbloquear curso y sus inscripciones" iconUrl="../imagenes/search.gif"/>
            <bbNG:cssBlock>
                <style>
                    button.idd_btn_det > * {
                        pointer-events: none;
                    }
                </style>
            </bbNG:cssBlock>
            <%--
            <bbNG:jsFile href="" />
            <bbNG:jsBlock>
                <script type="text/javascript">
                </script>
            </bbNG:jsBlock>
            --%>
            <!-- obtenemos el contexto de la aplicación -->
            <link id="contextPath" data-contextPath="<%=request.getContextPath()%>"/>
        </bbNG:pageHeader>
    <div class="bootstrap-iso">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-8">
                    <div class="form-group">
                        <form  id="frm_exec">
                            <div class="mb-3">
                                <input class="form-control form-control-sm" id="file" type="file" name="file">
                            </div>
                            <input type="hidden" name="delimiter" value="comma" checked />
                        </form>
                    </div>
                </div>
                <div class="col-md-4">
                    <button type="button" class="btn btn-primary btn-sm" id="btn_exec">
                        <span class="spinner-border spinner-border-sm" role="status" aria-hidden="true" id="idd_btn_exec_spinner" style="display:none"></span>
                        <span id="idd_btn_exec_txt">Enviar</span>
                    </button>
                </div>
            </div>
            <div class="alert alert-warning alert-dismissable alert-primary" id="idd_alert_div" style="display:none;width:100%">
                <a class="close"  aria-label="close" id="idd_alert_close"></a>
                <span id="idd_alert_msj"></span>
            </div>
            <div class="bd-example" id="idd_div_table" style="display:none">
                <table class="table small table-hover table-sm" id="idd_table">
                    <thead>
                    <tr>
                        <th scope="col">ID DE CURSO</th>
                        <th scope="col">CURSO</th>
                        <th scope="col">INSCRIPCIONES</th>
                        <th scope="col">USUARIOS</th>
                    </tr>
                    </thead>
                    <tbody id="idd_table_tbody">
                    </tbody>
                </table>
            </div>
        </div><!-- container -->
        <hr>
        <ul id="resultado" style="list-style-type:none;"></ul>
    </div><!-- bootstrap-iso -->
    <script src="js/main-1.1.js" type="module"></script>
</bbNG:genericPage>