<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 
 


<table id="data-table" class="table table-bordered table-hover">
  <thead>
  <tr>
    <th>Nom</th>
    <th>Prenom</th>
    <th></th>
 

  </tr>
  </thead>
 
  <tbody>
	 <c:forEach items="${auteurs.getList()}" var="item">
 
		<tr>
		  <td>${ item.getNom() }</td>
		  <td>${ item.getPrenom() }</td>
		  <td> <form method="post" action="/GestionBibliotheque/Auteurs/delete">
		  	<input type="hidden" name="id" value="${ item.getId() }">
		  	<button type="submit" class="btn btn-xs btn-danger">Supprimer</button>
		  </form></td>
		</tr>

	</c:forEach>
  </tbody>
</table>

