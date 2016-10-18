<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fitnesser Home</title>
</head>
<body>
	<div style="float:right;">
	    <p>Ingelogd als ${naam}</p>
	    <c:url var="home" value="/" />
	    <a href='<c:out value="${url}"/>'>Log uit</a>
	</div>
	
	<h1>Geplande Trainingslots</h1>
      <div>       
	      <ul>
	      	<c:forEach items="${trainingslots}" var="trainingslot">
	      		<c:url var="trainingSlotUrl" value="/trainingSlotDetailFitnesser.html">
	            	<c:param name="id" value="${trainingslot.id}" />
	            </c:url>
	      		<li>
	      			<a href='<c:out value="${trainingSlotUrl}"/>'>
	      				<c:out value="${trainingslot.datum}"></c:out>
	      				<c:out value="${trainingslot.status}"></c:out>
	      				<c:out value="${trainingslot.programma}"></c:out>
	      				<c:out value="${trainingslot.trainer}"></c:out>
	      			</a>
	      		</li>
	      	</c:forEach>
	      </ul>
      </div> 
      
      <h1>Voltooide Trainingslots</h1>
      <div>       
	      <ul>
	      	<c:forEach items="${trainingslotsVoltooid}" var="trainingslotsvoltooid">
	      		<c:url var="trainingSlotUrl" value="/trainingSlotReviewFitnesser.html">
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
      
     
		
	<h1>Opgegeven Beschikbaarheden</h1>
      <div>       
	      <ul>
	      	<c:forEach items="${beschikbaarheidLijst}" var="beschikbaarheid">
	      		<li>
	      			<c:out value="datum: ${beschikbaarheid.datum}"></c:out>
	      			<c:out value="Voorkeur voor trainer: ${beschikbaarheid.voorkeurtrainerid}"></c:out>
	      		</li>
	      	</c:forEach>
	      </ul>
      </div> 
     
	
	
    <div>
      	<h2>Voeg een moment in waarop je wil fitnessen:</h2>
      	<c:url var="url" value="/nieuweBeschikbaarheid.html" />
        <form:form action="${url}" commandName="beschikbaarheid">   
            <fieldset>
                <div><label>Datum + uur:</label><form:input path="datum"/></div>
                <div><label>FitnesserID:</label><form:input path="fitnesserid" value="${fitnesserid}" readonly="true"/></div>
                <div><label>voorkeur Trainer:</label>
                <form:select path="voorkeurtrainerid">
               		<form:option value="0" label="geen voorkeur..." />
        			<form:options items="${trainerLijst}" itemValue="id" itemLabel="naam" />
    			</form:select>
    			</div>
                <div><input name="submit" type="submit" value="save"/></div>
            </fieldset>
        </form:form>
      		      		
      </div> 

</body>
</html>