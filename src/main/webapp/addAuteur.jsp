<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Freelancer - Start Bootstrap Theme</title>
<!-- Font Icon -->
<link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">
<!-- Main css -->
<link rel="stylesheet" href="css/style.css">
<!-- SweetAlert -->
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css">
</head>
<body>

<div class="main">
    <!-- Ajout d'auteur form -->
    <section class="signup">
        <div class="container">
            <div class="signup-content">
                <div class="signup-form">
                    <h2 class="form-title">Add author</h2>
                    <form method="post" action="AddAuteurServlet" class="register-form" id="register-form">
                        <div class="form-group">
                            <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                            <input type="text" name="name" id="name" placeholder="Author name " required/>
                        </div>
                        
                        <div class="form-group form-button">
                            <input type="submit" name="signup" id="signup" class="form-submit" value="Submit" />
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>
</div>

<!-- Script pour afficher la notification SweetAlert -->
	<script type="text/javascript">
		var status = document.getElementById("status").value;
	    if (status== 'success') {
	        swal("Congrat", "Author Added Successfully.", "success");
	    }
	    else{
	    	swal("Error", "Failed To Added Author.", "success");
	    }
	</script>

</body>
</html>
