<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detail trainingSlot</title>
    </head>
    
    <body>
    	<div style="float:right;">
    		<c:url var="fitnesserHome" value="/fitnesserHome.html" />
       		 <a href='<c:out value="${fitnesserHome}"/>'>Terug</a>
    	</div>
    	
    
        <h1>Details van trainingslot</h1>
        <b>Id:</b>
        <c:out value="${trainingSlot.id}" /><br/>
        <b>Datum + uur:</b>
        <c:out value="${trainingSlot.datum}" /><br/>
        <b>Trainer:</b>
        <c:out value="${trainingSlot.trainer}" /><br/>
        <b>Fitnesser:</b>
        <c:out value="${trainingSlot.fitnesser}" /><br/>
        <b>Programma:</b>
        <c:out value="${trainingSlot.programma}" /><br/>
        <b>Status:</b>
        <c:out value="${trainingSlot.status}" /><br/>

        <c:url var="annuleerUrl" value="/trainingSlot/annuleer.html"/>    
		<form id="${trainingSlotForm}" action="${annuleerUrl}" method="POST">
      			<input id="trainingSlot" name="trainingSlot" type="hidden" value="${trainingSlot.id}"/>
      			<input type="submit" value="Annuleer training" onClick="return confirm('Bent u zeker dat u dit trainingslot wil annuleren?')"/>
		</form>

    </body>
</html>
