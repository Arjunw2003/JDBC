<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="en">

<head>


<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Student Profile</title>

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<style>
body {
	background-color: #f2f4f7;
	font-family: Arial, sans-serif;
}

.profile-container {
	max-width: 850px;
	margin: 50px auto;
}

.profile-card {
	background-color: white;
	border-radius: 15px;
	padding: 35px;
	box-shadow: 0px 5px 20px rgba(0, 0, 0, 0.15);
}

.profile-title {
	text-align: center;
	font-weight: bold;
	margin-bottom: 30px;
}

.profile-header {
	text-align: center;
	padding-bottom: 25px;
	border-bottom: 1px solid #ddd;
	margin-bottom: 25px;
}

.profile-icon {
	width: 100px;
	height: 100px;
	border-radius: 50%;
	background-color: #0d6efd;
	color: white;
	font-size: 45px;
	display: flex;
	align-items: center;
	justify-content: center;
	margin: 0 auto 15px;
}

.student-name {
	font-size: 26px;
	font-weight: bold;
}

.info-box {
	background-color: #f8f9fa;
	padding: 15px;
	border-radius: 8px;
	margin-bottom: 15px;
}

.info-label {
	font-weight: bold;
	color: #555;
}

.info-value {
	color: #222;
}
</style>

</head>

<body>

	<div class="container profile-container">

			<div class="profile-card">

			<h2 class="profile-title">Student Profile</h2>


			<!-- Profile Header -->

			<div class="profile-header">

				<div class="profile-icon">👤</div>

				<div class="student-name">

					<%=session.getAttribute("fname")%>
					<%=session.getAttribute("lname")%>

				</div>

				<p class="text-muted">Student</p>

			</div>


			<!-- Personal Information -->

			<h5 class="mb-3">Personal Information</h5>

			<div class="row">


				<div class="col-md-6">

					<div class="info-box">

						<span class="info-label"> First Name: </span> <span
							class="info-value"> <%=session.getAttribute("fname")%>
						</span>

					</div>

				</div>


				<div class="col-md-6">

					<div class="info-box">

						<span class="info-label"> Last Name: </span> <span
							class="info-value"> <%=session.getAttribute("lname")%>
						</span>

					</div>

				</div>


				<div class="col-md-6">

					<div class="info-box">

						<span class="info-label"> Age: </span> <span class="info-value">
							<%=session.getAttribute("age")%>
						</span>

					</div>

				</div>


				<div class="col-md-6">

					<div class="info-box">

						<span class="info-label"> Gender: </span> <span class="info-value">
							<%=session.getAttribute("gender")%>
						</span>

					</div>

				</div>


				<div class="col-md-6">

					<div class="info-box">

						<span class="info-label"> City: </span> <span class="info-value">
							<%=session.getAttribute("city")%>
						</span>

					</div>

				</div>


				<div class="col-md-6">

					<div class="info-box">

						<span class="info-label"> Mobile No: </span> <span
							class="info-value"> <%=session.getAttribute("mobile")%>
						</span>

					</div>

				</div>


				<div class="col-md-6">

					<div class="info-box">

						<span class="info-label"> Email: </span> <span class="info-value">
							<%=session.getAttribute("email")%>
						</span>

					</div>

				</div>


				<div class="col-md-6">

					<div class="info-box">

						<span class="info-label"> Date of Birth: </span> <span
							class="info-value"> <%=session.getAttribute("dob")%>
						</span>

					</div>

				</div>

			</div>


			<!-- Academic Information -->

			<h5 class="mt-4 mb-3">Academic Information</h5>

			<div class="row">


				<div class="col-md-4">

					<div class="info-box text-center">

						<div class="info-label">10th Percentage</div>

						<div class="fs-4">

							<%=session.getAttribute("tenthPercentage")%>%

						</div>

					</div>

				</div>


				<div class="col-md-4">

					<div class="info-box text-center">

						<div class="info-label">12th Percentage</div>

						<div class="fs-4">

							<%=session.getAttribute("twelfthPercentage")%>%

						</div>

					</div>

				</div>


				<div class="col-md-4">

					<div class="info-box text-center">

						<div class="info-label">Graduation</div>

						<div class="fs-4">

							<%=session.getAttribute("graduationPercentage")%>%

						</div>

					</div>

				</div>

			</div>


			<!-- Logout -->

			<div class="text-center mt-4">

				<a href="login.html" class="btn btn-danger px-5"> Logout </a>

			</div>

		</div>
		```

	</div>

</body>

</html>
