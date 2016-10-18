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

		<h1>Klantentevredenheid:</h1>
        <c:url var="annuleerUrl" value="/trainingSlot/klantentevredenheid.html"/>    
		<form id="${trainingSlotForm}" action="${annuleerUrl}" method="POST">
      			<input id="trainingSlot" name="trainingSlot" type="hidden" value="${trainingSlot.id}"/>
      			<textarea id="klantentevredenheid" cols="50" rows="10" name="klantentevredenheid"></textarea>
      			<input type="submit" value="Save" />
		</form>

    </body>
</html>
