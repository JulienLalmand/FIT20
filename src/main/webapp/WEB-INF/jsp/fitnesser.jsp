<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welkom in de Brainstormapplicatie</title>
    </head>
    
    <body>
        <h1>Details van fitnesser</h1>
        <b>Id:</b>
        <c:out value="${persoon.id}" /><br/>
        <b>Voornaam:</b>
        <c:out value="${persoon.voornaam}" /><br/>
        <b>Familienaam:</b>
        <c:out value="${persoon.naam}" /><br/>
        <b>Accountnaam:</b>
        <c:out value="${persoon.accountnaam}" /><br/>
        <b>Wachtwoord:</b>
        <c:out value="${persoon.wachtwoord}" /><br/>
        <b>E-mailadres:</b>
        <c:out value="${persoon.email}" /><br/>
        <b>Rol:</b>
        <c:out value="${persoon.rol}" /><br/>
        <b>Status:</b>
        <c:out value="${persoon.status}" /><br/>
        <c:url var="home" value="/home.html" />
        <a href='<c:out value="${home}"/>'>Home</a>
    </body>
</html>
