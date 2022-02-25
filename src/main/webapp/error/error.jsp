<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@ page import="java.io.PrintWriter"%>
<%@ taglib uri="/bbNG" prefix="bbNG" %>
<%@ page isErrorPage="true" %>
<bbNG:genericPage>
    <bbNG:receipt type="FAIL" title="Error">
        <%
            out.println("Ha ocurrido un error en la aplicaci&oacute;n: <br/> <b>" + strException + "</b><br/><br/> Por favor copia el texto de esta pantalla a un mensaje de correo electr&oacute;nico y env&iacute;alo a :  <a href='mailto:idd@upaep.mx'>idd@upaep.mx</a> <br/><br/> La traza completa de error en el BuildingBlock es la siguiente: <br/><br/>");
        %>
        <%
            PrintWriter pw = new PrintWriter(out);
            exception.printStackTrace( pw );
        %>
    </bbNG:receipt>
</bbNG:genericPage>

