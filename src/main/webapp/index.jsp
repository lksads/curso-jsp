<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">

<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">

<title>Curso JSP</title>

<style type="text/css">
form {
	position: absolute;
	top: 40%;
	left: 35%;
	right: 35%;
}

h3 {
	position: absolute;
	top: 35%;
	left: 46%;
	right: 30%;
}

.msg{
	position: absolute;
	top: 105%;
	left: 20%;
	font-size: 25px;
	color: red;
}

</style>
</head>
<body>

	<h3>
		Tela de Login
		</h3>

		<form action="<%= request.getContextPath() %>/ServletLogin" method="post" class="row g-3 needs-validation" novalidate>
		
			<input type="hidden" value="<%=request.getParameter("url")%>"
				name="url">

			<div class="col-md-6">
				<label class="form-label">Login:</label> 
				<input class="form-control"	id="login" name="login" type="text" required>
				          <div class="invalid-feedback">
        Preencha o nome de usuario.
      </div>

			</div>
			<div class="col-md-6">
				<label class="form-label">Senha:</label> 
				<input class="form-control"	id="senha" name="senha" type="password" required>
				<div class="invalid-feedback">
        Preencha a senha.
      </div></div>
				
			<!--<div class="col-md-6">
				<button type="submit" class="btn btn-primary">Acessar</button> -->
				<input type="submit" value="Acessar" class= "btn btn-primary">
			<!--</div>-->


		</form>

		<h4 class="msg">${msg}</h4>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
			crossorigin="anonymous"></script>
			
		<script type="text/javascript">
			// Example starter JavaScript for disabling form submissions if there are invalid fields
			(() => {
			  'use strict'

			  // Fetch all the forms we want to apply custom Bootstrap validation styles to
			  const forms = document.querySelectorAll('.needs-validation')

			  // Loop over them and prevent submission
			  Array.from(forms).forEach(form => {
			    form.addEventListener('submit', event => {
			      if (!form.checkValidity()) {
			        event.preventDefault()
			        event.stopPropagation()
			      }

			      form.classList.add('was-validated')
			    }, false)
			  })
			})()
		</script>
</body>
</html>