<%@ page language="java" import="myBusinessLayer.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<p style="display:inline;"> Bonjour mr ${sessionScope.utilisateur.nom} ${sessionScope.utilisateur.prenom} </p>
<p style="display:inline; "align="right"><a href="VoirPanier">Voir votre panier</a>.</p>

<a href="GenererTable"> Consulter catalogue.</a>

</body>
</html>