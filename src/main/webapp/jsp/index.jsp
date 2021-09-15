<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js"
	integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/"
	crossorigin="anonymous"></script>
</head>

<body>

	<div class="row">

		<!-- Left Side  -->
		<div class="col"></div>

		<!-- Middle Section -->
		<div class="col-6">
			<h1>Contacts</h1>
			<hr />


			<div style="border-style: double">
				<c:forEach items="${contacts}" var="contact">
					<div class="row" style="padding: 30px">
						<div class="col">
							<div class="row">
								Name:
								<c:out value="${contact.firstName } ${contact.lastName }" />
							</div>
						</div>
						<div class="col">
							<c:forEach items="${contact.phoneNumbers}" var="phn">
								<div class="row">
									Phone Num:
									<c:out value="${phn}" />
								</div>
							</c:forEach>
						</div>
					</div>

					<div class="row">

						<div class="col-1"></div>
						<div class="col-8">
							<c:forEach items="${contact.address }" var="addr">
								<hr />
								<div class="row">
									<div class="col">Address</div>
									<div class="col-8">
										<c:out value="${addr.address1 }" />
										<c:out value="${addr.address2 }" />
										<br />
										<c:out value="${addr.city }, ${addr.state }, ${addr.zipCode }" />
									</div>
								</div>
							</c:forEach>

						</div>
						<div class="col"></div>

					</div>
					<hr />
				</c:forEach>
			</div>


		</div>
		<!-- Right Side -->
		<div class="col">
			<br /> <br /> <br /> <br /> <br /> <br />
			<div class="col-11">
				<h4>Add New Contact</h4>
				<hr />

				<form name="addContactForm" method="post" action="/">

					<div class="form-row">
						<div class="form-group col-md-9">
							<label for="inputfName">First Name</label> <input type="text"
								class="form-control" id="inputfName" name="inputfName"
								placeholder="Enter First Name">
						</div>
						<div class="form-group col-md-9">
							<label for="inputlName">Last Name</label> <input type="text"
								class="form-control" id="inputlName" name="inputlName"
								placeholder="Enter Last Name">
						</div>
						<div class="form-grpup col-md-9">
							<label for="inputPhone">Phone Number</label> <input type="text"
								class="form-control" id="inputPhone" name="inputPhone"
								placeholder="Enter phone number">
						</div>
						<div class="form-group col-md-9">
							<label for="inputAddress">Address</label> <input type="text"
								class="form-control" id="inputAddress"
								placeholder="1234 Main St">
						</div>
						<div class="form-group col-md-6">
							<label for="inputCity">City</label> <input type="text"
								class="form-control" id="inputCity">
						</div>
						<div class="form-group col-md-4">
							<label for="inputState">State</label> <select id="inputState"
								class="form-control">
								<option selected>Choose...</option>
								<option>...</option>
							</select>
						</div>
						<div class="form-group col-md-3">
							<label for="inputZip">Zipcode</label> <input type="text"
								class="form-control" id="inputZip">
						</div>
					</div>

					<br /> <input type="submit" value="Save" class="btn btn-primary" />
				</form>

			</div>
			<div class="col-1"></div>
		</div>

	</div>


</body>
</html>