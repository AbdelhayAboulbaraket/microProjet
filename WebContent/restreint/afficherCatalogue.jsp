<%@ page language="java" import="myBusinessLayer.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>

<p style="display:inline;"> Bonjour mr ${sessionScope.utilisateur.nom} ${sessionScope.utilisateur.prenom} </p>
<p style="display:inline; "align="right"><a href="VoirPanier">Voir votre panier</a>.</p>

<form action="GenererTable" method="GET">
<label> Categorie:</label>
<select name="categorie">
<c:forEach var="name"  items="${sessionScope['taListe']}" >
          <option value="${name}" <c:if test="${name == sessionScope.selected}">selected</c:if>> ${name} </option>
</c:forEach>
</select>
<input type="submit" value="ok" />
</form>

<c:if test="${!empty maListe}">
<table class="table table-bordered">
  <tr>
    <th>Code Article</th>
    <th>Designation</th>
    <th>Prix</th>
    <th>Stock</th>
    <th></th>
  </tr>

<c:forEach var="item" items="${maListe}">
	<tr>
 		<tr><td><a href="GenererArticle?param=${item.codeArticle}">${item.codeArticle}</a></td>
 		<td>${item.designation}</td>
 		<td>${item.prix}</td>
 		<td>${item.stock}</td>
 		<td>
 		<a href="GenererArticle?param=${item.codeArticle}">Ajouter au panier </a>
 		</td>
</tr>
</c:forEach>
</table>
</c:if>


</body>
</html>