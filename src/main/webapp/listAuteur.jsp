<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Freelancer - Start Bootstrap Theme</title>
</head>
<body>

<div class="main">
    <h1>Authors List</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nom</th>
            </tr>
        </thead>
        <tbody>
            <!-- Utilisation de JSTL pour itérer sur la liste des auteurs -->
            
            <c:forEach var="auteur" items="${listeAuteurs}">
                <tr>
                    <td>${auteur.id}</td>
                    <td>${auteur.nom}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
