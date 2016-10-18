<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detail trainingSlot</title>
    </head>
    
    <body>
    	<div style="float:right;">
    		<c:url var="trainingSlotOverzicht" value="/trainingSlotOverzicht.html" />
       		 <a href='<c:out value="${trainingSlotOverzicht}"/>'>Terug</a>
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
        <b>Klantentevredenheid:</b>
        <c:out value="${trainingSlot.klantentevredenheid}" /><br/>
       
        
        
        
        <c:url var="deleteUrl" value="/trainingSlot/delete.html"/>    
		<form id="${trainingSlotForm}" action="${deleteUrl}" method="POST">
      			<input id="trainingSlot" name="trainingSlot" type="hidden" value="${trainingSlot.id}"/>
      			<input type="submit" value="delete" onClick="return confirm('Bent u zeker dat u dit trainingslot definitief wil verwijderen?')"/>
		</form>
		
		<h2>Datum + tijd aanpassen</h2>
		<c:url var="updateUrl" value="/trainingSlot/update.html" />
        <form id="${trainingSlotForm2}" action="${updateUrl}" method="POST">
            <label>Nieuwe datum + uur</label> <input id="datum" name="datum"/>
            <input id="trainingSlot" name="trainingSlot" type="hidden" value="${trainingSlot.id}"/>
            <input type="submit" value="update"/>
        </form>
    </body>
</html>
