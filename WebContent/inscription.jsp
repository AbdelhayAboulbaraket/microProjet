<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1> Inscrivez-vous</h1>

<form action="ConfirmerInscription" method="POST">
  <label for="nom">Nom:</label>
  <input type="text" id="nom" name="nom" ><br>
  <label for="prenom">Prenom:</label>
  <input type="text" id="prenom" name="prenom"><br>
   <label for="adresse">Adresse:</label>
  <input type="text" id="adresse" name="adresse"><br>
  <input type="text" id="codepostal" name="codepostal">
  <input type="text" id="ville" name="ville"><br>
   <label for="tel">Tel:</label>
  <input type="text" id="tel" name="tel"><br>
   <label for="email">Email:</label>
  <input type="text" id="email" name="email"><br>
  <label for="motdepasse">Password:</label>
  <input type="password" id="motdepasse" name="motdepasse"><br>
  <input type="submit" value="Submit">
</form> 

</body>
</html>