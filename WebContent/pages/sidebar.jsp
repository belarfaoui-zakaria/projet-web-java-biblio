<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 
  <!-- Left side column. contains the sidebar -->
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">


      <!-- /.search form -->
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu" data-widget="tree">
        
    <li class="treeview ${ params.get("servlet") == "Oeuvres" ? "active" : ""  }">
      <a href="#">
        <i class="fa fa-dashboard"></i> <span>Oeuvres</span>
        <span class="pull-right-container">
          <i class="fa fa-angle-left pull-right"></i>
        </span>
      </a>
      <ul class="treeview-menu">
        <li><a href="/GestionBibliotheque/Oeuvres"><i class="fa fa-circle-o"></i> les Oeuvres </a></li>
        <li><a href="/GestionBibliotheque/Oeuvres/ajouter"><i class="fa fa-circle-o"></i> Ajouter un Oeuvre </a></li>
      </ul>
    </li>
    
    
    <li class="treeview ${ params.get("servlet") == "Auteurs" ? "active" : ""  }">
      <a href="#">
        <i class="fa fa-dashboard"></i> <span>Auteurs</span>
        <span class="pull-right-container">
          <i class="fa fa-angle-left pull-right"></i>
        </span>
      </a>
      <ul class="treeview-menu">
        <li><a href="/GestionBibliotheque/Auteurs"><i class="fa fa-circle-o"></i> les Auteurs </a></li>
        <li><a href="/GestionBibliotheque/Auteurs/ajouter"><i class="fa fa-circle-o"></i> Ajouter un Auteur </a></li>
      </ul>
    </li>
    
    
    <li class="treeview ${ params.get("servlet") == "Abonnes" ? "active" : ""  }">
      <a href="#">
        <i class="fa fa-dashboard"></i> <span>Abonnes</span>
        <span class="pull-right-container">
          <i class="fa fa-angle-left pull-right"></i>
        </span>
      </a>
      <ul class="treeview-menu">
      <li><a href="/GestionBibliotheque/Abonnes"><i class="fa fa-circle-o"></i> les Abonnes</a></li>
        <li><a href="/GestionBibliotheque/Abonnes/ajouter"><i class="fa fa-circle-o"></i> Ajouter un Abonne </a></li>
        
      </ul>
    </li>
    
    <li class="treeview ${ params.get("servlet") == "Emprunts" ? "active" : ""  } ">
      <a href="#">
        <i class="fa fa-dashboard"></i> <span>Emprunts</span>
        <span class="pull-right-container">
          <i class="fa fa-angle-left pull-right"></i>
        </span>
      </a>
      <ul class="treeview-menu">
        <li><a href="/GestionBibliotheque/Emprunts"><i class="fa fa-circle-o"></i> les Emprunts</a></li>
        <li><a href="/GestionBibliotheque/Emprunts/ajouter"><i class="fa fa-circle-o"></i> Ajouter un Emprunt </a></li>
      </ul>
    </li>



        
 
  
        
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>