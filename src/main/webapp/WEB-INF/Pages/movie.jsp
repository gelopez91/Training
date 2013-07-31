<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title> Pelicula </title>
</head>
<body>
 <h1> Informacion </h1>
 <p> ${pageContext.servletContext.getInitParameter("defaultMessage")} </p>  <br>

 <p> Nombre: ${message.getName()} </p>
 <p> Descripcion: ${message.getDescription()} </p>
 <p> Direccion: ${message.getDirection()} </p>
 <p> Anno: ${message.getYear()} </p>
 <p> Idioma: ${message.getLanguage()} </p>
 <p> Duracion: ${message.getDuration()} </p>

 <p> Actores: </p>  <br>

 <table border="1">
    <tr>
        <th>Nombre</th>
        <th>Apellido</th>
    </tr>

 <c:forEach var="actor" items="${message.actors}">
   <tr>
   <td> ${actor.firstName} </td>
   <td> ${actor.lastName} </td>
   </tr>
 </c:forEach>

 </table>


</body>
</html>