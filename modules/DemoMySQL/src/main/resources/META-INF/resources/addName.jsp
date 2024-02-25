<%@ include file="/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<portlet:renderURL var="addEntryBackURL">
	<portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
</portlet:renderURL>
	
<portlet:actionURL name="addPet" var="ActionURL"></portlet:actionURL>
	
<aui:form action="<%= ActionURL %>" name="<portlet:namespace />fm">
        <aui:fieldset>
            <aui:input name="name"></aui:input>
        </aui:fieldset>

        <aui:button-row>
            <aui:button type="submit"></aui:button>
            <aui:button type="cancel" onClick="<%= addEntryBackURL.toString() %>"></aui:button>
        </aui:button-row>
</aui:form>