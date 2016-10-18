<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fitnesser toevoegen</title>
    </head>
    
    <body>
        <h1>Fitnesser toevoegen</h1>
        <c:url var="url" value="/nieuweFitnesser.html" />
        <form:form action="${url}" commandName="depersoon">   <%-- Spring form tags --%>
            <fieldset>
                <div><label>Voornaam:</label><form:input path="voornaam"/></div>
                <div><label>Naam:</label><form:input path="naam"/></div>
                <div><label>Accountnaam:</label><form:input path="accountnaam"/></div>
                <div><label>E-mailadres:</label><form:input path="email"/></div>
                <div><label>rol:</label><form:select path="rol"><form:option value="Fitnesser"></form:option></form:select></div>
                
                <div><label>Status:</label><form:input path="status"/></div>
                <div><label>Wachtwoord:</label><form:input path="wachtwoord"/></div>
                <div><input name="submit" type="submit" value="save"/></div>
            </fieldset>
        </form:form>
    </body>
</html>
