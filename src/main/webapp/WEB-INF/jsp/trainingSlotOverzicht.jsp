<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TrainingSlot verwijderen</title>
    </head>
    
    <body>
		<div style="float:right;">
    		<p>Ingelogd als ${naam}</p>
        	<c:url var="home" value="/" />
      		<a href='<c:out value="${url}"/>'>Log uit</a>
    	</div>
  		
      <h1>TrainingSlot Overzicht</h1>
      <div>       
	      <ul>
	      	<c:forEach items="${trainingslots}" var="trainingslot">
	      		<c:url var="trainingSlotUrl" value="/trainingSlotDetailTrainer.html">
	            	<c:param name="id" value="${trainingslot.id}" />
	            </c:url>
	      		<li>
	      			<a href='<c:out value="${trainingSlotUrl}"/>'>
	      				<c:out value="${trainingslot.datum}"></c:out>
	      				<c:out value="${trainingslot.status}"></c:out>
	      			</a>
	      		</li>
	      	</c:forEach>
	      </ul>
      </div> 
      
      <h1>Voltooide Trainingslots</h1>
      <div>       
	      <ul>
	      	<c:forEach items="${trainingslotsVoltooid}" var="trainingslotsvoltooid">
	      		<c:url var="trainingSlotUrl" value="/trainingSlotDetailVoltooid.html">
	            	<c:param name="id" value="${trainingslotsvoltooid.id}" />
	            </c:url>
	      		<li>
	      			<a href='<c:out value="${trainingSlotUrl}"/>'>
	      				<c:out value="${trainingslotsvoltooid.datum}"></c:out>
	      				<c:out value="${trainingslotsvoltooid.status}"></c:out>
	      				<c:out value="${trainingslotsvoltooid.programma}"></c:out>
	      				<c:out value="${trainingslotsvoltooid.trainer}"></c:out>
	      			</a>
	      		</li>
	      	</c:forEach>
	      </ul>
      </div> 
      
      <div>
      	<h2>Voeg een tijdstip in waarop je wil training geven:</h2>
      	<c:url var="url" value="/nieuwTrainingSlot.html" />
        <form:form action="${url}" commandName="trainingSlot">   <%-- Spring form tags --%>
            <fieldset>
                <div><label>Datum + uur:</label><form:input path="datum"/></div>
                <div><label>TrainerID:</label><form:input path="id" value="${trainerid}" readonly="true"/></div>
                <div><input name="submit" type="submit" value="save"/></div>
            </fieldset>
        </form:form>
      		      		
      </div>

        
    </body>
</html>