<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <form class="form" role="form" method="post" action="">
   <div class="box-body">


	<div class="form-group">
	  <label for="reference">Reference</label>
	  <input class="form-control" name="reference" type="text" value="oeuvre_${id}"></input>
	</div>
	<div class="form-group">
	  <label for="titre">Titre</label>
	  <input class="form-control" name="titre" type="text" placeholder="La Boîte à merveilles"></input>
	</div>
	<div class="form-group">
	  <label for="auteur">Auteur</label>
	  <select class="form-control" name="auteur">
	  	<c:forEach items="${auteurs.getList()}" var="item">
	  		<option value="${ item.getId() }"> ${ item.getNom() }  ${ item.getPrenom() } </option>
	  	</c:forEach>
	  </select>
	  
	</div>
	<div class="form-group">
	  <label for="annee">Annee</label>
	  <input class="form-control" placeholder="exemple: 1995" name="annee" type="text"></input>
	</div>
	<div class="form-group">
	  <label for="nombre_page">Nombre page</label>
	  <input class="form-control" name="nombre_page" type="number" value="300"></input>
	</div>



   </div>
   <!-- /.box-body -->

   <div class="box-footer">
     <button type="submit" class="btn btn-primary">Ajouter un Oeuvre</button>
   </div>
 </form>