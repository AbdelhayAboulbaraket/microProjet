<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<p> Fiche  : ${article.designation} </p> <br>
<form method="GET" action="AjouterAuPanier">
<label for="codeArticle">Code Article :</label>
  <input type="text" value="${article.codeArticle}" name="param" readonly>
  <label for="designation">Designation:</label>
  <input type="text" value="${article.designation}" readonly><br>
   <label for="prix">Prix :</label>
  <input type="text" value="${article.prix}" readonly>
   <label for="categorie">Categorie :</label>
  <input type="text" value="${article.categorie.categorie}" readonly><br>
  <label for="stock">En Stock :</label>
  <input type="text" value="${article.stock}" readonly> <br>
  <label for="quantite">Combien voulez-vous :</label>
  <input type="text" name="quantite">
<input type="Submit" value="Ajouter au panier" >
</form>

</body>
</html>