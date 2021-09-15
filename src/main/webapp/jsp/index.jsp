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

		<!-- Left Side Blank -->
		<div class="col-3"></div>

		<!-- Contacts -->
		<div class="col-5">
			<h1>Contacts</h1>
			<hr />


			<c:forEach items="${contacts}" var="contact">

				<div style="box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2); padding:30px">
					<div class="row">
						<h3>
							<c:out value="${contact.firstName } ${contact.lastName }" />
						</h3>
					</div>
					<div class="row">
						<c:forEach items="${contact.phoneNumbers}" var="phn">
							<div class="row">
								
								<c:out value="Phone Num: ${phn}" />
							</div>
						</c:forEach>
					</div>

					<div class="row">
						<div class="col-1"></div>
						<div class="col-8">
							<c:forEach items="${contact.address }" var="addr">
								<hr />
								<div class="row">
									<div class="col">
										<c:out value="${addr.addressType } Address" />
									</div>
									<div class="col-8">
										<c:out value="${addr.address1 }" />
										<c:out value="${addr.address2 }" />
										<br />
										<c:out value="${addr.city }, ${addr.state }, ${addr.zipCode }" />
									</div>
								</div>
							</c:forEach>
						</div>
						<div class="col-2"></div>
					</div>
					<hr />
				</div>
				<br/>
			</c:forEach>



		</div>
		<!-- Add New Contact -->
		<div class="col-3">
			<br /> <br /> <br />
			<div class="col-11"
				style="box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2); padding: 10px">
				<h4>Add New Contact</h4>
				<hr />
				<h6 style="color:red"><c:out value="${err}" /></h5>
				<form name="addContactForm" method="post" action="/">

					<div class="form-row">
						<div class="form-group col-md-9">
							<label for="inputfName">First Name* </label> <input type="text"
								class="form-control" id="inputfName" name="inputfName"
								placeholder="Enter First Name">
						</div>
						<div class="form-group col-md-9">
							<label for="inputlName">Last Name*</label> <input type="text"
								class="form-control" id="inputlName" name="inputlName"
								placeholder="Enter Last Name">
						</div>
						<div class="form-grpup col-md-9">
							<label for="inputPhone">Phone Number*</label> <input type="text"
								class="form-control" id="inputPhone" name="inputPhone"
								placeholder="Enter phone number">
						</div>
						<div class="form-group col-md-9">
							<label for="inputAddress">Address*</label> <input type="text"
								class="form-control" id="inputAddress" name="inputAddress"
								placeholder="1234 Main St">
						</div>
						<div class="form-group col-md-9">
							<label for="inputAddress2">Address 2</label> <input type="text"
								class="form-control" id="inputAddress2" name="inputAddress2"
								placeholder="apt 3">
						</div>
						<div class="form-group col-md-6">
							<label for="inputCity">City*</label> <input type="text"
								class="form-control" id="inputCity" name="inputCity"
								placeholder="New York">
						</div>
						<div class="form-group col-md-4">
							<label for="inputState">State*</label> <select id="inputState"
								name="inputState" class="form-control">
								<option selected>...</option>
								<option value="AL">Alabama</option>
								<option value="AK">Alaska</option>
								<option value="AZ">Arizona</option>
								<option value="AR">Arkansas</option>
								<option value="CA">California</option>
								<option value="CO">Colorado</option>
								<option value="CT">Connecticut</option>
								<option value="DE">Delaware</option>
								<option value="DC">District Of Columbia</option>
								<option value="FL">Florida</option>
								<option value="GA">Georgia</option>
								<option value="HI">Hawaii</option>
								<option value="ID">Idaho</option>
								<option value="IL">Illinois</option>
								<option value="IN">Indiana</option>
								<option value="IA">Iowa</option>
								<option value="KS">Kansas</option>
								<option value="KY">Kentucky</option>
								<option value="LA">Louisiana</option>
								<option value="ME">Maine</option>
								<option value="MD">Maryland</option>
								<option value="MA">Massachusetts</option>
								<option value="MI">Michigan</option>
								<option value="MN">Minnesota</option>
								<option value="MS">Mississippi</option>
								<option value="MO">Missouri</option>
								<option value="MT">Montana</option>
								<option value="NE">Nebraska</option>
								<option value="NV">Nevada</option>
								<option value="NH">New Hampshire</option>
								<option value="NJ">New Jersey</option>
								<option value="NM">New Mexico</option>
								<option value="NY">New York</option>
								<option value="NC">North Carolina</option>
								<option value="ND">North Dakota</option>
								<option value="OH">Ohio</option>
								<option value="OK">Oklahoma</option>
								<option value="OR">Oregon</option>
								<option value="PA">Pennsylvania</option>
								<option value="RI">Rhode Island</option>
								<option value="SC">South Carolina</option>
								<option value="SD">South Dakota</option>
								<option value="TN">Tennessee</option>
								<option value="TX">Texas</option>
								<option value="UT">Utah</option>
								<option value="VT">Vermont</option>
								<option value="VA">Virginia</option>
								<option value="WA">Washington</option>
								<option value="WV">West Virginia</option>
								<option value="WI">Wisconsin</option>
								<option value="WY">Wyoming</option>
							</select>
						</div>
						<div class="form-group col-md-3">
							<label for="inputZip">Zipcode*</label> <input type="text"
								class="form-control" id="inputZip" name="inputZip">
						</div>
						<div class="form-group col-md-3">
							<label for="inputAddressType">Address Type</label> <select
								id="inputAddressType" name="inputAddressType"
								class="form-control">
								<option selected>Home</option>
								<option selected>Work</option>
						</div>
					</div>
					<br /> <input type="submit" id="btnSubmit" name="btnSubmit"
						value="Add Contact" class="btn btn-block btn-primary" />
				</form>



			</div>
			<div class="col-1"></div>
		</div>

		<!-- Right Side Blank -->
		<div class="col-1"></div>
	</div>


</body>
</html>