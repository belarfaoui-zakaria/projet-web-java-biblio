<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 
 


<table id="data-table" class="table table-bordered table-hover">
  <thead>
  <tr>
    <th>Abonne</th>
    <th>Oeuvre</th> 
    <th>Date_retour</th>
    <th>Date_emprunt</th>
    <th></th>

  </tr>
  </thead>
 
  <tbody>
	 <c:forEach items="${emprunts.getList()}" var="item">
 
		<tr>
		
		  <td>${ abonnes.find(item.getAbonne()) != null ? abonnes.find(item.getAbonne()).toString() : item.getAbonne() }</td>
		  <td>${ oeuvres.find(item.getOeuvre()) != null ? oeuvres.find(item.getOeuvre()).getTitre() : item.getOeuvre() }</td>
		  <td>${ item.getDate_retour() }</td>
		  <td>${ item.getDate_emprunt() }</td>
		  
		  <td> <form method="post" action="/GestionBibliotheque/Emprunts/delete">
		  	<input type="hidden" name="id" value="${ item.getId() }">
		  	<button type="submit" class="btn btn-xs btn-danger">Supprimer</button>
		  </form></td>
		  
		</tr>

	</c:forEach>
  </tbody>
</table>

