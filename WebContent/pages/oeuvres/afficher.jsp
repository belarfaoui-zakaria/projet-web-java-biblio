<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 
 


<table id="data-table" class="table table-bordered table-hover">
  <thead>
  <tr>
 
    <th>Titre</th>
    <th>Auteur</th>
    <th>Annee</th>
    <th>Nombre de page</th>
    <th></th>
  </tr>
  </thead>
 
  <tbody>
	 <c:forEach items="${oeuvres.getList()}" var="oeuvre">
 
		<tr>
		  <td>${ oeuvre.getTitre() }</td>
		  <td>${  auteurs.find(oeuvre.getAuteur()).toString()  }</td>
 
		  <td>${ oeuvre.getAnnee() }</td>
		  <td>${ oeuvre.getNombrePage() }</td>
		  <td> <form method="post" action="/GestionBibliotheque/Oeuvres/delete">
		  	<input type="hidden" name="id" value="${ oeuvre.getReference() }">
		  	<button type="submit" class="btn btn-xs btn-danger">Supprimer</button>
		  </form></td>
		  
		</tr>

	</c:forEach>
  </tbody>
</table>


