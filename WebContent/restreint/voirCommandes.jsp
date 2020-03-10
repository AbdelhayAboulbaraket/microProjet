<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
<c:if test="${!empty utilisateur.panier}">
<table>
  <tr>
    <th>Code Article</th>
    <th>Designation</th>
    <th>Prix</th>
    <th>Quantite</th>
    <th>Totale</th>
    <th>Date commande</th>
  </tr>

<c:forEach var="item" items="${utilisateur.achats}">
	<tr>
 		<tr><td>${item.codeArticle}</td>
 		<td>${item.designation}</td>
 		<td>${item.prix}</td>
 		<td>${item.quantite}</td>
 		<td>${item.totale}</td>	
 		<td>${item.dateCommande}</td>		
</tr>
</c:forEach>
</table>
</c:if>


</body>
</html>