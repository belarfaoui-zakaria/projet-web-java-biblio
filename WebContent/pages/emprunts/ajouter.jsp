<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <form class="form" role="form" method="post" action="">
   <div class="box-body">


 
	
	<div class="form-group">
	  <label for="titre">Abonne: </label>
	  <select class="form-control" name="abonne">
	  	<c:forEach items="${abonnes.getList()}" var="item">
	  		<option value="${ item.getId() }"> ${ item.toString() } </option>
	  	</c:forEach>
	  </select>
	</div>
	
	<div class="form-group">
	  <label for="auteur">Oeuvre: </label>
	  <select class="form-control" name="oeuvre">
	  	<c:forEach items="${oeuvres.getList()}" var="item">
	  		<option value="${ item.getReference() }"> ${ item.toString() } </option>
	  	</c:forEach>
	  </select>
	  
	</div>
	<div class="form-group">
	  <label for="annee">Date retour: </label>
	  <input class="form-control" placeholder="DD/MM/YYYY" name="date_retour" type="text"></input>
	</div>

 


   </div>
   <!-- /.box-body -->

   <div class="box-footer">
     <button type="submit" class="btn btn-primary">Ajouter un Oeuvre</button>
   </div>
 </form>