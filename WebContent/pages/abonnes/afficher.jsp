<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 
 


<table id="data-table" class="table table-bordered table-hover">
  <thead>
		<tr>
		  <th>nom</th>
		  <th>prenom</th>
		  <th>date_naissance</th>
		  <th>date_inscription</th>
		  <th>numero_telephone</th>
		  <th>ville</th>
		  <th></th>
		</tr>
  </thead>
 
  <tbody>
	 <c:forEach items="${abonnes.getList()}" var="item">
 
		<tr>
		  <td>${ item.getNom() }</td>
		  <td>${ item.getPrenom() }</td>
		  <td>${ item.getDate_naissance() }</td>
		  <td>${ item.getDate_inscription() }</td>
		  <td>${ item.telephone() }</td>
		  <td>${ item.getVille() }</td>
		  <td> <form method="post" action="/GestionBibliotheque/Abonnes/delete">
		  	<input type="hidden" name="id" value="${ item.getId() }">
		  	<button type="submit" class="btn btn-xs btn-danger">Supprimer</button>
		  </form></td>
		</tr>


	</c:forEach>
  </tbody>
</table>

