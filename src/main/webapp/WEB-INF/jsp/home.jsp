<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welkom in de Fit20 WebApplicatie</title>
    </head>
    
    <body>
    	<div style="float:left; ">
	    	<h1>Inloggen als Trainer</h1>
	    	
	    	<c:url var="url" value="/trainingSlotOverzicht.html" />
	    	<form action="${url}" commandName="detrainer">
				Accountnaam: <input type="text" name="naam"><br />
				Wachtwoord: <input type="text" name="wachtwoord"/>
				<input type="submit" value="Log in" />
			</form>
			
			
			<c:url var="nieuweFitnesserUrl" value="/nieuweFitnesser.html" />
	        <a href='<c:out value="${nieuweFitnesserUrl}"/>'>Fitnesser Toevoegen</a>
        </div>
  
    
   		<div style="float:right; padding-right:20%;">
	    	<h1>Inloggen als Fitnesser</h1>
	    	
	    	<c:url var="url" value="/fitnesserHome.html" />
	    	<form action="${url}" commandName="defitnesser">
				Accountnaam: <input type="text" name="naam"><br />
				Wachtwoord: <input type="text" name="wachtwoord"/>
				<input type="submit" value="Log in" />
			</form>

        </div>

      </body>
</html>