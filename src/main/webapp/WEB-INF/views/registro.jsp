<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="col-md-12">
	<sf:form modelAttribute="usuario" action="executarRegistro" enctype="multipart/form-data">
			<div class="form-group col-md-8">
				<label for="name">Nome<sf:errors path="nome" cssClass="erro"/></label>
				<sf:input path="nome" placeholder = "Nome" class="form-control"/>
			</div>

			<div class="form-group col-md-8">
				<label for="email">Email<sf:errors path="email" cssClass="erro"/></label>
				<sf:input path="email" placeholder = "Email" class="form-control"/>
			</div>

			<div class="form-group col-md-8">
				<label for="login">Login<sf:errors path="login" cssClass="erro"/></label>
				<sf:input path="login" placeholder = "Login" class="form-control"/>
			</div>					

			<div class="form-group col-md-8">
				<label for="password">Password<sf:errors path="password" cssClass="erro"/></label>			
				<sf:password path="password" placeholder = "Password" class="form-control"/>			
			</div>			

			<div class="form-group col-md-8">
				<label for="exampleInputFile">Avatar</label>
				<input type="file" id="exampleInputFile" name="avatar"/>
			</div>

			<div class="form-group col-md-8">
				<button type="submit" class="btn btn-default">Submit</button>			
			</div>			
	</sf:form>
</div>