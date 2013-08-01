<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title> Pelicula </title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript">
    function f() {
        var m = {name: $("input#name").val(),
                 description: $("input#description").val(),
                 direction: $("input#direction").val(),
                 year: $("input#year").val(),
                 language: $("input#language").val(),
                 duration: $("input#duration").val()
                 }
        $.ajax({
            url: "movie",
            type: "POST",
            data: JSON.stringify(m),
            contentType: "application/json",
            success: function(){
                $('#ajaxResponse').html("");
                $('#ajaxResponse').html("Se ha agregado la pelicula exitosamente!!!");

            },
            error:function(){
                alert("Accion Fallida.");
            }
        });
    }
</script>

</head>
<body>

<p> Complete el formulario para crear un pelicula. </p>


<form:form method="POST" action="m">

    <table>
    <tr>
        <td>Name:</td>
        <td><form:input path="name"/></td>
    </tr>
    <tr>
        <td>Description:</td>
        <td><form:input path="description"/></td>
    </tr>
    <tr>
        <td>Direction:</td>
        <td><form:input path="direction"/></td>
    </tr>
    <tr>
        <td>Year:</td>
        <td><form:input path="year"/></td>
    </tr>
    <tr>
        <td>Language:</td>
        <td><form:input path="language"/></td>
    </tr>
    <tr>
        <td>Duration:</td>
        <td><form:input path="duration"/></td>
    </tr>
    <tr>
        <td colspan="2">
            <input id="submit" type="submit" value="Crear sin AJAX" />
        </td>
        <td>
            <input id="button" type="button" value="Crear con AJAX" onclick="f();" />
        </td>
    </tr>
</table>

</form:form>

<div id="ajaxResponse"> </div>

</body>
</html>